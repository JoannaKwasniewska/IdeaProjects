package com.kodilla.rest.service;

import com.kodilla.rest.domain.BookDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<BookDto> books = new ArrayList<>();

    public List<BookDto> getBooks() {
        return books;
    }


    public void addBook(BookDto bookDto) {
        books.add(bookDto);
    }
    public void removeBook(BookDto book) {
        books.remove(book);
    }

    public void removeBookByTitle(String title) {

        BookDto bookToRemove = null;
        for (BookDto book : books) {
            if (book.getTitle().equals(title)) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
        }
    }
}
