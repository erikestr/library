package com.decsef.library.dao;

import com.decsef.library.entity.Book;
import com.decsef.library.entity.Loans;
import com.decsef.library.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource(path = "loans")
public interface LoansRepository extends JpaRepository<Loans, UUID> {

//    Loans findAllByStudentIdAndBookId(Student studentId, Book bookId);
    List<Loans> findAllByStudentIdAndBookId(Student studentId, Book bookId);
}
