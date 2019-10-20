package com.miliatin.tictactoe.controller;

import com.miliatin.tictactoe.entity.AndroidUser;
import com.miliatin.tictactoe.entity.User;
import com.miliatin.tictactoe.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("user")
public class UserController {


    private UserService userService;
    private User user;
    @GetMapping("user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id){
        AndroidUser androidUser = userService.GetUser(id);
        user = androidUser.getUser();
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("adduser")
    public ResponseEntity<Void> addUser(@RequestBody User user ,@PathVariable("id") String id, UriComponentsBuilder builder){
        userService.CreateUser(id,user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("user/{id}").buildAndExpand(id).toUri());
        return new ResponseEntity<Void>(headers , HttpStatus.OK);
    }
    @PostMapping("update")
    public ResponseEntity<Void> updateUser(@RequestBody User user , String id){
        userService.UpdateUser(id,user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @DeleteMapping("delete")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id){
        userService.DeleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
