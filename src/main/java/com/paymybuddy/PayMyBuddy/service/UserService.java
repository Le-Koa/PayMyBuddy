package com.paymybuddy.PayMyBuddy.service;

import com.paymybuddy.PayMyBuddy.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {

    void registerUser(User user);

    void logout(HttpServletRequest request, HttpServletResponse response);

    User getCurrentLoggedUser(HttpServletRequest request);
}
