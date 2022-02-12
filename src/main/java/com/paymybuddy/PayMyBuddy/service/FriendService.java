package com.paymybuddy.PayMyBuddy.service;

import com.paymybuddy.PayMyBuddy.form.AddFriendForm;
import com.paymybuddy.PayMyBuddy.model.User;

public interface FriendService {

    void addFriend(AddFriendForm addFriendForm, User user);
}
