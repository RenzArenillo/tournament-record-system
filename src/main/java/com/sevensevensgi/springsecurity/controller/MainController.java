package com.sevensevensgi.springsecurity.controller;

import com.sevensevensgi.springsecurity.repository.GameRecordResultsRepository;
import com.sevensevensgi.springsecurity.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private TeamRepository teamRepo;

    @Autowired
    private GameRecordResultsRepository recordRepo;
    @GetMapping({"/home", "/"})
    public String home() {
        return "home";
    }

    @GetMapping("/access-denied")
    public String access() {
        return "access-denied";
    }

    @GetMapping("/results")
    public String results(ModelMap m) {
        m.addAttribute("results", recordRepo.findAll());
        return "results";
    }

    @GetMapping("/upcoming")
    public String upcoming() {
        return "upcoming";
    }

    @GetMapping("/teams")
    public String teams(ModelMap m) {
        m.addAttribute("teams", teamRepo.findAll());
        return "teams";
    }


}

