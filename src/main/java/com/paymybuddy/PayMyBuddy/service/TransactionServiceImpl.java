package com.paymybuddy.PayMyBuddy.service;

import com.paymybuddy.PayMyBuddy.form.AddToBalanceForm;
import com.paymybuddy.PayMyBuddy.form.SendToFriend;
import com.paymybuddy.PayMyBuddy.form.TransactionForm;
import com.paymybuddy.PayMyBuddy.model.Transaction;
import com.paymybuddy.PayMyBuddy.model.User;
import com.paymybuddy.PayMyBuddy.repository.TransactionRepository;
import com.paymybuddy.PayMyBuddy.repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransactionServiceImpl implements TransactionService {


    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    private final double fees = 1.005;

    public TransactionServiceImpl(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }


    @Override
    public double calculateTransactionFee(User user, TransactionForm transactionForm) {
        double amount = Double.parseDouble(transactionForm.getAmount());
        return user.getBalance() - (amount * fees );
    }

    @Override
    public void addToBalance(User user, AddToBalanceForm addToBalanceForm) {
        double amount = Double.parseDouble(addToBalanceForm.getAmount());
        try {
            if (amount <= 0) {

            }
            //balance cant be lower than 0
        } catch (Exception e) {
            e.printStackTrace();
        }

        Transaction transaction = new Transaction();
        transaction.setDate(LocalDateTime.now());
        transaction.setBeneficiary(user);
        transaction.setAmount(amount * 0.995);
        transaction.setNote(addToBalanceForm.getWording());
        transactionRepository.save(transaction);

        user.setBalance(user.getBalance() + transaction.getAmount());
        userRepository.save(user);
    }

    @Override
    public void sendToFriend(User user, SendToFriend sendToFriend) {
        double amount = Double.parseDouble(sendToFriend.getAmount());
        try {
            if (amount <= 0) {

            }
            //balance cant be lower than 0
        } catch (Exception e) {
            e.printStackTrace();
        }

        User friend = user.getFriends()
                .stream()
                .filter(e -> e.getUserFriend().getEmail().equals(sendToFriend.getEmailFriend()))
                .findAny()
                .get()
                .getUserFriend();

        Transaction transaction = new Transaction();
        transaction.setDate(LocalDateTime.now());
        transaction.setBeneficiary(friend);
        transaction.setTransmitter(user);
        transaction.setAmount(amount);
        transaction.setNote(sendToFriend.getWording());
        transactionRepository.save(transaction);

        user.setBalance(calculateTransactionFee(user,sendToFriend));
        userRepository.save(user);

        friend.setBalance(friend.getBalance() + amount);
        userRepository.save(friend);
    }
}
