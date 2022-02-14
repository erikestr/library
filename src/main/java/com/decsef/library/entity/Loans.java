package com.decsef.library.entity;

import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Loans {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Book bookId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Student studentId;

    @Column(name = "created_loan", nullable = false)
    @CreationTimestamp
    private Date createdLoan;

    @Column(name = "expiration_loan", nullable = false)
    private Date expirationLoan = createdLoan;

    @Column(name = "return_loan")
    private Date returnLoan;

    @Column(name = "status_delivery")
    @Enumerated(EnumType.STRING)
    private LoansStatus statusDelivery;

    @Column(name = "status_return")
    @Enumerated(EnumType.STRING)
    private LoansStatus statusReturn;
}
