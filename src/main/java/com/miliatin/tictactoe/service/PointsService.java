package com.miliatin.tictactoe.service;

import com.miliatin.tictactoe.model.PlayersModel.*;

import java.util.Arrays;
import java.util.List;

public class PointsService {
    int PlayerPoints = 0;
    int ComputerPoints = 0;
    List<Player> players = Arrays.asList(new Player("Player",PlayerPoints,"X",false),
            new Player("Computer",ComputerPoints,"O",false));

    public List<Player> UpdatePoints(int id){
        if (id == 0){
            PlayerPoints++;
            players.get(0).setPoints(PlayerPoints);
        }
        if (id==1){
            ComputerPoints++;
            players.get(1).setPoints(ComputerPoints);
        }
        return players;
    }
    public List<Player> ResetPoints(){
        PlayerPoints = 0;
        ComputerPoints = 0;
        players.get(0).setPoints(PlayerPoints);
        players.get(1).setPoints(ComputerPoints);
        return players;
    }
}
