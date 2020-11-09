package com.mildw.minsu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @GetMapping("/")
    public String index(){
        return "hello world";
    }
}
