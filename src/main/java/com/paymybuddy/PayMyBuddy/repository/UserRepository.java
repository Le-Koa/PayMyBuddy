package com.paymybuddy.PayMyBuddy.repository;


import com.paymybuddy.PayMyBuddy.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

User findUserByEmail(String email);
}
