package com.sevensevensgi.springsecurity.controller;

import com.sevensevensgi.springsecurity.model.GameRecord;
import com.sevensevensgi.springsecurity.model.User;
import com.sevensevensgi.springsecurity.repository.GameRecordRepository;
import com.sevensevensgi.springsecurity.repository.GameRecordResultsRepository;
import com.sevensevensgi.springsecurity.repository.TeamRepository;
import com.sevensevensgi.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TeamRepository teamRepo;

    @Autowired
    private GameRecordRepository gameRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private GameRecordResultsRepository recordRepo;

    @GetMapping("/home")
    public String forAdmin(Principal p, ModelMap m){
        User user = userRepo.findByUsername(p.getName());
        m.addAttribute("name", user.getFullname());
        return "admin/home";
    }

    @GetMapping("/approval_page")
    public String forApproval(){
        return "admin/approval_page";
    }

    @GetMapping("/games")
    public String games(ModelMap m){

        Date date = new Date();
        List<GameRecord> today = gameRepo.findByDate(date);
        List<GameRecord> upcoming = gameRepo.findByDateAfterOrderByDate(date);
        List<GameRecord> merged = new ArrayList<>();
        merged.addAll(today);
        merged.addAll(upcoming);

        m.addAttribute("games", merged);


        return "admin/view_games";
    }

    @GetMapping("/managers")
    public String managers(ModelMap m){
        m.addAttribute("managers", userRepo.findByRole("ROLE_MANAGER"));

        return "admin/view_managers";
    }

    @GetMapping("/officials")
    public String officials(ModelMap m){
        m.addAttribute("officials", userRepo.findByRole("ROLE_OFFICIAL"));

        return "admin/view_officials";
    }

    @GetMapping("/records")
    public String records(ModelMap m){

        m.addAttribute("results", recordRepo.findAll());

        return "admin/view_records";
    }

    @GetMapping("/teams")
    public String teams(ModelMap m){
        m.addAttribute("teams", teamRepo.findAll());
        return "admin/view_teams";
    }

    @GetMapping("/create_game")
    public String createGame(ModelMap m){
        return "admin/create_game";
    }

    @GetMapping("/logout")
    public String logout(ModelMap m){
        return "redirect:/logout";
    }


}
