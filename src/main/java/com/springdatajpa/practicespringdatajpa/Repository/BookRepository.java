package com.springdatajpa.practicespringdatajpa.Repository;
import com.springdatajpa.practicespringdatajpa.Entity.Book;

import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.data.repository.query.Param;

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
    Book findDistinctByBookName(String bookName);
    Book findByBookNameStartingWith(String starting);
    //Custom Queries
    //JPQL(Java Persistance Query Language)
    /*
     * JPQL follows the Class not the database name. 
     * We need to define the select statement for the class not the 
     * Database table and Column name
     */
    @Query("select b from Book b where b.bookName=?1")
    Book getBookName(String bookName);
    @Query("select b from Book b where b.id=?1")
    Book getBookById(Long id);
    //Native Query
    @Query(value="select * from book b where b.book_name=?1",
        nativeQuery=true)
    Book getBookname(String bookName);
    //Native Query with Named Query
    @Query(value="Select * from book b where b.book_name=:bookName",
    nativeQuery = true)
    //@Lock(LockModeType.READ)
    Book getBookNameByParam(@Param("bookName")String bookName);
}
