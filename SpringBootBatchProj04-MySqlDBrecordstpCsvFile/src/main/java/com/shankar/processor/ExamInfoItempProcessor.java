package com.shankar.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.shankar.model.ExamResult;



@Component
public class ExamInfoItempProcessor implements ItemProcessor<ExamResult, ExamResult> {

	@Override
	public ExamResult process(ExamResult item) throws Exception {
	if(item.getPercentage()>=90.0f) {
		return item;
	}
		return null;
	}

	

}
