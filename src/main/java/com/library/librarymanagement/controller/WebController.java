package com.library.librarymanagement.controller;

import com.library.librarymanagement.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    private final List<Book> books = new ArrayList<>();
    private long nextId = 1;

    // Login sayfası için gerekli (404 hatasını çözer)
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Ana sayfa (kütüphane)
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("books", books);
        model.addAttribute("book", new Book());
        return "index";
    }

    @PostMapping("/add")
    public String add(Book book) {
        book.setId(nextId++);
        books.add(book);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        books.removeIf(b -> b.getId().equals(id));
        return "redirect:/";
    }
}