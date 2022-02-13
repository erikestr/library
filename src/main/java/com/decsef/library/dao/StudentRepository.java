package com.decsef.library.dao;

import com.decsef.library.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, UUID> {
    Student findAllById(UUID uuid);

    @Transactional
    @Modifying
    @Query("UPDATE Student s SET s.loanItems = ?1 WHERE s.id = ?2")
    void setStudentLoanItems(int i, UUID fromString);
}
