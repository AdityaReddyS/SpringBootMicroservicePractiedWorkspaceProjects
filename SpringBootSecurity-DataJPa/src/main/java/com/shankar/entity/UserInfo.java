package com.shankar.entity;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="SECURITY_USERS")
@Data
public class UserInfo {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "UNID_SEQUENCE_ID",allocationSize = 100,initialValue = 1)
	@GeneratedValue(generator ="gen1",strategy = GenerationType.SEQUENCE)
private Integer unid;
	@Column(length =30,unique =true,nullable = false)
private String uname;
	@Column(length =150,nullable = false)
private String pwd;
	@Column(length =50,nullable = false)
private String email;
private Boolean status=true;
@ElementCollection(fetch = FetchType.EAGER)
@CollectionTable(name = "SECURITY_ROLES", 
joinColumns = @JoinColumn(columnDefinition = "USER_ID",referencedColumnName = "unid"))
@Column(name="role")
private Set<String> roles;

}
