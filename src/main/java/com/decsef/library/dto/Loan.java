package com.decsef.library.dto;

import com.decsef.library.entity.Book;
import com.decsef.library.entity.Student;
import lombok.Data;

@Data
public class Loan {

    private Student student;
    private Book book;
    private Delivery delivery;
}
