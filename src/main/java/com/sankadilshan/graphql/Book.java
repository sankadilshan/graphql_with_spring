package com.sankadilshan.graphql;

import java.util.Arrays;
import java.util.List;

public record Book(int id, String name, int publishYear, int pageCount, int authorId) {

    private static List<Book> books = Arrays.asList(
            new Book(1, "Effective Java", 2010, 200, 1),
            new Book(2, "Hitchhiker's Guide to the Galaxy", 2011, 400,2),
            new Book(3, "Down Under", 2015, 1100 ,1)
    );

    public static List<Book> getBooks(){
        return books;
    }

    public static Book createBook(Book book){
       books.add(book);
       return book;
    }
}
