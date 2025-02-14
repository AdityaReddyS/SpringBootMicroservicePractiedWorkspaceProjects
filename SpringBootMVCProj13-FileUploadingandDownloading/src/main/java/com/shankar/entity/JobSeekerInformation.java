package com.shankar.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="BOOT_JSEEKER_INFO")
public class JobSeekerInformation implements Serializable{
	@Id
	@GeneratedValue
private Integer jsid;
	@Column(length = 50)
private String jsName;
	@Column(length = 150)
private String jsAddress;
	@Column(length = 200)
private String resumePath;
	@Column(length = 200)
private String photoPath;
}
