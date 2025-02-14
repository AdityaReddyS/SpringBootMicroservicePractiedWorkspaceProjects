package com.nt.document;




import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class OExamResult {
	private Integer id;
	private LocalDateTime dob;
	private Integer semester;
	private  Float  percentage;

}
