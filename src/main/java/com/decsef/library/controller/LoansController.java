package com.decsef.library.controller;

import com.decsef.library.dto.Loan;
import com.decsef.library.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loan")
@AllArgsConstructor
public class LoansController {

    private final LoanService loanService;

    @PostMapping("/delivery")
    public String placeLoan(@RequestBody Loan loan){
        return loanService.registerLoan(loan);
    }

    @PostMapping("/return")
    public String returnLoan(@RequestBody Loan loan){
        return loanService.returnLoan(loan);
    }
}
