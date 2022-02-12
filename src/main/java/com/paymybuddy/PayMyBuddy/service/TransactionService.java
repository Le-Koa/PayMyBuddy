package com.paymybuddy.PayMyBuddy.service;

import com.paymybuddy.PayMyBuddy.form.AddToBalanceForm;
import com.paymybuddy.PayMyBuddy.form.SendToFriend;
import com.paymybuddy.PayMyBuddy.form.TransactionForm;
import com.paymybuddy.PayMyBuddy.model.User;

public interface TransactionService {

double calculateTransactionFee(User user, TransactionForm transactionForm);

void addToBalance(User user, AddToBalanceForm addToBalanceForm);

void sendToFriend(User user, SendToFriend sendToFriend);
}
