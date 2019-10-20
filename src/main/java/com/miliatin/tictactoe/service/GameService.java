package com.miliatin.tictactoe.service;

import com.miliatin.tictactoe.model.BoardModel;
import com.miliatin.tictactoe.model.PlayersModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import com.miliatin.tictactoe.model.BoardModel.Marker;
import com.miliatin.tictactoe.model.PlayersModel.Player;
import java.util.Arrays;
import java.util.List;


public class GameService {
    int PlayerPoints = 0;
    int ComputerPoints = 0;
    List<Marker> markers;
    List<Player> players;

    private void NewGame(){
        for (int i=0;i<9;i++) {
            markers.get(i).setId(i);
            markers.get(i).setMarker("");
            markers.get(i).setWin("");
        }

    }

    private void GameState(){

    }
}
