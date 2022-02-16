package com.decsef.library.dao;

import com.decsef.library.entity.StudentTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(path = "studentsT")
public interface StudentTestRepository extends JpaRepository<StudentTest, Long> {

    Page<StudentTest> findStudentTestByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
