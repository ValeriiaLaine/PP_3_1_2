package com.example.mvc_boot.controller;

import com.example.mvc_boot.model.User;
import com.example.mvc_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String hello() {
        return "/hello";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "getUser";
    }

    @GetMapping("/add")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") @Valid  User user, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "add";
        }

        userService.addUser(user);
        return "redirect:/all";
    }

    @GetMapping("/{id}/modify")
    public String modify(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "modify";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute ("user") @Valid User updateUser, @PathVariable("id") Long id,
                         BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "modify";
        }

        userService.updateUser(id, updateUser);
        return "redirect:/all";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/all";
    }
}
