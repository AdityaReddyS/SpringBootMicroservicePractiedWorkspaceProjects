package com.nt.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class ExamResult {
	private Integer id;
	private Date dob;
	private Integer semester;
	private  Float  percentage;

}
