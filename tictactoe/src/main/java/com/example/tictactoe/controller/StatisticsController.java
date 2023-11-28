package com.example.tictactoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.tictactoe.data.model.Statistics;
import com.example.tictactoe.data.model.User;
import com.example.tictactoe.service.StatisticsService;
import com.example.tictactoe.service.UserService;


@Controller
public class StatisticsController {

    @Autowired
    UserService userService;
    @Autowired
    StatisticsService statisticsService;

    @GetMapping("/win")
    public String win(@CurrentSecurityContext(expression="authentication?.name") String username) {
        User user = userService.findByUsername(username);
        Statistics statistics = user.getStatistics();
        statistics.win();
        statisticsService.save(statistics);
        return "redirect:/main";
    }

    @GetMapping("/draw")
    public String draw(@CurrentSecurityContext(expression="authentication?.name") String username) {
        User user = userService.findByUsername(username);
        Statistics statistics = user.getStatistics();
        statistics.draw();
        statisticsService.save(statistics);
        return "redirect:/main";
    }

    @GetMapping("/lose")
    public String lose(@CurrentSecurityContext(expression="authentication?.name") String username) {
        User user = userService.findByUsername(username);
        Statistics statistics = user.getStatistics();
        statistics.lose();
        statisticsService.save(statistics);
        return "redirect:/main";
    }

}
