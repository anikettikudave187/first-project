package com.example.firstprogram_snakeandladder;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javax.swing.*;

public class Tile extends Rectangle{
    public Tile(int tileSize){
        setWidth(tileSize);
        setHeight(tileSize);
        setFill(Color.AZURE);
        setStroke(Color.BLACK);
    }
}
