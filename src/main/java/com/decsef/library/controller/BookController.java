package com.decsef.library.controller;

import com.decsef.library.dto.Books;
import com.decsef.library.entity.Author;
import com.decsef.library.entity.Book;
import com.decsef.library.entity.Editorial;
import com.decsef.library.entity.Student;
import com.decsef.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"https://localhost:4200"})
@RequestMapping("/api/book")
@AllArgsConstructor
public class BookController {

    BookService bookService;

    @PostMapping
    public Book addBook(@RequestBody Books books){
        return bookService.addBook(books);
    }

    @DeleteMapping
    public boolean deleteBook(@RequestBody Books books){
        return bookService.deleteBook(books);
    }

    @PutMapping
    public Book updateBook(@RequestBody Books books) {
        return bookService.updateBook(books);
    }

    @PutMapping("/editorial")
    public Editorial updateEditorial(@RequestBody Editorial editorial) {
        return bookService.updateEditorial(editorial);
    }

    @PutMapping("/author")
    public Author updateAuthor(@RequestBody Author author) {
        return bookService.updateAuthor(author);
    }
}
