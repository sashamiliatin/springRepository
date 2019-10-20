package com.miliatin.tictactoe.controller;

import com.miliatin.tictactoe.entity.AndroidUser;
import com.miliatin.tictactoe.entity.User;
import com.miliatin.tictactoe.request.CreateUserRequest;
import com.miliatin.tictactoe.request.UpdateUserRequest;
import com.miliatin.tictactoe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        AndroidUser androidUser = userService.getUser(id);
        return androidUser.getUser();
    }

    @PostMapping
    public void addUser(@RequestBody CreateUserRequest request) {
        userService.createUser(request.getUserId(), request.getUser());
    }

    @PostMapping("/{id}")
    public void updateUser(@RequestBody UpdateUserRequest request, @PathVariable String id){
        userService.updateUser(id, request.getUser());
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }
}
