package com.shankar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
private Integer aid;
private String aname;
private String aaddrs;
private Double salary;
}
