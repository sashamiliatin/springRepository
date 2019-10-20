package com.miliatin.tictactoe.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miliatin.tictactoe.entity.User;
import com.miliatin.tictactoe.model.BoardModel;
import com.miliatin.tictactoe.model.BoardModel.Marker;
import com.miliatin.tictactoe.service.BoardMarkerService;
import com.miliatin.tictactoe.service.BoardMarkerService.*;
import com.miliatin.tictactoe.model.PlayersModel.Player;
import com.miliatin.tictactoe.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.miliatin.tictactoe.model.BoardModel.MarkersList;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GameController {
int PlayerPoints ;
int ComPoints ;
    PointsService pointsService = new PointsService();


    @ResponseBody
    @RequestMapping(value = "/resetplayers" , method = RequestMethod.GET)
    public List<Player>  getPlayer(){
        List<Player> players;
        players =  pointsService.ResetPoints();
    /*PlayerPoints = 0;
    ComPoints = 0;

         List<Player> players =  Arrays.asList(new Player("Player",PlayerPoints,"X",false),
                 new Player( "Computer",ComPoints,"O",false));*/
        System.out.println(players.toString());

        return players;
    }

    @RequestMapping(value = "/updateboard",method = RequestMethod.POST )
    @JsonProperty("Marker")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
        public  List<Marker> updateBoard(@RequestBody List<Marker> board){
        String checkWinner;
        List<Marker> boardMarkers;
        BoardMarkerService boardMarkerService = new BoardMarkerService();
        checkWinner = boardMarkerService.checkWinner(board);
        if (checkWinner == "NO"){
           boardMarkers = boardMarkerService.getBestMove(board);
            checkWinner =  boardMarkerService.checkWinner(boardMarkers);
            if (checkWinner != "NO"){

                boardMarkers.get(0).setWin(checkWinner);
            }
        }
        else {
            boardMarkers = board;
            boardMarkers.get(0).setWin(checkWinner);
        }

        return boardMarkers;
        }
        @ResponseBody
        @RequestMapping(value = "/resetboard", method = RequestMethod.GET)
        public List<Marker> resetBoard(){

            List<Marker> markers = new ArrayList<Marker>();

                markers = Arrays.asList(new Marker(1, "BLANK", ""),
                        new Marker(2, "BLANK", ""),
                        new Marker(3, "BLANK", ""),
                        new Marker(4, "BLANK", ""),
                        new Marker(5, "BLANK", ""),
                        new Marker(6, "BLANK", ""),
                        new Marker(7, "BLANK", ""),
                        new Marker(8, "BLANK", ""),
                        new Marker(9, "BLANK", "")) ;
            System.out.println(markers.toString());
            return markers;
        }

        @RequestMapping(value = "/updatepoints" , method = RequestMethod.POST)
        @ResponseBody
        public List<Player> updatePoints(@RequestParam Integer id) {

        List<Player> players;
        players = pointsService.UpdatePoints(id);

            System.out.println(PlayerPoints+ComPoints+1);
            return players;
        }

}
