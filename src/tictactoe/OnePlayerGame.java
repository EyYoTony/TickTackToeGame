package tictactoe;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class OnePlayerGame {



    @FXML
    private GridPane gameGrid;

    @FXML
    private AnchorPane root;

    @FXML
    private void initialize(){
        //set button size (assuming gameGrid is a square)
        double screenHeght = root.getPrefHeight();
        gameGrid.setPrefHeight(screenHeght/3);
        gameGrid.setPrefWidth(screenHeght/3);
    }


}