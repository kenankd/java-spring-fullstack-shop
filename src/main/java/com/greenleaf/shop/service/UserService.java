package com.greenleaf.shop.service;

import com.greenleaf.shop.model.User;
import com.greenleaf.shop.repository.UserRepository;
import com.greenleaf.shop.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    /**
     * maybe later return something if went wrong
     *
     * @param user
     */
    public ResponseEntity<ApiResponse<User>> registerUser(User user){
            var uss= userRepository.findByEmail(user.getEmail());
            if(userRepository.existsByEmail(user.getEmail())){
                return ResponseEntity.badRequest().body(
                        new ApiResponse<>(false,"User with given email already registered",user));
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return ResponseEntity.status(201).body(new ApiResponse<>(true,"User registered",user));
    }

    public void authenticate(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
        //var user = userRepository.findByEmail(email).orElseThrow();
    }
}
