//BatchConfig.java
package com.nt.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.nt.listener.JobMonitoringListener;
import com.nt.model.ExamResult;
import com.nt.processor.ExamResultProcessor;


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
	private  ExamResultProcessor  processor;
	@Autowired
	private DataSource ds;
	
	
		@Bean(name="jcireder")
		public JdbcCursorItemReader<ExamResult> createReader(){
			return new JdbcCursorItemReaderBuilder<ExamResult>().
					name("reader").
					dataSource(ds).
					sql("SELECT ID,DOB,PERCENTAGE,SEMESTER FROM EXAM_RESULT").
					beanRowMapper(ExamResult.class).
					build();
			
		}
	@Bean(name="ffiwriter")
		public FlatFileItemWriter<ExamResult> createWriter(){
			return new FlatFileItemWriterBuilder<ExamResult>().
					name("writer").
					resource(new FileSystemResource("src/maim/resources/TopBrains.csv")).
					delimited().delimiter(",").
					names(new String[] {"id","dob","percentage","semester"}).
					build();
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
