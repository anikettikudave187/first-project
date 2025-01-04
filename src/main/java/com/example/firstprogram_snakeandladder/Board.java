package com.example.firstprogram_snakeandladder;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    ArrayList<Pair<Integer,Integer>> position;
    ArrayList<Integer> snakeLadderPosition;

    public Board(){
        position=new ArrayList<>();
        populatePosition();
        populatesetSnakeLadder();
    }

    private void populatePosition(){
        position.add(new Pair<>(0,0));
        for (int i = 0; i < SnakeAndLadder.height; i++) {
            for (int j = 0; j < SnakeAndLadder.width; j++) {
                int xCord=0;
                if(i%2==0){
                    xCord=j*SnakeAndLadder.tileSize+SnakeAndLadder.tileSize/2;
                }else{
                    xCord=SnakeAndLadder.tileSize*SnakeAndLadder.height-(j*SnakeAndLadder.tileSize)-SnakeAndLadder.tileSize/2;
                }
                int yCord=SnakeAndLadder.tileSize*SnakeAndLadder.height-(i*SnakeAndLadder.tileSize)-SnakeAndLadder.tileSize/2;
                position.add(new Pair<>(xCord,yCord));
            }
        }

    }
    private void populatesetSnakeLadder(){
        snakeLadderPosition=new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            snakeLadderPosition.add(i);
        }
        snakeLadderPosition.set(1,38);
        snakeLadderPosition.set(4,14);
        snakeLadderPosition.set(9,31);
        snakeLadderPosition.set(17,7);
        snakeLadderPosition.set(21,42);
        snakeLadderPosition.set(28,84);
        snakeLadderPosition.set(51,67);
        snakeLadderPosition.set(54,34);
        snakeLadderPosition.set(62,19);
        snakeLadderPosition.set(64,60);
        snakeLadderPosition.set(72,91);
        snakeLadderPosition.set(80,99);
        snakeLadderPosition.set(87,36);
        snakeLadderPosition.set(93,73);
        snakeLadderPosition.set(95,75);
        snakeLadderPosition.set(98,79);

    }
    public int getNewPosition(int currPosition){
        if(currPosition>=0 && currPosition<=100){
            return snakeLadderPosition.get(currPosition);
        }
        return -1;
    }
    int getXcordinates(int pos){
        if(pos>=1 && pos<=100){
            return position.get(pos).getKey();
        }
        return -1;
    }
    int getycordinates(int pos){
        if(pos>=1 && pos<=100){
            return position.get(pos).getValue();
        }
        return -1;
    }

    /*public static void main(String[] args) {
        Board board=new Board();
        for (int i = 0; i < board.position.size(); i++) {
            System.out.println(i+" $ x : "+board.position.get(i).getKey()+" y : "+board.position.get(i).getValue());
        }
    }*/
}
