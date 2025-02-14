package com.shankar.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
@Component("biprocessor")
public class BookInfoItemProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		System.out.println("BookInfoItemProcessor.process()");
		if(item.equalsIgnoreCase("CRJ"))
		return item+"CRJ---Shankar";
		else if(item.equalsIgnoreCase("EJ"))
			return item+"EJ---Aditya";
		else if(item.equalsIgnoreCase("BBJ"))
			return item+"BBJ---Royal Reddy";
		else if(item.equalsIgnoreCase("HRJ"))
			return item+"HRJ--SReddy";
		else if(item.equalsIgnoreCase("SPB"))
			return item+"SPB---Bhavani";
		else
		return item;
	}

}
