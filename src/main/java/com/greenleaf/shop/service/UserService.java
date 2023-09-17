package com.greenleaf.shop.service;

import com.greenleaf.shop.model.User;
import com.greenleaf.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    /**
     * maybe later return something if went wrong
     * @param user
     */
    public User registerUser(User user){
        return userRepository.save(user);
    }
}
