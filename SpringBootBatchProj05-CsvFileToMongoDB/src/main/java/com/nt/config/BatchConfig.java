//BatchConfig.java
package com.nt.config;



import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;

import org.springframework.batch.item.file.FlatFileItemReader;

import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.nt.listener.JobMonitoringListener;
import com.nt.model.ExamResult;
import com.nt.processor.ExamResultItemProcessor;


@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jobFactory;
	@Autowired
	private  StepBuilderFactory  stepFactory;
	@Autowired
	private  JobMonitoringListener listener;
	@Autowired
	private ExamResultItemProcessor  processor;
	@Autowired
	private MongoTemplate template;
	
	
	
	@Bean(name="reader")
	public   FlatFileItemReader<ExamResult> createReader(){
		return  new FlatFileItemReaderBuilder<ExamResult>()
				       .name("reader")
				      .resource(new ClassPathResource("TopBrains.csv"))
				      .delimited().delimiter(",")
				      .names("id","dob","semester","percentage")
				      .targetType(ExamResult.class)
				      .build();
	}
	
	
	
	
	@Bean(name="writer")
	public   MongoItemWriter<ExamResult>  createWriter(){
		return new  MongoItemWriterBuilder<ExamResult>()
				     .collection("SuperBrains")
				     .template(template)
				     .build();
	}				       
			
		
	
	
	
	@Bean(name="step1")
	public  Step createStep1() {
		   return  stepFactory.get("step1")
				            .<ExamResult,ExamResult>chunk(10)
				            .reader(createReader())
				            .writer(createWriter())
				            .processor(processor)
				            .build();
		   
	}
 	
	@Bean(name="job1")
	public  Job createJob1() {
		  return  jobFactory.get("job1")
				       .incrementer(new RunIdIncrementer())
				       .listener(listener)
				       .start(createStep1())
				       .build();
				       
                     	}
	
  }
