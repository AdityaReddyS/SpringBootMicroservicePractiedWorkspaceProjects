package com.shankar.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.shankar.entiry.Book;

public class SortByBookName {

	
	
public static void main(String[] args) {
	
	
    List <Book> bookList = new ArrayList<>();
    bookList.add(new Book(500, "Core Java", 200, "Kathy Sierra", 1065.5));
    bookList.add(new Book(501, "JSP & Servlets", 350, "Kathy Sierra", 1749.0));
    bookList.add(new Book(502, "Spring in Action", 480, "Craig Walls", 940.75));
    bookList.add(new Book(503, "Pro Angular", 260, "Freeman", 1949.25));
    bookList.add(new Book(504, "HTML CSS", 100, "Thomas Powell", 2317.09));
    bookList.add(new Book(505, "Hibernate in Action", 180, "Gavin King", 889.25));

    System.out.println("Sort List of Book objects by BookName");

    bookList.stream().sorted((b1,b2)->b1.getName().compareToIgnoreCase(b2.getName())).forEach(System.out::println);
    
    System.out.println("\nSort List of Book objects by BookName and comparing by authopr then cost");
    
    Comparator<Book> bookByName=(b1,b2)->b1.getName().compareToIgnoreCase(b2.getName());
    Comparator<Book> bookByAuthor=(b1,b2)->b1.getAuthor().compareToIgnoreCase(b2.getAuthor());
    Comparator<Book> bookByCost=(b1,b2)->Double.compare(b1.getCost(), b2.getCost());
    
    bookList.stream().sorted(bookByName.thenComparing(bookByAuthor).thenComparing(bookByCost)).forEach(System.out::println);
    
}


}
