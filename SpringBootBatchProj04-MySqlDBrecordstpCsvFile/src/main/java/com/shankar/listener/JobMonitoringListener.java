package com.shankar.listener;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;
@Component
public class JobMonitoringListener implements JobExecutionListener {
	private long start,end;
@Override
public void beforeJob(JobExecution jobExecution) {
	start=System.currentTimeMillis();
	System.out.println("Job is about to Start:::"+new Date());
}
@Override
	public void afterJob(JobExecution jobExecution) {
		end=System.currentTimeMillis();
		System.out.println("Job is completed:::"+new Date());
				System.out.println("Job Execution Time:::"+(end-start)+" ms");
				System.out.println("Job Completion Status::"+jobExecution.getStatus());
	}
}
