package com.springdatajpa.practicespringdatajpa.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "books")
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long bookCategoryId;
    private String category;

    @OneToMany(targetEntity = Book.class, mappedBy = "category"
    ,cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();
}
