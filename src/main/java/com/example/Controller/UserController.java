package com.example.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class UserController {

    @GetMapping("/dev")
    public int function(){
        return 123;

    }
}
