package com.shankar.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shankar.entity.JobSeekerInformation;

public interface JobSeekerRepository  extends JpaRepository<JobSeekerInformation, Integer>{
	@Query(name="select resumePath from JobSeekerInformation where jsid=:id")
public String getResumePathByjsid(Integer id);
	@Query(name="select photoPath from JobSeekerInformation where jsid=:id")
	public String getPhotoPathByjsid(Integer id);
}
