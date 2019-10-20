package com.miliatin.tictactoe.entity;

import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    int id;
    @Column(name = "user_name")
    String name;
    @Column(name = "user_games")
    Integer games;
    @Column(name = "user_wins")
    Integer wins;

    public User(String name, Integer games, Integer wins) {
        this.name = name;
        this.games = games;
        this.wins = wins;
    }
    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }
}
