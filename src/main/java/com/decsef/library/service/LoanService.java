package com.decsef.library.service;

import com.decsef.library.dao.BookRepository;
import com.decsef.library.dao.LoansRepository;
import com.decsef.library.dao.StudentRepository;
import com.decsef.library.entity.Student;
import com.decsef.library.entity.Book;
import com.decsef.library.entity.Loans;
import com.decsef.library.entity.LoansStatus;
import com.decsef.library.dto.Loan;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LoanService {

    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;
    private final LoansRepository loansRepository;

    public String registerLoan(Loan loan) {

        UUID bookUUID = loan.getBook().getId();
        UUID studentUUID = loan.getBook().getId();
        int expirationDays = loan.getDelivery().getExpatriationDays();
        LoansStatus statusDelivery = loan.getDelivery().getLoansStatus();

        Student student = studentRepository.findAllById(loan.getStudent().getId());
        Book book = bookRepository.findAllById(loan.getBook().getId());
                                                                                                                        // DONE -> TODO: get Data from RequestBody
        if (student != null && book != null){
            if (book.getQuantity() > 0){

                Loans loans = new Loans();

                loans.setId(UUID.randomUUID());
                loans.setExpirationLoan(Date.valueOf(LocalDate.now().plusDays(expirationDays)));                        // DONE -> TODO: get expiration from request
                loans.setStatusDelivery(statusDelivery);                                                                // DONE -> TODO: get status from request
                loans.setStudentId(student);
                loans.setBookId(book);

                loansRepository.save(loans);

                updateBookQuantity(book, bookUUID, false);
                updateStudentLoanItems(student, studentUUID, false);

                return "pass";
            }else {

                throw new IllegalStateException("the book is not available");
            }
        }

        return "fail";
    }

    public String returnLoan(Loan loan) {

        UUID bookUUID = loan.getBook().getId();
        UUID studentUUID = loan.getBook().getId();

        Student student = studentRepository.findAllById(studentUUID);
        Book book = bookRepository.findAllById(bookUUID);

        if (student != null && book != null){

            List<Loans> loansList = loansRepository.findAllByStudentIdAndBookId(student, book);
            Loans loans = loansList.get(0);

            loans.setReturnLoan(Date.valueOf(LocalDate.now()));
            loans.setStatusReturn(loan.getDelivery().getLoansStatus());

            loansRepository.save(loans);

            updateBookQuantity(book, bookUUID, true);
            updateStudentLoanItems(student, studentUUID, true);

            return "pass";
        }

        return "fail";
    }

    public void updateBookQuantity(Book book, UUID bookUUID, boolean type){

        if (type){

            bookRepository.setBookQuantity((book.getQuantity() + 1), bookUUID);
        }else {

            bookRepository.setBookQuantity((book.getQuantity() - 1), bookUUID);
        }
    }

    public void updateStudentLoanItems(Student student, UUID studentUUID, boolean type){

        if (!type){

            studentRepository.setStudentLoanItems((student.getLoanItems() + 1), studentUUID);
        }else {

            studentRepository.setStudentLoanItems((student.getLoanItems() - 1), studentUUID);
        }
    }

}
