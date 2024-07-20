package com.example.librarymanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String externalTxnId;

    @CreationTimestamp
    private Date transactionTime;

    @UpdateTimestamp
    private Date updatedOn;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Enumerated(value = EnumType.STRING)  // Tells which type of values our transactionType is going to have i.e String type
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"transactionList"})
    private Book book;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"transactionList"})
    private Student student;

    private Double fine;


}
