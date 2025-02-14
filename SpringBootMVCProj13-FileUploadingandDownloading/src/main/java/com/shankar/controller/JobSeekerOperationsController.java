package com.shankar.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shankar.entity.JobSeekerInformation;
import com.shankar.model.JobSeekerDetails;
import com.shankar.service.JobSeekerMgmtService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class JobSeekerOperationsController {
	@Autowired
	private Environment env;
	@Autowired
	private JobSeekerMgmtService service;
 @RequestMapping("/")
	public String showHomepage() {
		return "welcome";
	}
 @GetMapping("/register")
 public String registerjobSeeker(@ModelAttribute("js")JobSeekerDetails details) {
	 System.out.println("JobSeekerOperationsController.registerjobSeeker()");
	 return "register_form";
 }
 @PostMapping("/register")
 private String processTheJobSeeker(@ModelAttribute("js") JobSeekerDetails details,Map<String,Object> map)throws Exception {
	 //specify the folder location
	 String locationFolder=env.getRequiredProperty("upload.store");
	 //if that is not available create it
	 File file=new File(locationFolder);
	 if(!file.exists())
		 file.mkdir();
	 //get input streams represnts upload contents
	 MultipartFile resumeFile=details.getResume();
	 MultipartFile photoFile=details.getPhoto();
	 InputStream isresume=resumeFile.getInputStream();
	 InputStream isphoto=photoFile.getInputStream();
	 //get the names of uploaded files
	 String resumefilename=resumeFile.getOriginalFilename();
	 String photofilename=photoFile.getOriginalFilename();
	 //create output stream representing empty destination files
	 OutputStream osresume=new FileOutputStream(file.getAbsolutePath()+"/"+resumefilename);
	 OutputStream osphoto=new FileOutputStream(file.getAbsolutePath()+"/"+photofilename);
	 //perform file copy operation
	 IOUtils.copy(isresume, osresume);
	 IOUtils.copy(isphoto, osphoto);
//close connections
	 isresume.close();osresume.close();
	 isphoto.close();osphoto.close();
	 //prepare entity class object having model data
	 JobSeekerInformation info=new JobSeekerInformation();
	 info.setJsName(details.getJsName());
	 info.setJsAddress(details.getJsAddress());
	String resumepath=(file.getAbsolutePath()+"/"+resumefilename).replace("/","\\");
	String photopath=(file.getAbsolutePath()+"/"+photofilename).replace("/","\\");
	info.setResumePath(resumepath);
	info.setPhotoPath(photopath);
	//use service
	String msg=service.saveTheJobSeeker(info);
	//keep the uploaded file names in model attributes
	map.put("file1",resumefilename);
	map.put("file2",photofilename);
	map.put("resultMsg",msg);
	return "show_result";
 }
 @GetMapping("/getalljobSeekers")
 public String getAllEmployees(Map<String,Object> map) {
	System.out.println("JobSeekerOperationsController.getAllEmployees()");
	//use service
	List<JobSeekerInformation> list=service.getAllJobseekers();
	System.out.println(list.size());
map.put("jsList", list);
	return "show_report";
 }
 @GetMapping("/download")
 public String downloadFile(HttpServletRequest req,HttpServletResponse res,@RequestParam("jsid") int jsid,@RequestParam("type") String type) throws Exception{
	 // get the path of the file to be downloaded
	 String filepath=null;
	 if(type.equalsIgnoreCase("resume")) 
		 filepath=service.fetchtResumePathByJsid(jsid);
	 
	 else
		 filepath=service.fetchPhotoPathByJsid(jsid);
 System.out.println(filepath);
 //create the file 
 File file =new File(filepath);
 //get the length of the file
 res.setContentLengthLong(file.length());
 //create servlet context object 
 ServletContext sc=req.getServletContext();
 //get the mime type
 String mimetype=sc.getMimeType(filepath);
 mimetype=mimetype==null?"application/octet-stream":mimetype;
 res.setContentType(mimetype);
 //create input stream pointing the file
 InputStream is=new FileInputStream(file);
 //create outputstream pointing to the res object
 OutputStream os=res.getOutputStream();
 //instrcut browser to to give the file as download
 res.setHeader("Content-Disposition", "attachment;fileName="+file.getName());
 //write file content to res object
 IOUtils.copy(is, os);
 is.close();
 os.close();
 return null;
 }
}
