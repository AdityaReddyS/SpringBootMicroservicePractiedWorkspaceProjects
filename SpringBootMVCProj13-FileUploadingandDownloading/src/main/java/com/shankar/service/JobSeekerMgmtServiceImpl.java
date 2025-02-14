package com.shankar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shankar.entity.JobSeekerInformation;
import com.shankar.repo.JobSeekerRepository;
@Service
public class JobSeekerMgmtServiceImpl implements JobSeekerMgmtService {
	@Autowired
private JobSeekerRepository repo;
	@Override
	public String saveTheJobSeeker(JobSeekerInformation information) {
	int idVal=repo.save(information).getJsid();
		return "Job Seeker is Saved with Id Value:::::::::::"+idVal;
	}
@Override
public List<JobSeekerInformation> getAllJobseekers() {

	return repo.findAll() ;
}
@Override
public String fetchtResumePathByJsid(Integer id) {
	
	return repo.getResumePathByjsid(id);
}
@Override
public String fetchPhotoPathByJsid(Integer id) {
	
	return repo.getPhotoPathByjsid(id);
}
}
