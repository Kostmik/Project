package com.example.ntb.rut.services;

import com.example.ntb.rut.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();
    private long nextId = 1;

    public List<Book> findAll() {
        return books;
    }

    public Optional<Book> findById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public void save(Book book) {
        if (book.getId() == null) {
            book.setId(nextId++);
            books.add(book);
        } else {
            // Обновляем существующую книгу
            books.replaceAll(b -> b.getId().equals(book.getId()) ? book : b);
        }
    }

    public void deleteById(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
