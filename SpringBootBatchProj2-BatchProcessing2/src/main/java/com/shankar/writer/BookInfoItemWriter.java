package com.shankar.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("biwriter")
public class BookInfoItemWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println("BookInfoItemWriter.write()");
		items.forEach(System.out::println);
	}
}
