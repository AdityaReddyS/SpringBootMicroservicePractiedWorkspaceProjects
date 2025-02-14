package com.shankar.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.shankar.model.ExamResult;

public class ExamRowMapper implements RowMapper<ExamResult> {

	@Override
	public ExamResult mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		return new ExamResult(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(1));
	}

}
