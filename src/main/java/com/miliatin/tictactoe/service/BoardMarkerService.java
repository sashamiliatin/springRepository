package com.miliatin.tictactoe.service;
import com.miliatin.tictactoe.model.BoardModel.Marker;

import java.util.List;
import java.util.Random;

public class BoardMarkerService {
     private String markerBoard ;

     public List<Marker> getBestMove(List<Marker> Marker){
         int diag1[] = {0,4,8};
         int diag2[] = {2,4,6};
        List<Marker>  marker = Marker;

        //check center
         if (marker.get(4).getMarker().equals("BLANK")){
              if (marker.get(0).getMarker().equals("X")&&marker.get(8).getMarker().equals("X")||
                      marker.get(1).getMarker().equals("X")&&marker.get(7).getMarker().equals("X")||
                      marker.get(2).getMarker().equals("X")&&marker.get(6).getMarker().equals("X")||
                      marker.get(3).getMarker().equals("X")&&marker.get(5).getMarker().equals("X")){
                  marker.get(4).setMarker("O");
                  return marker;
              }
         }
         //check vertical
         for (int i = 0; i<9 ;i+=3){
             int xCount =0;
             int bCount =0;
             int oCount = 0;
            for (int j= 0;j<3;j++){
                if (marker.get(i+j).getMarker().equals("X")){
                    xCount+=1;
                }
                if (marker.get(i+j).getMarker().equals("O")){
                    oCount+=1;
                }
                if (marker.get(i+j).getMarker().equals("BLANK")){
                    bCount+=1;
                }

            }
            if ((xCount==2)&&(bCount==1)||(oCount== 2)&&(bCount==1)){
                for (int col = 0;col<3;col++){
                    if (marker.get(i+col).getMarker().equals("BLANK")){
                        marker.get(i+col).setMarker("O");
                        return marker;
                    }
                }
            }
         }
         //check horizontal
         for (int i =0;i<3;i++){
             int xCount =0;
             int bCount =0;
             int oCount =0;
             for (int j = 0;j<9;j+=3){
                 if (marker.get(i+j).getMarker().equals("X")){
                     xCount+=1;
                 }
                 if (marker.get(i+j).getMarker().equals("O")){
                     oCount+=1;
                 }
                 if (marker.get(i+j).getMarker().equals("BLANK")){
                     bCount+=1;
                 }
             }
             if ((xCount==2)&&(bCount==1)||(oCount==2)&&(bCount==1)){
                 for (int row=0;row<9;row+=3){
                     if (marker.get(i+row).getMarker().equals("BLANK")){
                         marker.get(i+row).setMarker("O");
                         return marker;
                     }
                 }
             }
         }
         //check diagonal
         for (int j = 0 ; j<1;j++) {
             int xCount = 0;
             int bCount = 0;
             int oCount = 0;
             for (int i : diag1) {

                 if (marker.get(i).getMarker().equals("X")) {
                     xCount += 1;
                 }
                 if (marker.get(i).getMarker().equals("O")) {
                     oCount += 1;
                 }
                 if (marker.get(i).getMarker().equals("BLANK")) {
                     bCount += 1;
                 }

             }
             if ((xCount == 2) && (bCount == 1) || (oCount == 2) && (bCount == 1)) {
                 for (int diag : diag1) {
                     if (marker.get(diag).getMarker().equals("BLANK")) {
                         marker.get(diag).setMarker("O");
                         return marker;
                     }
                 }
             }
         }
         for (int j = 0;j<1;j++) {
             int xCount = 0;
             int bCount = 0;
             int oCount = 0;
             for (int i : diag2) {

                 if (marker.get(i).getMarker().equals("BLANK")) {
                     bCount += 1;
                 }
                 if (marker.get(i).getMarker().equals("X")) {
                     xCount += 1;
                 }
                 if (marker.get(i).getMarker().equals("O")) {
                     oCount += 1;
                 }

             }
             if ((xCount == 2) && (bCount == 1) || (oCount == 2) && (bCount == 1)) {
                 for (int diag : diag2) {
                     if (marker.get(diag).getMarker().equals("BLANK")) {
                         marker.get(diag).setMarker("O");
                         return marker;
                     }
                 }
             }
         }
         if (marker.get(4).getMarker().equals("BLANK")){
             marker.get(4).setMarker("O");
             return marker;
         }
         Boolean found = false;
         Random random = new Random();
         while (!found){
             int index = random.nextInt(8);
             if (marker.get(index).getMarker().equals("BLANK")){
                 marker.get(index).setMarker("O");
                 found = true;
             }
         }
         return marker;
     }
     public String checkWinner(List<Marker> Marker) {
         List<Marker> markers = Marker;
         int count = 0;
         String winner;
        //check draw
         for (int i= 0;i< 9;i++ ){
             if (markers.get(i).getMarker().equals("O")||markers.get(i).getMarker().equals("X")){
                 count+=1;
             }
             if (count==9){
                 return winner = "draw";
             }
         }
        if (!markers.get(0).getMarker().equals("BLANK")) {
            if ((markers.get(0).getMarker().equals(markers.get(1).getMarker()) && markers.get(1).getMarker().equals(markers.get(2).getMarker()) ||
                    (markers.get(0).getMarker().equals(markers.get(3).getMarker()) && markers.get(0).getMarker().equals(markers.get(6).getMarker())) ||
                    (markers.get(0).getMarker().equals(markers.get(4).getMarker()) && markers.get(0).getMarker().equals(markers.get(8).getMarker())))) {
                return winner = markers.get(0).getMarker();

            }
        }
        if(!markers.get(1).getMarker().equals("BLANK")) {
            if (markers.get(1).getMarker().equals(markers.get(4).getMarker()) && markers.get(1).getMarker().equals(markers.get(7).getMarker())) {
                return winner = markers.get(1).getMarker();
            }
        }
         if (!markers.get(2).getMarker().equals("BLANK")) {
             if ((markers.get(2).getMarker().equals(markers.get(4).getMarker()) && markers.get(2).getMarker().equals(markers.get(6).getMarker())) ||
                     (markers.get(2).getMarker().equals(markers.get(5).getMarker()) && markers.get(2).getMarker().equals(markers.get(8).getMarker()))) {
                 return winner = markers.get(2).getMarker();
             }
         }
         if (!markers.get(3).getMarker().equals("BLANK")) {
             if (markers.get(3).getMarker().equals(markers.get(4).getMarker()) && markers.get(3).getMarker().equals(markers.get(5).getMarker())) {
                 return winner = markers.get(3).getMarker();
             }
         }
         if (!markers.get(6).getMarker().equals("BLANK")) {
             if (markers.get(6).getMarker().equals(markers.get(7).getMarker()) && markers.get(6).getMarker().equals(markers.get(8).getMarker())) {
                 return winner = markers.get(6).getMarker();
             }
         }
             return winner = "NO";
     }
}
