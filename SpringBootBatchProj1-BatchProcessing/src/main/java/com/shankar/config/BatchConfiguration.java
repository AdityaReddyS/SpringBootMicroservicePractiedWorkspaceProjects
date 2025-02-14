package com.shankar.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.shankar.listener.JobMonitoringListener;
import com.shankar.model.Employee;
import com.shankar.processor.EmployeeInfoItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	@Autowired
	private JobBuilderFactory jobbuilder;
	@Autowired
	private StepBuilderFactory stepbuilder;
	@Autowired
	private JobMonitoringListener listener;
	@Autowired
	private EmployeeInfoItemProcessor processor;
	@Autowired
	private DataSource  ds;
@Bean(name="ffireader")
	public FlatFileItemReader<Employee> createFFIReader(){
		//create reader object
	
	FlatFileItemReader<Employee> reader=new FlatFileItemReader<Employee>();
	//set csv file as resource
	reader.setResource(new ClassPathResource("Employee_Info.csv"));
	//create linemapper object to get each line from csv file
	DefaultLineMapper<Employee>  linemapper=new DefaultLineMapper<Employee>();
	//create line tokenizer to get tokens from lines
	DelimitedLineTokenizer tokenizer=new DelimitedLineTokenizer();
	tokenizer.setDelimiter(",");
	tokenizer.setNames("eno","ename","eadd","salary");
	//create field set mapper  to set tokens to the model class object
	BeanWrapperFieldSetMapper<Employee> fieldsetMapper=new BeanWrapperFieldSetMapper<Employee>();
	fieldsetMapper.setTargetType(Employee.class);
	//set tokenizer,fieldset mapper objects to LineMapper
	linemapper.setFieldSetMapper(fieldsetMapper);
	linemapper.setLineTokenizer(tokenizer);
	//set linemapper to reader object
	reader.setLineMapper(linemapper);
	return reader;
	}
@Bean(name="biwriter")
public JdbcBatchItemWriter<Employee> createJdbcItemWriter(){
	//create Jdbc Item Writer
	JdbcBatchItemWriter<Employee> writer=new JdbcBatchItemWriter<Employee>();
	//set datasource to writer object
	writer.setDataSource(ds);
	//set insert sql query with the named parameters
	writer.setSql("insert into employee_info values(:eno,:ename,:eadd,:salary,:grossSalary,:netSalary)");
//create beanpropertyitemsqlparametersourceprovider object
	BeanPropertyItemSqlParameterSourceProvider<Employee> sourceProvider=new BeanPropertyItemSqlParameterSourceProvider<Employee>();
	//set source provider to writer object
	writer.setItemSqlParameterSourceProvider(sourceProvider);
return writer;
}
@Bean(name="step1")
public Step createStep1() {
return stepbuilder.get("step1").
		<Employee,Employee>chunk(5).
		reader(createFFIReader()).
		writer(createJdbcItemWriter()).
		processor(processor).
		build();
}
@Bean(name="job1")
public Job createJob1() {
	return jobbuilder.get("job1").listener(listener).
			incrementer(new RunIdIncrementer()).
			start(createStep1()).
			build();
}





}
