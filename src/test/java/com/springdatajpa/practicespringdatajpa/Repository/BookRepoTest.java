package com.springdatajpa.practicespringdatajpa.Repository;

import static org.mockito.Mockito.framework;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdatajpa.practicespringdatajpa.Entity.Book;
import com.springdatajpa.practicespringdatajpa.Entity.BookCategory;

@SpringBootTest
public class BookRepoTest {
    @Autowired
    private BookRepository repo;
    @Test
    @DisplayName("Storing a Book With Category")
    public void saveBook(){
        BookCategory category=BookCategory.builder().category("Programming").build();
        Book book=Book.builder().bookName("Java").category(category).build();
        Book book2=Book.builder().bookName("Python").category(category).build();
        List<Book> books=new ArrayList<>();
        books.add(book);
        books.add(book2);
        repo.saveAll(books);
    }
    @Test
    @DisplayName("Print the list of Books")
    public void listOfBooks(){
        List<Book> book=repo.findAll();
        for(Book books:book){
            System.out.println(books);
        }
    }
}
