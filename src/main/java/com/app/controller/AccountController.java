package com.app.controller;

import com.app.service.UserDto;
import com.app.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "user")
public class AccountController {
    private final UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getUserById() {
        return userService.getUsers();
    }

    @PostMapping
    public void register(@RequestBody UserDto userDto){
        userService.register(userDto);
    }
}
