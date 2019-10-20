package com.miliatin.tictactoe.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class BoardModel {

    public static class Marker{
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("marker")
        private String marker;
        @JsonProperty("win")
        private String win;

        public Marker(Integer id,  String marker, String win) {
            this.id = id;
            this.marker = marker;
            this.win = win;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getMarker() {
            return marker;
        }

        public void setMarker(String marker) {
            this.marker = marker;
        }

        public String getWin() {
            return win;
        }

        public void setWin(String win) {
            this.win = win;
        }
    }
public class MarkersList{
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("marker")
    private String marker;
    @JsonProperty("win")
    private String win;
        private List<Marker> markers;
        public MarkersList(){
            markers= new ArrayList<>();
        }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public List<Marker> getMarkers() {
        return markers;
    }

    public void setMarkers(List<Marker> markers) {
        this.markers = markers;
    }

    public MarkersList(Integer id, String marker, String win, List<Marker> markers) {
        this.id = id;
        this.marker = marker;
        this.win = win;
        this.markers = markers;
    }
}

public class NewGame{
        private NewGame(){

        }
    }
}
