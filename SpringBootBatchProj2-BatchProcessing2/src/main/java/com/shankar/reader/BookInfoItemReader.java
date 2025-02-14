package com.shankar.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;
@Component("bireader")
public class BookInfoItemReader implements ItemReader<String> {
	
	int count=0;
	String books[]=new String[] {"CRJ","EJ","BBJ","HRJ","SPB"};
	

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("BookInfoItemReader.read()");
		if(count < books.length)
			return books[count++];
		else
		return null;
	}

}
