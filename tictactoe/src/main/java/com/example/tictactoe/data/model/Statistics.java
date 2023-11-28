package com.example.tictactoe.data.model;

import javax.persistence.*;



@Entity
@Table(name = "statistics")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "draws")
    private Integer draws;

    @Column(name = "wins")
    private Integer wins;

    @Column(name = "losses")
    private Integer losses;

    @OneToOne(mappedBy = "statistics")
    private User user;

    public Statistics() {
        draws = 0;
        wins = 0;
        losses = 0;
    }

    public Statistics(User user) {
        this.user = user;
    }

    public Integer getDraws() {
        return draws;
    }

    public Integer getWins() {
        return wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void win() {
        this.wins++;
    }

    public void lose() {
        this.losses++;
    }

    public void draw() {
        this.draws++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
