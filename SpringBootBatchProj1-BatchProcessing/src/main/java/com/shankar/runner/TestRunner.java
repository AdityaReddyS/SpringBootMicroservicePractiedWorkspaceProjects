package com.shankar.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class TestRunner implements CommandLineRunner {
	@Autowired
private JobLauncher launcher;
	@Autowired
	private Job job;
	@Override
	public void run(String... args) throws Exception {
		//prepare job parameters
		JobParameters parameters=new JobParametersBuilder().addLong("time",System.currentTimeMillis()).toJobParameters();
	JobExecution execution=launcher.run(job, parameters);
	}

}
