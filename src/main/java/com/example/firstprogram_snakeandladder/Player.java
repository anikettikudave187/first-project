package com.example.firstprogram_snakeandladder;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import static com.example.firstprogram_snakeandladder.SnakeAndLadder.tileSize;

public class Player {
    private int currPosition;
    private String name;
    private Circle coin;

    private static Board gameBoard =new Board();
    public Player(int tileSize,Color coinColor,String playerName){
        currPosition= 0;
        coin=new Circle(tileSize/2);
        coin.setFill(coinColor);
        movePlayer(0);
        name=playerName;

    }
    public void movePlayer(int diceVal){
        if(currPosition+diceVal<=100){
            currPosition+=diceVal;
            TranslateTransition secMove=null,firstMove=translateAnimation(diceVal);


            int newPosition= gameBoard.getNewPosition(currPosition);
            if(newPosition!=currPosition && newPosition!=-1){
                currPosition=newPosition;
               secMove= translateAnimation(6);
            }
            if(secMove==null){
                firstMove.play();
            }
            else{
                SequentialTransition sequentialTransition=new SequentialTransition(firstMove, new PauseTransition(Duration.millis(500)),
                        secMove);
                sequentialTransition.play();
            }

        }
        /*int x=gameBoard.getXcordinates(currPosition);
        int y=gameBoard.getycordinates(currPosition);
        coin.setTranslateX(x);
        coin.setTranslateY(y);*/
    }
    public TranslateTransition translateAnimation(int diceVal){
        TranslateTransition animate=new TranslateTransition(Duration.millis(1000),coin);
        animate.setToX(gameBoard.getXcordinates(currPosition));
        animate.setToY(gameBoard.getycordinates(currPosition));
        animate.setAutoReverse(false);
        return animate;
    }
    public void startingPosition(){
        currPosition=0;
        movePlayer(0);
    }

    boolean isWinner(){
        if(currPosition==100){
            return true;
        }
        return false;
    }
    public String getName() {
        return name;
    }

    public int getCurrPosition() {
        return currPosition;
    }

    public Circle getCoin() {
        return coin;
    }
}
