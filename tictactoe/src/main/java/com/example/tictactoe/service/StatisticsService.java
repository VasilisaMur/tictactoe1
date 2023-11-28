package com.example.tictactoe.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tictactoe.data.model.Statistics;
import com.example.tictactoe.data.repo.StatisticsRepository;

import java.util.List;
import java.util.Optional;


@Service
public class StatisticsService {

    @Autowired
    StatisticsRepository statisticsRepository;

    public Statistics findById(Long id) throws Exception {
        Optional<Statistics> statistics = statisticsRepository.findById(id);
        if (statistics.isPresent()) {
            return statistics.get();
        } else {
            throw new Exception(String.format("Statistics with id={%d} not found", id));
        }
    }

    public List<Statistics> findAll() {
        return statisticsRepository.findAll();
    }

    public void save(Statistics statistics) {
        statisticsRepository.save(statistics);
    }

    public boolean deleteById(Long id) {
        if (statisticsRepository.findById(id).isPresent()) {
            statisticsRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
