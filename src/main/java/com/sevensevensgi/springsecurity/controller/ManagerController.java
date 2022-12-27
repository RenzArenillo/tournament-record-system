package com.sevensevensgi.springsecurity.controller;

import com.sevensevensgi.springsecurity.model.Team;
import com.sevensevensgi.springsecurity.model.User;
import com.sevensevensgi.springsecurity.repository.GameRecordResultsRepository;
import com.sevensevensgi.springsecurity.repository.PlayerRepository;
import com.sevensevensgi.springsecurity.repository.TeamRepository;
import com.sevensevensgi.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private PlayerRepository playerRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TeamRepository teamRepo;

    @Autowired
    private GameRecordResultsRepository recordRepo;

    @GetMapping("/home")
    public String forManager(Principal p, ModelMap m){
        User user = userRepo.findByUsername(p.getName());
        teamRepo.findById(user.getTeamId()).ifPresent(o -> m.addAttribute("team", o));
        m.addAttribute("name", user.getFullname());
        return "manager/home";
    }

    @GetMapping("/games")
    public String games(ModelMap m, Principal p){
        User user = userRepo.findByUsername(p.getName());
        m.addAttribute("games", recordRepo.findByTeamID(user.getTeamId()));
        return "manager/team_record";
    }

    @GetMapping("/roster")
    public String roster(ModelMap m, Principal p){
        User user = userRepo.findByUsername(p.getName());
        teamRepo.findById(user.getTeamId()).ifPresent(o -> m.addAttribute("team", o));
        m.addAttribute("members", playerRepo.findByTeamID(user.getTeamId()));
        return "manager/team_roster";
    }

    @GetMapping("/logout")
    public String logout(ModelMap m){
        return "redirect:/logout";
    }

}
