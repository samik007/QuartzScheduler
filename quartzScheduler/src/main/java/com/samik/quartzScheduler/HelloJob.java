package com.samik.quartzScheduler;

import java.time.LocalDateTime;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@DisallowConcurrentExecution
public class HelloJob implements Job {
	public synchronized void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Hello Quartz using cron: " + LocalDateTime.now().getHour() + ":"
												+ LocalDateTime.now().getMinute() + ":" 
													+ LocalDateTime.now().getSecond());
		try {
	        for(int i=0;i<20;i++) {
	        	System.out.print(i + " ");
	        	Thread.sleep( 1000 );
	        }
	        System.out.println();
	    } catch ( InterruptedException e ) {
	        e.printStackTrace();
	    }
	}
}
