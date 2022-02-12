package com.paymybuddy.PayMyBuddy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "transactions")

public class Transaction {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private User transmitter;

    @ManyToOne
    private User beneficiary;

    private double amount;

    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime date;

    private String note;
}
