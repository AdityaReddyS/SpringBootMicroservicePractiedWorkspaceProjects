package com.nt.listener;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component("jobListener")
public class JobMonitoringListener implements JobExecutionListener {
	 private long start,end;
	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("JobMonitoringListener.Job Execution started at::"+new Date());
		start=System.currentTimeMillis();
		
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("JobMonitoringListener.Job Execution ended at::"+new Date());
		end=System.currentTimeMillis();
		System.out.println("Job Execution time is ::"+(end-start)+" ms");
		System.out.println("Job Execution status::"+jobExecution.getExitStatus());
	}

}
