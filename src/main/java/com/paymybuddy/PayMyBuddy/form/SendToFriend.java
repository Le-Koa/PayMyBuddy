package com.paymybuddy.PayMyBuddy.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public abstract class SendToFriend extends TransactionForm {

    private String emailFriend;
}
