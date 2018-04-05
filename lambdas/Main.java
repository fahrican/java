package com.teamtreehouse.lambdas;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void usingAnonymousInlineClass(){

        List<Book> books = Books.all();
        Collections.sort(books, (o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));

        books.forEach(book -> System.out.println(book));

    }

    public static void usingMethodReferences(){

        List<Book> books = Books.all();
        Collections.sort(books, Comparator.comparing(Book::getTitle));

        books.forEach(book -> System.out.println(book));

    }

    public static void main(String[] args) {
	// write your code here

        //usingAnonymousInlineClass();
        usingMethodReferences();
    }
}
