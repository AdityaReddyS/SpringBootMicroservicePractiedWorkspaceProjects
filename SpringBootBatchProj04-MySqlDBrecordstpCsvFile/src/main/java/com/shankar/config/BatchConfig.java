//BatchConfig.java
package com.shankar.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.shankar.listener.JobMonitoringListener;
import com.shankar.model.ExamResult;
import com.shankar.processor.ExamInfoItempProcessor;


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
	private ExamInfoItempProcessor  processor;
	@Autowired
	private  DataSource ds;
	
	@Bean(name="jcireader")
	public JdbcCursorItemReader<ExamResult> createReader(){
		return new JdbcCursorItemReaderBuilder<ExamResult>()
				.name("reader")
				.dataSource(ds)
				.sql("SELECT ID,DOB,PERCENTAGE,SEMESTER FROM EXAM_RESULT")
				.beanRowMapper(ExamResult.class).
				build();
				
	}
	@Bean(name="ffiwriter")
	public FlatFileItemReader<ExamResult> createWriter(){
		return new FlatFileItemReaderBuilder<ExamResult>()
				.name("writer")
				.resource(new ClassPathResource("TopBrains.csv"))
				
				.delimited().delimiter(",")
				.names(new String[] {"id","dob","percentage","semester"})
				.build();
	}
	
	@Bean(name="step1")
	public  Step createStep1() {
		   return  stepFactory.get("step1")
				            .<ExamResult,ExamResult>chunk(10)
				            .reader(createReader())
				            .writer((ItemWriter<? super ExamResult>) createWriter())
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
