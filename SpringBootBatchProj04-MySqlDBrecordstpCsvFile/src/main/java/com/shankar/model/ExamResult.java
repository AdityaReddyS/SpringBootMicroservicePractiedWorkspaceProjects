package com.shankar.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data

@AllArgsConstructor
public class ExamResult {
private Integer id;
private String dob;
private Float percentage;
private Integer semester;
}
