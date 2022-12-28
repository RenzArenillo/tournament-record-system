package com.sevensevensgi.springsecurity.controller;

import com.sevensevensgi.springsecurity.repository.GameRecordRepository;
import com.sevensevensgi.springsecurity.repository.GameRecordResultsRepository;
import com.sevensevensgi.springsecurity.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class MainController {

    @Autowired
    private TeamRepository teamRepo;

    @Autowired
    private GameRecordResultsRepository recordRepo;

    @Autowired
    private GameRecordRepository gameRepo;

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
    @GetMapping("/today")
    public String today(ModelMap m) {
        Date date = new Date();

        m.addAttribute("today", gameRepo.findByDate(date));
        return "games_today";
    }
    @GetMapping("/upcoming")
    public String upcoming(ModelMap m) {
        Date date = new Date();

        m.addAttribute("upcoming", gameRepo.findByDateAfterOrderByDate(date));
        return "upcoming";
    }

    @GetMapping("/teams")
    public String teams(ModelMap m) {
        m.addAttribute("teams", teamRepo.findAll());
        return "teams";
    }


}

