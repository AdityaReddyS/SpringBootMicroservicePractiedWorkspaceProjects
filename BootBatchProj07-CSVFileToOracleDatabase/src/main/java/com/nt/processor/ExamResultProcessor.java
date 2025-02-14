package com.nt.processor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.document.OExamResult;
import com.nt.model.IExamResult;

@Component
public class ExamResultProcessor implements ItemProcessor<IExamResult, OExamResult> {

	@Override
	public OExamResult process(IExamResult item) throws Exception {
		
		if(item.getPercentage()>=95.0) {
			OExamResult result=new OExamResult();
			result.setId(item.getId());
			result.setDob(LocalDateTime.parse(item.getDob(),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")));
		result.setPercentage(item.getPercentage());
		result.setSemester(item.getSemester());
		   return result;
		}
		else
			return  null;
	}

}
