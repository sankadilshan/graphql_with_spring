package com.sankadilshan.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQlController {

    private final GraphqlServiceImpl graphqlService;

    @Autowired
    public GraphQlController(GraphqlServiceImpl graphqlService){
        this.graphqlService= graphqlService;
    }
    @QueryMapping
    public List<Book> getAllBooks(){
        return graphqlService.getAllBooks();
    }

    @QueryMapping
    public List<Author> getAllAuthors(){
        return graphqlService.getAllAuthors();
    }

    @QueryMapping
    public Book getBookById(@Argument int id){
        return graphqlService.getBooksById(id);
    }

    @QueryMapping
    public Author getAuthorById(@Argument int id){
        return graphqlService.getAuthorById(id);
    }
    @QueryMapping
    public List<Book> getBooksByIds(@Argument List<Integer> id){
        return graphqlService.getBooksByIds(id);
    }
    @QueryMapping
    public String health(){
        return "OK";
    }

    @MutationMapping(name = "createBook")
    public Book addBook(@Argument Book book){
        return graphqlService.createBook(book);
    }

    @MutationMapping(name = "createAuthor" )
    public Author addAuthor(@Argument AuthorInput authorInput){
        return graphqlService.createAuthor(authorInput);
    }
    @SchemaMapping
    public Author author(Book book){
        return graphqlService.getByAuthorId(book.authorId());
    }

    @SchemaMapping
    public String fullName(Author author){
        return author.firstName().concat(" ").concat(author.lastName());
    }

    @SchemaMapping
    public List<Book> books(Author author){
        return graphqlService.getAllBooksById(author);
    }
}
