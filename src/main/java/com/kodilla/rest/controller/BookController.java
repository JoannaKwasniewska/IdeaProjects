package com.kodilla.rest.controller;

import com.kodilla.rest.domain.BookDto;
import com.kodilla.rest.service.BookService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {


    private final BookService bookService;

    public BookController(BookService bookService) {

        this.bookService = bookService;
    }


    @GetMapping
    public List<BookDto> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public void addBook(@RequestBody BookDto bookDto) {
        bookService.addBook(bookDto);
    }

    @DeleteMapping("/remove")
    public void removeBook(@RequestBody BookDto bookDto) {
        bookService.removeBook(bookDto);
    }

    @DeleteMapping("/removeByTitle")
    public void removeBookByTitle(@RequestParam String title) {
        bookService.removeBookByTitle(title);
    }
}