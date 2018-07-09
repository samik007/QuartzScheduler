package com.samik.quartzScheduler;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

public class SimpleTriggerExample {
	public static void main(String[] args) throws Exception{
		JobKey jobKey = new JobKey("dummyJobName", "group1");
		JobDetail job = JobBuilder.newJob(HelloJob.class)
							.withIdentity(jobKey).build();
		
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("dummyTriggerName", "group1")
				.withSchedule(
						CronScheduleBuilder.cronSchedule("0 0/1 * ? * *"))
				.build();
		
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.getListenerManager().addJobListener(
	    		new HelloJobListener(), KeyMatcher.keyEquals(jobKey));
		scheduler.scheduleJob(job, trigger);
		scheduler.start();
	}
}
