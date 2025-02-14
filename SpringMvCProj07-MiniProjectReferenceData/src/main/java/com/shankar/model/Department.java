package com.shankar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name="BOOT_DEPT")
@Data
public class Department {
	@Id
private Integer deptno;
private String dname;
private String loc;
}
