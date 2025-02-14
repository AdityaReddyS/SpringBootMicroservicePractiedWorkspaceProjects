package com.shankar.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class JobSeekerDetails implements Serializable{
	private Integer JsId;
		private String jsName;
		private String jsAddress;
		private MultipartFile resume;
		private MultipartFile photo;
		
		}


