package com.decsef.library.controller;

import com.decsef.library.dao.BookRepository;
import com.decsef.library.dao.StudentRepository;
import com.decsef.library.dto.Loan;
import com.decsef.library.entity.LoansStatus;
import com.decsef.library.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loan")
@AllArgsConstructor
public class LoansController {

    private final LoanService loanService;

    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;

/*    @PostMapping("/delivery")
    public String placeLoan(@RequestParam("student") String studentUUID, @RequestParam("book") String bookUUID){
        return loanService.registerLoan(studentUUID, bookUUID);
    }*/

    @PostMapping("/delivery")
    public String placeLoan(@RequestBody Loan loan){
        return loanService.registerLoan(loan);
    }

    @PostMapping("/return")
    public String returnLoan(@RequestBody Loan loan){
        return loanService.returnLoan(loan);
    }

/*    @PostMapping("/return")
    public String returnLoan(@RequestParam("student") String studentUUID, @RequestParam("book") String bookUUID,  @RequestParam("status") String statusReturn){
        return loanService.returnLoan(studentUUID, bookUUID, LoansStatus.valueOf(statusReturn));
    }*/
}
