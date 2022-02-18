package com.decsef.library.service;

import com.decsef.library.dao.AuthorRepository;
import com.decsef.library.dao.BookRepository;
import com.decsef.library.dao.EditorialRepository;
import com.decsef.library.dto.Books;
import com.decsef.library.entity.Author;
import com.decsef.library.entity.Book;
import com.decsef.library.entity.Editorial;
import com.decsef.library.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookService {

    private final AuthorRepository authorRepository;
    private final EditorialRepository editorialRepository;
    private final BookRepository bookRepository;

    public Book addBook(Books books) {
        System.out.println("books = " + books.getBook().getId());
        System.out.println("books = " + books.getAuthor().getId());
        System.out.println("books = " + books.getEditorial().getId());
        if (books.getBook().getYear() != null){

            Author authorSave = authorRepository.findAllById(books.getAuthor().getId());
            Editorial editorialSave = editorialRepository.findAllById(books.getEditorial().getId());
            Book bookSave = new Book();
            bookSave = books.getBook();
            bookSave.setId(UUID.randomUUID());
            /*bookSave.setAuthor(authorSave);
            bookSave.setEditorial(editorialSave);*/

            return bookRepository.save(bookSave);
        }

        throw new IllegalStateException("nothing to do");
    }

    public boolean deleteBook(Books books) {
        return false;
    }

    public Book updateBook(Books books) {

        Book actualBook = bookRepository.findById(books.getBook().getId()).orElseThrow(
                () -> new IllegalStateException(
                        "book with id "+books.getBook().getId()+" does not exist")
        );

        if (books.getBook().getYear() != null && books.getBook().getYear().length() > 0 &&
                !Objects.equals(actualBook.getYear(), books.getBook().getYear())){

            actualBook.setYear(books.getBook().getYear());
        }
        if (books.getBook().getTittle() != null && books.getBook().getTittle().length() > 0 &&
                !Objects.equals(actualBook.getTittle(), books.getBook().getTittle())){

            actualBook.setTittle(books.getBook().getTittle());
        }
        if (books.getBook().getEdition() != null && books.getBook().getEdition().length() > 0 &&
                !Objects.equals(actualBook.getEdition(), books.getBook().getEdition())){

            actualBook.setEdition(books.getBook().getEdition());
        }
        if (!Objects.equals(actualBook.getPages(), books.getBook().getPages())){

            actualBook.setPages(books.getBook().getPages());
        }
        if (books.getBook().getImageUrl() != null && books.getBook().getImageUrl().length() > 0 &&
                !Objects.equals(actualBook.getImageUrl(), books.getBook().getImageUrl())){

            actualBook.setImageUrl(books.getBook().getImageUrl());
        }
        if (!Objects.equals(actualBook.getQuantity(), books.getBook().getQuantity())){

            actualBook.setQuantity(books.getBook().getQuantity());
        }

        return bookRepository.save(actualBook);
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
