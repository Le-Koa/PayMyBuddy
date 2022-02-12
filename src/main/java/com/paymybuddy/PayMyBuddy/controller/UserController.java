package com.paymybuddy.PayMyBuddy.controller;

import com.paymybuddy.PayMyBuddy.model.User;
import com.paymybuddy.PayMyBuddy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage(Model model, HttpServletRequest request) {
        User user = userService.getCurrentLoggedUser(request);
        model.addAttribute("user", user);
        model.addAttribute("friend", user.getFriends());
        return  "homePage";

    }

    @GetMapping(value = "/profile")
    public String profilePage(Model model, HttpServletRequest request){
        User user = userService.getCurrentLoggedUser(request);
        model.addAttribute("user", user);
        return "profile";
    }
}
