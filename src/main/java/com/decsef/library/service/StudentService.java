package com.decsef.library.service;

import com.decsef.library.dao.StudentRepository;
import com.decsef.library.entity.Student;
import com.decsef.library.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student registerStudent(Student student) {
        if (student.getFirstName() != null && student.getLastName() != null && student.getAddress() != null){

            Student studentSave = new Student();
            studentSave = student;
            studentSave.setId(UUID.randomUUID());
            studentSave.setStatus(true);

            studentRepository.save(studentSave);
            return studentRepository.findAllById(studentSave.getId());
        }

        throw new IllegalStateException("nothing to do");
    }

    public boolean deleteStudent(Student student) {
        if (!studentRepository.existsById(student.getId())){
            throw new IllegalStateException(
                    "student with id "+student.getId()+" does not exist");
        }
        studentRepository.deleteById(student.getId());
        return true;
    }

    public Student updateStudent(Student student) {
        Student actualStudent = studentRepository.findById(student.getId()).orElseThrow(
                () -> new IllegalStateException(
                        "student with id "+student.getId()+" does not exist")
        );

        if (student.getFirstName() != null && student.getFirstName().length() > 0 &&
                !Objects.equals(actualStudent.getFirstName(), student.getFirstName())){

            actualStudent.setFirstName(student.getFirstName());
        }
        if (student.getLastName() != null && student.getLastName().length() > 0 &&
                !Objects.equals(actualStudent.getLastName(), student.getLastName())){

            actualStudent.setLastName(student.getLastName());
        }
        if (student.getAddress() != null && student.getAddress().length() > 0 &&
                !Objects.equals(actualStudent.getAddress(), student.getAddress())){

            actualStudent.setAddress(student.getAddress());
        }

        if (!Objects.equals(actualStudent.isStatus(), student.isStatus())){

            actualStudent.setStatus(student.isStatus());
        }

        return studentRepository.save(actualStudent);
    }
}
