package com.paymybuddy.PayMyBuddy.service;

import com.paymybuddy.PayMyBuddy.model.User;
import com.paymybuddy.PayMyBuddy.repository.UserRepository;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import org.springframework.security.core.context.SecurityContextHolder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final SecurityContextLogoutHandler securityContextLogoutHandler;


    public UserServiceImpl(UserRepository userRepository, SecurityContextLogoutHandler securityContextLogoutHandler) {
        this.userRepository = userRepository;
        this.securityContextLogoutHandler = securityContextLogoutHandler;
    }


    @Override
    public void registerUser(User user) {
        User alreadyRegisteredUser = userRepository.findUserByEmail(user.getEmail());
        if (alreadyRegisteredUser != null) {
            try {
                int year = Calendar.getInstance().getWeekYear();
                int userYear = user.getBirthdate().getYear();
                if ((year - userYear) < 18 ){
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            String password = user.getPassword();
                user.setPassword(password);
                userRepository.save(user);

        }
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            securityContextLogoutHandler.logout(request, response, auth);
        }
    }

    @Override
    public User getCurrentLoggedUser(HttpServletRequest request) {
        return userRepository.findUserByEmail(request.getUserPrincipal().getName());
    }
}
