package com.example.ntb.rut.controllers;

import com.example.ntb.rut.models.Book;
import com.example.ntb.rut.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }

    @GetMapping("/new")
    public String showNewBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "new_book";
    }

    @PostMapping
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditBookForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookService.findById(id).orElse(null));
        return "edit_book";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book) {
        book.setId(id);
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }
}

