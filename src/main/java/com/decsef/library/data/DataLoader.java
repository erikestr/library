package com.decsef.library.data;

import com.decsef.library.dao.BookRepository;
import com.decsef.library.dao.StudentRepository;
import com.decsef.library.entity.Book;
import com.decsef.library.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.util.UUID;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    BookRepository bookRepository;
    StudentRepository studentRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Book book = new Book();
        book.setId(UUID.fromString("e7ade77d-9412-45de-9f86-59e144443dde"));
        book.setYear("2019");
        book.setTittle("title 1");
        book.setEdition("1ra");
        book.setPages(100);
        bookRepository.saveAndFlush(book);

        Student student = new Student();
        student.setId(UUID.fromString("93e0d974-d17e-4b48-aeb4-54f3ff1a140e"));
        student.setFirstName("Erik");
        student.setLastName("Estrada");
        student.setAddress("Av. Nuevo Leon 123");
        studentRepository.saveAndFlush(student);
    }
}
