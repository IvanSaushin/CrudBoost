package com.springboot.controller;

import com.springboot.model.User;
import com.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/bootstrap")
public class BootstrapController {

    private final UserService userService;

    public BootstrapController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/adminpage")
    public String getAdmin(Model model) {
        log.info("Вход на страницу /adminpage");
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("person", new User());
        return "/bootstrap/adminpage";
    }

    @GetMapping("/userpage")
    public String getUser(Model model) {
        log.info("Вход на страницу /userpage");
        UserDetails userDetails = (UserDetails)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userDetails);
        return "/bootstrap/userpage";
    }

}
