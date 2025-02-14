package com.shankar.service;

import java.util.List;

import com.shankar.entity.JobSeekerInformation;

public interface JobSeekerMgmtService {

	public String saveTheJobSeeker(JobSeekerInformation information);
	
	public List<JobSeekerInformation> getAllJobseekers();
	public String fetchtResumePathByJsid(Integer id);
	public String fetchPhotoPathByJsid(Integer id);
}
