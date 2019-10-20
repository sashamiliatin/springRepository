package com.miliatin.tictactoe.model;

import java.util.List;
import java.util.Objects;




public class PlayersModel {

    public static class Player {



        private String name;
        private Integer points;
        private String marker;
        private boolean win;
        public Player(){

        }
        public Player( String name, Integer points,String marker, boolean win) {
            this.name = name;
            this.points = points;
            this.marker = marker;
            this.win = win;
        }

        public String getMarker() {
            return marker;
        }

        public void setMarker(String marker) {
            this.marker = marker;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getPoints() {
            return points;
        }

        public void setPoints(Integer points) {
            this.points = points;
        }

        public boolean isWin() {
            return win;
        }

        public void setWin(boolean win) {
            this.win = win;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Player player = (Player) o;
            return win == player.win &&
                    name.equals(player.name) &&
                    marker.equals(player.marker)&&
                    points.equals(player.points) ;
        }

        @Override
        public int hashCode() {
            return Objects.hash( name, points,marker, win);
        }

        @Override
        public String toString() {
            return "Player{" +
                    " name='" + name + '\'' +
                    ", points=" + points +
                    ", marker=" + marker +
                    ", win=" + win +
                    '}';
        }
    }

}
