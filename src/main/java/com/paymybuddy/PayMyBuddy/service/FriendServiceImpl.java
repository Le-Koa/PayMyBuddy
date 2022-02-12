package com.paymybuddy.PayMyBuddy.service;

import com.paymybuddy.PayMyBuddy.form.AddFriendForm;
import com.paymybuddy.PayMyBuddy.model.Friend;
import com.paymybuddy.PayMyBuddy.model.User;
import com.paymybuddy.PayMyBuddy.repository.FriendRepository;
import com.paymybuddy.PayMyBuddy.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;


@AllArgsConstructor
@Controller
public class FriendServiceImpl implements FriendService {
    private final UserRepository userRepository;
    private final FriendRepository friendRepository;


    @Override
    public void addFriend(AddFriendForm addFriendForm, User user) {
        User friend = userRepository.findUserByEmail(addFriendForm.getEmailFriend());

        Friend friend1 = new Friend();
        friend1.setUserFriend(friend);
        friendRepository.save(friend1);

    }
}
