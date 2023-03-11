package com.springdatajpa.practicespringdatajpa.Repository;
import com.springdatajpa.practicespringdatajpa.Entity.Book;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
    Book findByBookName(String bookName);
    Book findByBookNameIgnoreCase(String bookName);
    //Order By Asc and Desc
    List<Book> findByBookNameOrderByIdAsc(String bookName);
    List<Book> findAllByOrderByIdAsc();
    List<Book> findFirst1ByBookName(String bookName);
    List<Book> findFirst1ByBookName(String bookName,Sort sort);
}
