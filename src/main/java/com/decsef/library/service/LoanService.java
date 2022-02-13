package com.decsef.library.service;

import com.decsef.library.dao.BookRepository;
import com.decsef.library.dao.LoansRepository;
import com.decsef.library.dao.StudentRepository;
import com.decsef.library.entity.Book;
import com.decsef.library.entity.LoanStatus;
import com.decsef.library.entity.Loans;
import com.decsef.library.entity.Student;
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

    public String registerLoan(String studentUUID, String bookUUID) {

        Student student = studentRepository.findAllById(UUID.fromString(studentUUID));
        Book book = bookRepository.findAllById(UUID.fromString(bookUUID));

        // TODO: id book.id exists
        // TODO: if bookUUID.quantity > 0 then ok
        // TODO: id student.id exists
        // TODO: get DAta from JSON

        if (student != null && book != null){
            if (book.getQuantity() > 0){

                Loans loans = new Loans();

                loans.setId(UUID.randomUUID());
                loans.setExpirationLoan(Date.valueOf(LocalDate.now().plusDays(5)));
                loans.setStatusDelivery(LoanStatus.PERFECT);
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


    public String returnLoan(String studentUUID, String bookUUID, LoanStatus statusReturn) {

        Student student = studentRepository.findAllById(UUID.fromString(studentUUID));
        Book book = bookRepository.findAllById(UUID.fromString(bookUUID));

        List<Loans> loansList = loansRepository.findAllByStudentIdAndBookId(student, book);
        Loans loan = loansList.get(0);

        loan.setReturnLoan(Date.valueOf(LocalDate.now()));
        loan.setStatusReturn(statusReturn);

        loansRepository.save(loan);

        updateBookQuantity(book, bookUUID, true);
        updateStudentLoanItems(student, studentUUID, true);

        return "pass";
    }

    public void updateBookQuantity(Book book, String bookUUID, boolean type){
        if (type){

            bookRepository.setBookQuantity((book.getQuantity() + 1), UUID.fromString(bookUUID));
        }else {

            bookRepository.setBookQuantity((book.getQuantity() - 1), UUID.fromString(bookUUID));
        }
    }

    public void updateStudentLoanItems(Student student, String studentUUID, boolean type){
        if (!type){

            studentRepository.setStudentLoanItems((student.getLoanItems() + 1), UUID.fromString(studentUUID));
        }else {

            studentRepository.setStudentLoanItems((student.getLoanItems() - 1), UUID.fromString(studentUUID));
        }
    }

}
