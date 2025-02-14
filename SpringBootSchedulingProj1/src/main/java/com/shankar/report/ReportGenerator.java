package com.shankar.report;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("report")
public class ReportGenerator {
	/*@Scheduled(initialDelay = 2000,fixedDelay = 3000)
	public void generateSalesReport() {
		System.out.println("ReportGenerator.generateSalesReport()");
		System.out.println("Sales report Generated on::::::::::"+new Date());
	}*/
	/*@Scheduled(fixedDelay = 3000)
	public void generateSalesReport() {
		System.out.println("ReportGenerator.generateSalesReport()");
		System.out.println("Sales report Generated on::::::::::"+new Date());
	}*/
	/*@Scheduled(fixedDelayString = "3000")
	public void generateSalesReport() {
		System.out.println("ReportGenerator.generateSalesReport()");
		//System.out.println("Sales report Start Generated on::::::::::"+new Date()+"(start)");
		try {
			Thread.sleep(5000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(" Report Generation:::::::"+new Date());
	}*/
	/*@Scheduled(fixedRate = 10000)
	public void generateSalesReport() {
		System.out.println("ReportGenerator.generateSalesReport()");
		System.out.println("Sales report Start Generated on::::::::::"+new Date()+"(start)");
		try {
			Thread.sleep(15000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(" end Report Generation:::::::"+new Date());
	}*/
	/*@Scheduled(initialDelay = 2000,fixedRate = 5000)
	public void generateReport() {
		System.out.println("thread(task1) name:::"+Thread.currentThread().getName());
	System.out.println("thread(task1) hashcode:::"+Thread.currentThread().hashCode());
	System.out.println("Task 1 Report Generated On::"+new Date());
	}
	@Scheduled(fixedDelay = 3000, initialDelay = 2000)
	public void generateReport1() {
		System.out.println("thread(task2) name:::"+Thread.currentThread().getName());
	System.out.println("thread(task2) hashcode:::"+Thread.currentThread().hashCode());
	System.out.println("Task 2 Report Generated On::"+new Date());
	}*/
	/*@Scheduled(cron = "15 * * * * *")
	public void generateReport() {
		System.out.println("ReportGenerator.generateReport()");
		System.out.println("Report Generation::::::"+new Date());
	}*/
	@Scheduled(cron = "0/10 0 8 15 8 *")
	public void generateReport() {
		//System.out.println("ReportGenerator.generateReport()");
		System.out.println("Happy Independence Day");
		System.out.println("Report Generation::::::"+new Date());
	}
}
