package com.springdatajpa.practicespringdatajpa.Repository;
import com.springdatajpa.practicespringdatajpa.Entity.Book;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
    
}
