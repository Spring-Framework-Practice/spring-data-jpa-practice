package com.springdatajpa.practicespringdatajpa.Repository;

import static org.mockito.Mockito.framework;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springdatajpa.practicespringdatajpa.Entity.Book;
import com.springdatajpa.practicespringdatajpa.Entity.BookCategory;

import jakarta.transaction.Transactional;

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
    @Transactional
    public void listOfBooks(){
        List<Book> book=repo.findAll();
        for(Book books:book){
            System.out.println(books);
        }
    }
    @Test
    @DisplayName("Returns find by book name")
    public void findByBookName(){
        Book book=repo.findByBookName("python");
        System.out.println(book);
        //This will return find by book name ignoring the case sensitive
        Book book2=repo.findByBookNameIgnoreCase("java");
        System.out.println(book2);
    }
    @Test
    public void orderBy(){
        List<Book> books=repo.findAllByOrderByIdAsc();
        System.out.println(books);
    }
    @Test
    @DisplayName("Paging the Elements in the Book Element")
    public void pagenationImplementation(){
        Pageable page=PageRequest.of(1, 1);
        List<Book> books=repo.findAll(page).getContent();
        Long totalElement=repo.findAll(page).getTotalElements();
        int totalPages=repo.findAll(page).getTotalPages();
        System.out.println("Total Pages:"+totalPages);
        System.out.println(totalElement);
        System.out.println(books);

    }
    @Test
    @DisplayName("Using Sort Mechanism")
    public void sortByBook(){
        Sort sort=Sort.by("bookName").descending();
        List<Book> books=repo.findAll(sort);
        System.out.println(books);
    }
    @Test
    public void sortByLimit(){
        /*To find the record based on the limit of the record.
        We can use Top or First after the limit size. Use by after
        defining the limit. We can use Pagenable and Sort mechanism in the 
        limit
        */
        List<Book> book=repo.findFirst1ByBookName("java");
        System.out.println(book);
        List<Book> book2=repo.findFirst1ByBookName("python",
        Sort.by("id").descending());
        System.out.println(book2);
    }
    @Test
    @DisplayName("Creating the Custom Query")
    public void DistinctName(){
        Book book=repo.findDistinctByBookName("java");
        System.out.println(book);
    }
    @Test
    @DisplayName("Starting with")
    public void startingName(){
        Book book=repo.findByBookNameStartingWith("ja");
        System.out.println(book);
    }
    @Test
    @DisplayName("Custom Query")
    public void customQueryCreation(){
        Book book=repo.getBookName("Java");
        System.out.println(book);
    }
    @Test
    @DisplayName("Custom Query Based on the ID")
    @Transactional
    public void customQueryCreationBasedOnID(){
        Book book = repo.getBookById(52L);
        System.out.println(book);
    }
    @Test
    @DisplayName("Native Query")
    @Transactional
    public void customNativeQuery(){
        Book book= repo.getBookname("java");
        System.out.println(book);
    }
    @Test
    @DisplayName("Native Query using Param")
    @Transactional
    public void customQueryParam(){
        Book book =repo.getBookNameByParam("Java");
        System.out.println(book);
    }
    
}
