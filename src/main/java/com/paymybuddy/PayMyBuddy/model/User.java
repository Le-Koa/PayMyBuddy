package com.paymybuddy.PayMyBuddy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private int id;

    @Column(name= "first_name")
    private String firstName;

    @Column(name= "last_name")
    private String lastName;

    @Column(name= "email")
    private String email;

    @Column(name= "password")
    private String password;

    @Column(name= "birthdate")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;

    @Column(name= "balance")
    private Double balance;

    @OneToMany
    @JoinColumn (name = "user_id")
    private Collection<Friend> friends = new ArrayList<>();

    @OneToMany(
            mappedBy = "transmitter"
            )
    private List<Transaction> send = new ArrayList<>();

    @OneToMany(
            mappedBy = "beneficiary"
            )
    private List<Transaction> receive = new ArrayList<>();

}
