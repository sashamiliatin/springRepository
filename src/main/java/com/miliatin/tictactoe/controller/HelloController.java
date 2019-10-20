package com.miliatin.tictactoe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
@GetMapping
@ResponseBody
     public String getName(@RequestParam String name){
     return "Hello :" + name;
    }
}
