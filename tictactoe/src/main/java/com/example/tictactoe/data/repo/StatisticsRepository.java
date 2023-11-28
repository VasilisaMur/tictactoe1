package com.example.tictactoe.data.repo;

import com.example.tictactoe.data.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Long> {

}
