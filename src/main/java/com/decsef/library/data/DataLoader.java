package com.decsef.library.data;

import com.decsef.library.dao.*;
import com.decsef.library.entity.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    EditorialRepository editorialRepository;
    AuthorRepository authorRepository;
    BookRepository bookRepository;
    StudentRepository studentRepository;
    StudentTestRepository studentTestRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        editorialRepository.save(new Editorial(
                UUID.fromString("e7ade77d-9412-45de-9f86-59e144443dd0"),
                "Editorial 1",
                "Mexico",
                "CDMX",
                "CMDX",
                java.sql.Date.valueOf(LocalDate.now())
        ));
        editorialRepository.save(new Editorial(
                UUID.fromString("e7ade77d-9412-45de-9f86-59e144443dd2"),
                "Editorial 2",
                "Mexico",
                "CDMX",
                "CMDX",
                java.sql.Date.valueOf(LocalDate.now())
        ));

        authorRepository.save(new Author(
                UUID.fromString("e7ade77d-9412-45de-9f86-59e144443dd1"),
                "Joaquin",
                "Lopez",
                "Mexican",
                "Mexico",
                "CDMX",
                "CDMX",
                java.sql.Date.valueOf(LocalDate.now()),
                java.sql.Date.valueOf(LocalDate.now()),
                "Writer",
                "Language",
                "Book"
        ));
        authorRepository.save(new Author(
                UUID.fromString("e7ade77d-9412-45de-9f86-59e144443dd3"),
                "Diego",
                "Rivera",
                "Mexican",
                "Mexico",
                "CDMX",
                "CDMX",
                java.sql.Date.valueOf(LocalDate.now()),
                java.sql.Date.valueOf(LocalDate.now()),
                "Writer",
                "Language",
                "Book"
        ));

        bookRepository.save(new Book(
                UUID.fromString("e7ade77d-9412-45de-9f86-59e144443dd4"),
                "2019",
                "book 1",
                "1r",
                100,
                editorialRepository.findAllById(UUID.fromString("e7ade77d-9412-45de-9f86-59e144443dd0")),
                authorRepository.findAllById(UUID.fromString("e7ade77d-9412-45de-9f86-59e144443dd1")),
                2
        ));
        bookRepository.save(new Book(
                UUID.fromString("e7ade77d-9412-45de-9f86-59e144443dd5"),
                "2018",
                "book 2",
                "2a",
                150,
                editorialRepository.findAllById(UUID.fromString("e7ade77d-9412-45de-9f86-59e144443dd2")),
                authorRepository.findAllById(UUID.fromString("e7ade77d-9412-45de-9f86-59e144443dd3")),
                2
        ));

        studentRepository.save(new Student(
                UUID.fromString("e7ade77d-9412-45de-9f86-59e144443dd6"),
                "Erik",
                "Estrada",
                "Av. Juarez 123",
                true
        ));
        studentRepository.save(new Student(
                UUID.fromString("e7ade77d-9412-45de-9f86-59e144443dd7"),
                "Mariam",
                "Perez",
                "Av. Juarez 123",
                true
        ));

        studentTestRepository.save(new StudentTest(
                "Erik","Estrada","asdafasf", true
        ));
        studentTestRepository.save(new StudentTest(
                "Juan","Perez","asdafasf", true
        ));
        studentTestRepository.save(new StudentTest(
                "Roberto","Lopez","asdafasf", true
        ));
    }
}
