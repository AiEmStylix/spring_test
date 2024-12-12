package com.example.demo.Controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

    @GetMapping("/error")
    public String error() {return "/error/error";}

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/req/login")
    public String login() {
        return "login";
    }

    @GetMapping("/req/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/index")
    public String index(@AuthenticationPrincipal User loggedInUser, Model model) {
        String username = loggedInUser != null ? loggedInUser.getUsername() : null;
        model.addAttribute("username", username);
        // Add an attribute to pass to the view to check login status
        model.addAttribute("isLoggedIn", loggedInUser != null);
        return "index"; // Render the 'index.html' file
    }

}
