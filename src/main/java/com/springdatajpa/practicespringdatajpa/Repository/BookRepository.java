package com.springdatajpa.practicespringdatajpa.Repository;
import com.springdatajpa.practicespringdatajpa.Entity.Book;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
    
}
