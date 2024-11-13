package com.example.ntb.rut.repositories;


import com.example.ntb.rut.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

