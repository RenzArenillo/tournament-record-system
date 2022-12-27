package com.sevensevensgi.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/official")
public class OfficialController {

    @GetMapping("/home")
    public String forOfficial(){
        return "official/home";
    }
}
