package com.paymybuddy.PayMyBuddy.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class TransactionForm {

    protected String amount;
    protected String wording;
}
