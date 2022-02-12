package com.paymybuddy.PayMyBuddy.controller;

import com.paymybuddy.PayMyBuddy.form.AddFriendForm;
import com.paymybuddy.PayMyBuddy.model.User;
import com.paymybuddy.PayMyBuddy.service.FriendService;
import com.paymybuddy.PayMyBuddy.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@AllArgsConstructor
@Controller
public class FriendController {
    private final FriendService friendService;
    private final UserService userService;


    @GetMapping(value = "/friends")
    public String addFriendPage(Model model, HttpServletRequest request) {
        User user = userService.getCurrentLoggedUser(request);
        model.addAttribute("friends", user.getFriends());
        return "friends";
    }

    @GetMapping("/friend")
    public String addFriend(AddFriendForm addFriendForm, HttpServletRequest request) {
        User user = userService.getCurrentLoggedUser(request);
            friendService.addFriend(addFriendForm, user);

            return "friend";
    }
}
