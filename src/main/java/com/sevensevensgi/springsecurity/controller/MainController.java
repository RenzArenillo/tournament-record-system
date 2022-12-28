package com.sevensevensgi.springsecurity.controller;

import com.sevensevensgi.springsecurity.model.Team;
import com.sevensevensgi.springsecurity.repository.GameRecordRepository;
import com.sevensevensgi.springsecurity.repository.GameRecordResultsRepository;
import com.sevensevensgi.springsecurity.repository.PlayerRepository;
import com.sevensevensgi.springsecurity.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class MainController {

    @Autowired
    private TeamRepository teamRepo;

    @Autowired
    private PlayerRepository playerRepo;

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

    @RequestMapping(value = "/team{id}", method = RequestMethod.GET)
    public String appointment(@PathVariable("id") int id, ModelMap m) {
        teamRepo.findById(id).ifPresent(o -> m.addAttribute("team", o));
        m.addAttribute("members", playerRepo.findByTeamID(id));

        return "team_info";
    }

}

