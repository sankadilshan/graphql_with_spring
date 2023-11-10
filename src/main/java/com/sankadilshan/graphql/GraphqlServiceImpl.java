package com.sankadilshan.graphql;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GraphqlServiceImpl {
    public List<Book> getAllBooks() {
        return Book.getBooks();
    }

    public List<Author> getAllAuthors(){
        return Author.getAuthors();
    }

    public Author getByAuthorId(int authorId) {
        return Author.getAuthors().stream().filter(author -> author.id()==authorId).findFirst().orElseGet(null);
    }

    public List<Book> getAllBooksById(Author author) {
        return Book.getBooks().stream().filter(book -> book.authorId() == author.id()).collect(Collectors.toList());
    }

    public Book getBooksById(int id) {
        Optional<Book> bookOptional = Book.getBooks().stream().filter(book -> book.id() == id).findFirst();
        return bookOptional.orElse(null);
    }

    public List<Book> getBooksByIds(List<Integer> ids){
        List<Book> resultBooks =  new ArrayList<>();
        ids.forEach(id -> {
            Optional<Book> bookOptional = Book.getBooks().stream().filter(book -> book.id() == id).findFirst();
            bookOptional.ifPresent(resultBooks::add);
        });
        return resultBooks;
    }

    public Book createBook(Book book) {
        return Book.createBook(book);
    }

    public Author createAuthor(AuthorInput authorInput){
        return Author.createAuthor(new Author(authorInput.id(),authorInput.firstName(),authorInput.lastName()));
    }

    public Author getAuthorById(int id) {
        Optional<Author> authorOptional = Author.getAuthors().stream().filter(author -> author.id() == id).findFirst();
        return authorOptional.orElse(null);
    }
}
