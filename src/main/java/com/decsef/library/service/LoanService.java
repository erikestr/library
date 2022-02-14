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

    public Loans registerLoan(Loan loan) {

        // TODO: fix Update Student

        UUID bookUUID = loan.getBook().getId();
        UUID studentUUID = loan.getBook().getId();
        int expirationDays = loan.getLoanDelivery().getExpatriationDays();
        LoansStatus statusDelivery = loan.getLoanDelivery().getLoansStatus();

        Student student = studentRepository.findById(loan.getStudent().getId()).orElseThrow(
                () -> new IllegalStateException(
                        "student with id "+loan.getStudent().getId()+" does not exist")
        );

        Book book = bookRepository.findById(loan.getBook().getId()).orElseThrow(
                () -> new IllegalStateException(
                        "book with id "+ loan.getBook().getId() +" does not exist")
        );

        if (!student.isStatus()){

            throw new IllegalStateException("student "+student.getFirstName()+" "+ student.getLastName()+" is unavailable");
        }

        if (book.getQuantity() > 0){

            List<Loans> loansList = loansRepository.findAllByStudentIdAndBookIdOrderByReturnLoanDesc(student, book);

            if (loansList.isEmpty()){

                UUID actualLoan = createLoan(bookUUID,
                        studentUUID,
                        expirationDays,
                        statusDelivery,
                        student,
                        book);

                return loansRepository.getById(actualLoan);
            } else {

                Loans lastLoan = loansList.get(0);

                if (lastLoan.getReturnLoan() != null){
                    UUID actualLoan = createLoan(bookUUID,
                            studentUUID,
                            expirationDays,
                            statusDelivery,
                            student,
                            book);
                    return loansRepository.getById(actualLoan);
                }

                throw new IllegalStateException("the book is already loan to the actual student");
            }
        }else {

            throw new IllegalStateException("the book is not available");
        }
    }

    private UUID createLoan(UUID bookUUID,
                            UUID studentUUID,
                            int expirationDays,
                            LoansStatus statusDelivery,
                            Student student, Book book) {

        Loans loans = new Loans();

        loans.setId(UUID.randomUUID());
        loans.setExpirationLoan(Date.valueOf(LocalDate.now().plusDays(expirationDays)));
        loans.setStatusDelivery(statusDelivery);
        loans.setStudentId(student);
        loans.setBookId(book);

        UUID actualLoan = loans.getId();

        loansRepository.save(loans);

        updateStudentLoanItems(student.getItems(), studentUUID, false);
        updateBookQuantity(book, bookUUID, false);

        return actualLoan;
    }

    public Loans returnLoan(Loan loan) {

        UUID bookUUID = loan.getBook().getId();
        UUID studentUUID = loan.getStudent().getId();

        Student student = studentRepository.findById(loan.getStudent().getId()).orElseThrow(
                () -> new IllegalStateException(
                        "student with id "+loan.getStudent().getId()+" does not exist")
        );

        Book book = bookRepository.findById(loan.getBook().getId()).orElseThrow(
                () -> new IllegalStateException(
                        "book with id "+ loan.getBook().getId() +" does not exist")
        );

        if (student != null && book != null){

            List<Loans> loansList = loansRepository.findAllByStudentIdAndBookIdOrderByReturnLoanDesc(student, book);
            Loans loans = loansList.get(0);

            if (!loansList.isEmpty() && loans.getReturnLoan() == null) {

                loans.setReturnLoan(Date.valueOf(LocalDate.now()));
                loans.setStatusReturn(loan.getLoanReturn().getLoansStatus());

                loansRepository.save(loans);

                UUID actualLoan = loans.getId();

                updateBookQuantity(book, bookUUID, true);
                updateStudentLoanItems(student.getItems(), studentUUID, true);

                return loansRepository.getById(actualLoan);
            } else {

                throw new IllegalStateException("noting to do");
            }
        } else {

            throw new IllegalStateException("its not possible find actual student or book");
        }
    }

    public void updateBookQuantity(Book book, UUID bookUUID, boolean type){

        int bookQuantity = book.getQuantity();
        int bookQuantityFinal;

        if (type){

            bookQuantityFinal = bookQuantity + 1;
        }else {

            bookQuantityFinal = bookQuantity - 1;
        }

        bookRepository.setBookQuantity(bookQuantityFinal, bookUUID);
    }

    public void updateStudentLoanItems(int loanItems, UUID studentUUID, boolean type){
        if(type){

            loanItems--;
        }else {

            loanItems++;
        }

        studentRepository.setStudentItems(loanItems, studentUUID);
    }

}
