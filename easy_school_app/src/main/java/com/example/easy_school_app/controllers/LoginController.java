package com.example.easy_school_app.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
    public String displayLoginPage(@RequestParam(required = false) boolean error,
            @RequestParam(required = false) boolean logout, @RequestParam(required = false) boolean register,
            Model model) {
        String message = "";
        if (error) {
            message = "Username or password is incorrect!";
        }

        if (logout) {
            message = "Lougout successfully!";
        }

        if (register) {
            message = "Register successfully!Please login";
        }
        model.addAttribute("message", message);
        return "login.html";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest req, HttpServletResponse res) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(req, res, auth);
        }
        return "redirect:/login?logout=true";
    }
}
