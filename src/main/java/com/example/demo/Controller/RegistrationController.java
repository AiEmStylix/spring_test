package com.example.demo.Controller;

import com.example.demo.Model.UserModel;
import com.example.demo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value = "/req/signup",consumes = "application/json")
    public UserModel createUser(@RequestBody UserModel user)
    {
        if (userRepo.findByUsername(user.getUsername()).isPresent())
        {
            throw new UnsupportedOperationException("Username is already taken");
        }
        if (user.getPassword().length() < 8)
        {
            throw new UnsupportedOperationException("Password is too short");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
