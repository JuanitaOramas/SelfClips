package eci.selfClips.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
class UserController {

    @GetMapping("/create")
    public String createUser(){
        return "<h1>The API is working ok!</h1>";
    }

}