package com.decsef.library.service;

import com.decsef.library.dao.AuthorRepository;
import com.decsef.library.dto.Books;
import com.decsef.library.entity.Author;
import com.decsef.library.entity.Book;
import com.decsef.library.entity.Editorial;
import com.decsef.library.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {

    AuthorRepository authorRepository;

    public Book addBook(Books books) {
        return null;
    }

    public boolean deleteBook(Books books) {
        return false;
    }

    public Book updateBook(Books books) {
        return null;
    }

    public Editorial updateEditorial(Editorial editorial) {
        return null;
    }

    public Author updateAuthor(Author author) {
        Author actualAuthor = authorRepository.findById(author.getId()).orElseThrow(
                () -> new IllegalStateException(
                        "author with id "+author.getId()+" does not exist")
        );
        return actualAuthor;
    }
}