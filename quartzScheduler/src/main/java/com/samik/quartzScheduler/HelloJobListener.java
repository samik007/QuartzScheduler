package com.samik.quartzScheduler;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class HelloJobListener implements JobListener {
	public static final String LISTENER_NAME = "dummyJobListenerName";

	public String getName() {
		return LISTENER_NAME;
	}

	public void jobExecutionVetoed(JobExecutionContext context) {
		System.out.println("jobExecutionVetoed");
	}

	public void jobToBeExecuted(JobExecutionContext context) {
		String jobName = context.getJobDetail().getKey().toString();
		System.out.println("Job : " + jobName + " is going to start...");

	}

	public void jobWasExecuted(JobExecutionContext context, JobExecutionException exception) {
		String jobName = context.getJobDetail().getKey().toString();
		System.out.println("Job : " + jobName + " is finished...");
		
		if(null != exception) {
			if (!exception.getMessage().equals("")) {
				System.out.println("Exception thrown by: " + jobName
						+ " Exception: " + exception.getMessage());
			}			
		}
		
		System.out.println("*************************************************");
	}

}
