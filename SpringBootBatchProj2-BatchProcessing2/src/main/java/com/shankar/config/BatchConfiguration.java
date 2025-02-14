package com.shankar.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shankar.listener.JobMonitoringListener;
import com.shankar.processor.BookInfoItemProcessor;
import com.shankar.reader.BookInfoItemReader;
import com.shankar.writer.BookInfoItemWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	@Autowired
	private JobBuilderFactory jobfactory;
	@Autowired
	private StepBuilderFactory stepfactory;
	@Autowired
	private JobMonitoringListener listener;
@Autowired
	private BookInfoItemReader reader;
@Autowired
private BookInfoItemProcessor processor;
@Autowired
private BookInfoItemWriter writer;
@Bean(name="step1")
public Step createStep1() {
	return stepfactory.get("step1").
			<String,String>chunk(2).
			reader(reader).
			writer(writer).
			processor(processor)
			.build();

}
@Bean(name="job1")
public Job createJob() {
	return jobfactory.get("job1")
			.incrementer(new RunIdIncrementer())
			.listener(listener).
			start(createStep1())
			.build();
			
}
	
}
