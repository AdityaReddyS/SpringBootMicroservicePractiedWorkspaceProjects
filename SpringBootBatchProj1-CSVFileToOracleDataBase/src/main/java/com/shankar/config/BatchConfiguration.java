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
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

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
/*@Bean(name="ffireader")
	public FlatFileItemReader<Employee> createReader(){
		//create reader object
	
	FlatFileItemReader<Employee> reader=new FlatFileItemReader<Employee>();
	//set csv file as resource
	reader.setResource(new FileSystemResource("src/main/resources/EmployeeInfo.csv"));
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
public JdbcBatchItemWriter<Employee> createWriter(){
	//create Jdbc Item Writer
	JdbcBatchItemWriter<Employee> writer=new JdbcBatchItemWriter<Employee>();
	//set datasource to writer object
	writer.setDataSource(ds);
	//set insert sql query with the named parameters
	writer.setSql("INSERT INTO  EMPLOYEE_INFO VALUES(:ENO,:ENAME,:EADD,:SALARY,:GROSSSALARY,:NETSALARY)");
//create beanpropertyitemsqlparametersourceprovider object
	BeanPropertyItemSqlParameterSourceProvider<Employee> sourceProvider=new BeanPropertyItemSqlParameterSourceProvider<Employee>();
	//set source provider to writer object
	writer.setItemSqlParameterSourceProvider(sourceProvider);
return writer;
}*/
	/*@Bean(name="reader")
	public FlatFileItemReader<Employee> createReader(){
		//create reader object
	FlatFileItemReader<Employee> reader=new FlatFileItemReader<Employee>();
	//set csv file as resource
	reader.setResource(new ClassPathResource("EmployeeInfo.csv"));
	//set line mapper object
	reader.setLineMapper(new DefaultLineMapper<Employee>() {{
	//set delimited tokenized object
		setLineTokenizer(new DelimitedLineTokenizer() {{
			setDelimiter(",");
			setNames("eno","ename","eadd","salary");
		}});
		setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {{
			setTargetType(Employee.class);
		}});
		
	}});
	return reader;
	}
	@Bean(name="biwriter")
	public JdbcBatchItemWriter<Employee> createWriter(){
		//create Jdbc Item Writer
		JdbcBatchItemWriter<Employee> writer=new JdbcBatchItemWriter<Employee>() {{
			setDataSource(ds);
			setSql("INSERT INTO EMPLOYEE_INFO VALUES(:ENO,:ENAME,:EADD,:SALARY,:GROSSSALARY,:NETSALARY");
		setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
		}};
	return writer;
	}*/
	@Bean(name="reader")
	public FlatFileItemReader<Employee> createReader(){
	return new FlatFileItemReaderBuilder<Employee>().
			name("reader").
			resource(new ClassPathResource("EmployeeInfo.csv")).
			delimited().
			names("eno","ename","eadd","salary").
			targetType(Employee.class).build();
	
	}
	@Bean(name="biwriter")
	public JdbcBatchItemWriter<Employee> createWriter(){
	return new JdbcBatchItemWriterBuilder<Employee>().
			dataSource(ds).
			sql("INSERT INTO EMPLOYEE_INFO VALUES(:ENO,:ENAME,:EADD,:SALARY,:GROSSSALARY,:NETSALARY").
			beanMapped().build();
	
	}
@Bean(name="step1")
public Step createStep1() {
return stepbuilder.get("step1").
		<Employee,Employee>chunk(10).
		reader(createReader()).
		processor(processor).
		writer(createWriter()).
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
