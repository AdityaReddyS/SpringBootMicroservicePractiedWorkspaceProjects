package com.nt.runner;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobLaunchRunner  {
	@Autowired
	private  JobLauncher  launcher;
	@Autowired
	private  Job  job;

	@Scheduled(cron="${expression.value}")
	public void run() throws Exception {
		//create the Job params
		JobParameters params=new JobParametersBuilder().addDate("sysDate",new Date()).toJobParameters();
		//run  the job
		launcher.run(job, params);

	}

}
