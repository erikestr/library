package com.decsef.library.controller;

import com.decsef.library.dao.StudentRepository;
import com.decsef.library.entity.Student;
import com.decsef.library.service.LoanService;
import com.decsef.library.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student){
        return studentService.registerStudent(student);
    }

    @DeleteMapping("/delete")
    public boolean deleteStudent(@RequestBody Student student){
        return studentService.deleteStudent(student);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

}
