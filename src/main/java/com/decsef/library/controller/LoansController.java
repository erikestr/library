package com.decsef.library.controller;

import com.decsef.library.dto.Loan;
import com.decsef.library.entity.Loans;
import com.decsef.library.exception.ApiRequestException;
import com.decsef.library.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"https://localhost:4200"})
@RequestMapping("/api/loan")
@AllArgsConstructor
public class LoansController {

    private final LoanService loanService;

/*    @PostMapping("/delivery")
    public Loans placeLoan(@RequestBody Loan loan){

        return loanService.registerLoan(loan);
    }*/

    @PostMapping("/delivery")
    public Loans placeLoan(@RequestBody Loan loan){

        return loanService.registerLoan(loan);
    }

    @PostMapping("/return")
    public Loans returnLoan(@RequestBody Loan loan) {

        return loanService.returnLoan(loan);
    }
}
