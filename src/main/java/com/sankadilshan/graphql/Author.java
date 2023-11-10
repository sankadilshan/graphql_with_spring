package com.sankadilshan.graphql;

import java.util.Arrays;
import java.util.List;

public record Author(int id, String firstName, String lastName ) {

    private static List<Author> authors = Arrays.asList(
            new Author(1, "Joshua", "Bloch"),
            new Author(2, "Douglas", "Adams"),
            new Author(3, "Bill", "Bryson")
    );

    public Author {

    }
    public static List<Author> getAuthors(){
        return authors;
    }

    public static Author createAuthor(Author author){
        try {
            authors.add(author);
        }catch (UnsupportedOperationException e){
            System.out.printf("%s  --  %s", e.getMessage(), author.toString());
        }
        return author;
    }
}
