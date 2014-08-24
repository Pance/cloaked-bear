package com.pance.controller;

import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class Home {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
}