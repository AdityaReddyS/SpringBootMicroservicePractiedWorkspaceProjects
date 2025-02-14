package com.shankar.entity;

import java.io.Serializable;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="MSMP_IPL_TEAM_INFO")
@Setter
@Getter
@RequiredArgsConstructor
public class IPLTeam implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer teamId;
	@NonNull
	@Column(length = 20)
	private   String  teamName;
	@NonNull
	@Column(length = 20)
	private   String owner;
	@NonNull
	@Column(length = 20)
	private   String  area;
	
	public IPLTeam() {
	 System.out.println("IPLTeam::0-param constructor");
	}

	@Override
	public String toString() {
		return "IPLTeam [teamId=" + teamId + ", teamName=" + teamName + ", owner=" + owner + ", area=" + area + "]";
	}
}
