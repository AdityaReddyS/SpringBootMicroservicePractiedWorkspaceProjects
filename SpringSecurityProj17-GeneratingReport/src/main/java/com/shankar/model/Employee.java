package com.shankar.model;

import java.io.Serializable;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name="BOOT_EMP")
public class Employee implements Serializable {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "BOOT_EMP_EMP_NO_SEQ_GENERATOR",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer empno;
	@Column(length = 20)
	private String ename;
	@Column(length = 20)
	private String job="CLERK";

	private Double sal;
	
	private Integer deptno;
	
	
	

}
