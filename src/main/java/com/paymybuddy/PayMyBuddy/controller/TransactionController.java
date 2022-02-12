package com.paymybuddy.PayMyBuddy.controller;

import com.paymybuddy.PayMyBuddy.form.AddToBalanceForm;
import com.paymybuddy.PayMyBuddy.form.SendToFriend;
import com.paymybuddy.PayMyBuddy.model.User;
import com.paymybuddy.PayMyBuddy.service.TransactionService;
import com.paymybuddy.PayMyBuddy.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@AllArgsConstructor
@Controller

public class TransactionController {

    private final UserService userService;
    private final TransactionService transactionService;

    @GetMapping(value = "/transaction")
    public String transactionPage(Model model, HttpServletRequest request) {
        User user = userService.getCurrentLoggedUser(request);
        model.addAttribute("currentUserId", user.getId());
        model.addAttribute("transactions");
        model.addAttribute("balance", user.getBalance());
        model.addAttribute("friends", user.getFriends());

        return "transaction";
    }

    @PostMapping("/transaction")
    public String addToBalance(AddToBalanceForm addToBalanceForm, HttpServletRequest request) {
        User user = userService.getCurrentLoggedUser(request);
            transactionService.addToBalance(user, addToBalanceForm);

            return "transaction";
    }

    @PostMapping("/transaction")
    public String sendToFriend(SendToFriend sendToFriend, HttpServletRequest request) {
        User user = userService.getCurrentLoggedUser(request);
            transactionService.sendToFriend(user, sendToFriend);

            return "transaction";
    }

}
