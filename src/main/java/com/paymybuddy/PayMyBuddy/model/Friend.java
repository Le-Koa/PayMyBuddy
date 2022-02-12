package com.paymybuddy.PayMyBuddy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "friend")

public class Friend {

    @Id
    @GeneratedValue

    private int id;

    @OneToOne
    private User user;

    @ManyToOne
    private User userFriend;
}
