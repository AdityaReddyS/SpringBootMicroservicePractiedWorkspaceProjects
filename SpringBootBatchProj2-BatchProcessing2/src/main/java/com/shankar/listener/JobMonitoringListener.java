package com.shankar.listener;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;
@Component("jLauncher")
public class JobMonitoringListener implements JobExecutionListener {
private long startTime,endTime;

@Override
	public void beforeJob(JobExecution jobExecution) {
	System.out.println("JobMonitoringListener.beforeJob()");
	System.out.println("Job Launched at::"+new Date());
	startTime=System.currentTimeMillis();
	System.out.println("Job Status::"+jobExecution.getStatus());
	}

@Override
	public void afterJob(JobExecution jobExecution) {
	System.out.println("JobMonitoringListener.afterJob()");
System.out.println("Job Completed::"+new Date());
endTime=System.currentTimeMillis();
System.out.println("Job Status::"+jobExecution.getStatus());
System.out.println("Job Execution Time::"+(endTime-startTime)+" ms");
System.out.println("Job Exit Status::"+jobExecution.getExitStatus());
}

}
