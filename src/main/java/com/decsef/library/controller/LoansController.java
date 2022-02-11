package com.decsef.library.controller;

import com.decsef.library.dao.BookRepository;
import com.decsef.library.dao.StudentRepository;
import com.decsef.library.entity.Book;
import com.decsef.library.entity.Loans;
import com.decsef.library.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/loan")
@AllArgsConstructor
public class LoansController {

    private final LoanService loanService;

    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;

    @PostMapping("/delivery")
    public String placeLoan(@RequestParam("student") String studentUUID, @RequestParam("book") String bookUUID){
        return loanService.register(studentUUID, bookUUID);
    }
}
