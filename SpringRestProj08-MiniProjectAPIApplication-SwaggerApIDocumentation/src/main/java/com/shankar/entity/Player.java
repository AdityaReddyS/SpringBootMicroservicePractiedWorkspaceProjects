package com.shankar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="REST_PLAYER")
public class Player {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "PLAYER_ID_SEQ",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1" ,strategy = GenerationType.SEQUENCE)
	private Integer pid;
	@Column
	@NonNull
	private String pname;
	@Column
	@NonNull
	private String paddrs;
	@Column
	@NonNull
	private String pteam;
	@NonNull
	private Double pprice;

}
