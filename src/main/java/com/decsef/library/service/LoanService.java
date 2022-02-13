package com.decsef.library.service;

import com.decsef.library.dao.BookRepository;
import com.decsef.library.dao.LoansRepository;
import com.decsef.library.dao.StudentRepository;
import com.decsef.library.entity.Book;
import com.decsef.library.entity.LoanStatus;
import com.decsef.library.entity.Loans;
import com.decsef.library.entity.Student;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LoanService {

    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;
    private final LoansRepository loansRepository;

    public String register(String studentUUID, String bookUUID) {

        Student student = studentRepository.findAllById(UUID.fromString(studentUUID));
        Book book = bookRepository.findAllById(UUID.fromString(bookUUID));

        // TODO: id book.id exists
        // TODO: if bookUUID.quantity > 0 then ok
        // TODO: id student.id exists

        if (student != null && book != null){
            if (book.getQuantity() > 0){

                Loans loans = new Loans();

                loans.setId(UUID.randomUUID());
                loans.setExpirationLoan(Date.valueOf(LocalDate.now().plusDays(5)));
                loans.setStatusDelivery(LoanStatus.PERFECT);
                loans.setStudentId(student);
                loans.setBookId(book);

                loansRepository.save(loans);

                return "pass";
            }else {

                throw new IllegalStateException("the book is not available");
            }
        }

        return "fail";
    }

    public void decrementBookQuantity(Book book){

    }
}
