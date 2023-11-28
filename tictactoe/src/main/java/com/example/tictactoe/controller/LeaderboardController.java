package com.example.tictactoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.tictactoe.service.StatisticsService;


@Controller
public class LeaderboardController {

    @Autowired
    StatisticsService statisticsService;

    @GetMapping("/leaderboard")
    public ModelAndView leaderboard() {
        ModelAndView mav = new ModelAndView("leaderboard");
        mav.addObject("statistics", statisticsService.findAll());
        return mav;
    }

}
