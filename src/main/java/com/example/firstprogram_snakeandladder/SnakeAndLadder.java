package com.example.firstprogram_snakeandladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView ;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//import javax.swing.text.html.ImageView;
import java.io.IOException;

public class SnakeAndLadder extends Application {

    public static final int tileSize=40, width=10, height=10;
    public static final int buttonLine=height*tileSize+50,infoLine=buttonLine-30;

    private Player playerOne,playerTwo;
    private static Dice dice=new Dice();
    private boolean gameStarted =false, playerOneTurn=false, playerTwoTurn=false;

    private Pane createContent(){
        Pane root=new Pane();
        root.setPrefSize( width*tileSize, height*tileSize+100);

        for (int i = 0; i <height; i++) {
            for (int j = 0; j <width ; j++) {
                Tile tile=new Tile(tileSize);
                tile.setTranslateX(j*tileSize);
                tile.setTranslateY(i*tileSize);
                root.getChildren().addAll(tile);
            }
        }
        Image img=new Image("D:\\my project snake and ladder\\9815f360000e51b5fac089785b9616d5.jpg");
        ImageView board=new ImageView();
        board.setImage(img);
        board.setFitHeight(height*tileSize);
        board.setFitWidth(width*tileSize);

        //adding buttons;
        Button playerOneButton=new Button("player one p1");
        Button playerTwoButton =new Button("player Two p2");
        Button startButton=new Button("start");

        playerOneButton.setTranslateY(buttonLine);
        playerOneButton.setTranslateX(20);
        playerTwoButton.setTranslateY(buttonLine);
        playerTwoButton.setTranslateX(290);
        startButton.setTranslateY(buttonLine);
        startButton.setTranslateX(180);

        Label playerOneLabel=new Label("");
        playerOneButton.setDisable(true);
        Label playerTwoLabel=new Label("");
        playerTwoButton.setDisable(true);
        Label startLabel=new Label("start the game");

        //info display;

        playerOneLabel.setTranslateY(infoLine);
        playerOneLabel.setTranslateX(30);
        playerTwoLabel.setTranslateY(infoLine);
        playerTwoLabel.setTranslateX(300);
        startLabel.setTranslateY(infoLine);
        startLabel.setTranslateX(160);

        playerOne =new Player(tileSize, Color.BLACK, "Amit");
        playerTwo=new Player(tileSize-5,Color.WHITE,"Aniket");

        //player action;
        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(playerOneTurn){
                        int diceVal=dice.getRolledDiceValue();
                        startLabel.setText("dice value :"+ diceVal);
                        playerOne.movePlayer(diceVal);
                        if(playerOne.isWinner()){
                            startButton.setDisable(false);
                            startButton.setText("Restart !");
                            startLabel.setText(playerOne.getName()+" is a winner !");

                            playerTwoTurn=false;
                            playerTwoLabel.setText("");
                            playerTwoButton.setDisable(true);

                            playerOneButton.setDisable(true);
                            playerOneLabel.setText("");
                            playerOneTurn=false;
                        }else{
                            playerTwoTurn=true;
                            playerTwoLabel.setText("your turn "+playerTwo.getName());
                            playerTwoButton.setDisable(false);

                            playerOneButton.setDisable(true);
                            playerOneLabel.setText("");
                            playerOneTurn=false;
                        }
                    }
                }

            }
        });
        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(playerTwoTurn){
                        int diceVal=dice.getRolledDiceValue();
                        startLabel.setText("dice value :"+ diceVal);
                        playerTwo.movePlayer(diceVal);
                        //winning condition;
                        if(playerTwo.isWinner()){
                            startButton.setDisable(false);
                            startButton.setText("restart !");
                            startLabel.setText(playerTwo.getName()+" is a winner !");

                            playerTwoTurn=false;
                            playerTwoLabel.setText("");
                            playerTwoButton.setDisable(true);

                            playerOneButton.setDisable(true);
                            playerOneLabel.setText("");
                            playerOneTurn=false;
                        }else{
                            playerTwoTurn=false;
                            playerTwoLabel.setText("");
                            playerTwoButton.setDisable(true);

                            playerOneButton.setDisable(false);
                            playerOneLabel.setText("your turn "+ playerOne.getName());
                            playerOneTurn=true;
                        }
                    }
                }

            }
        });
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStarted=true;
                startLabel.setText("game started");
                startButton.setDisable(true);
                playerOneTurn=true;
                playerOneButton.setDisable(false);
                playerOneLabel.setText("your Turn "+playerOne.getName());
                playerOne.startingPosition();

                playerTwoTurn=false;
                playerTwoLabel.setText("");
                playerTwoButton.setDisable(true);
                playerTwo.startingPosition();
            }
        });

        root.getChildren().addAll(board,playerOneButton,playerTwoButton,startButton,
                playerOneLabel,playerTwoLabel,startLabel,
                playerOne.getCoin(),playerTwo.getCoin()
        );

        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(createContent());
        stage.setTitle("snake ans ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}