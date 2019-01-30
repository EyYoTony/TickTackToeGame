package tictactoe;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.Random;


public class TwoPlayerGame {

    private char[][] gameBoard = new char[3][3];
    private boolean playerOneTurn;
    //loss is p2 win
    private int winCounter = 0;
    private int tieCounter = 0;
    private int lossCounter = 0;

    @FXML
    private GridPane gameGrid;

    @FXML
    private AnchorPane root;

    @FXML
    private Button button00;
    @FXML
    private Button button01;
    @FXML
    private Button button02;
    @FXML
    private Button button10;
    @FXML
    private Button button11;
    @FXML
    private Button button12;
    @FXML
    private Button button20;
    @FXML
    private Button button21;
    @FXML
    private Button button22;

    @FXML
    private Label playerTwoIndicator;
    @FXML
    private Label playerOneIndicator;
    @FXML
    private Label winScoreLabel;
    @FXML
    private Label tieScoreLabel;
    @FXML
    private Label lossScoreLabel;

    @FXML
    private void initialize(){
        //initial coinflip per specification to see who goes first (0 = p1, 1 = p2)
        int coinFlip = (int)(Math.random()*2);
        if(coinFlip == 0) {
            playerOneTurn = true;
        }
        else {
            playerOneTurn = false;
        }
        //make sure indicators are correct by updating them
        changeTurns();

    }

    @FXML
    private void buttonLogic(ActionEvent e){
        //System.out.println(((Control)e.getSource()).getId());
        String buttonName = ((Control)e.getSource()).getId();
        int col = Integer.parseInt(buttonName.substring(buttonName.length()-1));
        int row = Integer.parseInt(buttonName.substring(buttonName.length()-2, buttonName.length()-1));
        if(playerOneTurn && gameBoard[row][col] == 0) {
            gameBoard[row][col] = 'X';
            changeTurns();
        }
        else if(!playerOneTurn && gameBoard[row][col] == 0){
            gameBoard[row][col] = 'O';
            changeTurns();
        }
        else{
            System.out.println("Invalid Move");
        }
        updateGridDisplay();
        checkForWinLoss();
    }

    @FXML
    private void checkForWinLoss(){
        char winner = ' ';
        //check horizontal
        for(int i=0; i<3; i++){
            if(gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2]){
                winner = gameBoard[i][0];
            }
        }
        //check vertical
        for(int i=0; i<3; i++){
            if(gameBoard[0][i] == gameBoard[1][i] && gameBoard[1][i] == gameBoard[2][i]){
                winner = gameBoard[0][i];
            }
        }
        //check two diagonal
        if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]){
            winner = gameBoard[0][0];
        }
        if(gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0]){
            winner = gameBoard[0][2];
        }

        if(winner == 'X'){
            winCounter++;
            winScoreLabel.setText(Integer.toString(winCounter));
            changeTurns();
            resetBoard();
        }
        else if(winner == 'O'){
            lossCounter++;
            lossScoreLabel.setText(Integer.toString(lossCounter));
            changeTurns();
            resetBoard();
        }

        //check for tie
        if(isBoardFull()){
            tieCounter++;
            tieScoreLabel.setText(Integer.toString(tieCounter));
            resetBoard();
        }

    }

    @FXML
    private void changeTurns(){
        playerOneTurn = !playerOneTurn;
        if(playerOneTurn){
            playerOneIndicator.setText("Your Move");
            playerTwoIndicator.setText("");
        }else{
            playerOneIndicator.setText("");
            playerTwoIndicator.setText("Your Move");
        }
    }

    @FXML
    private void updateGridDisplay(){
        button00.setText(String.valueOf(gameBoard[0][0]));
        button01.setText(String.valueOf(gameBoard[0][1]));
        button02.setText(String.valueOf(gameBoard[0][2]));
        button10.setText(String.valueOf(gameBoard[1][0]));
        button11.setText(String.valueOf(gameBoard[1][1]));
        button12.setText(String.valueOf(gameBoard[1][2]));
        button20.setText(String.valueOf(gameBoard[2][0]));
        button21.setText(String.valueOf(gameBoard[2][1]));
        button22.setText(String.valueOf(gameBoard[2][2]));
    }

    @FXML
    private void resetBoard(){
        gameBoard = new char[3][3];
        updateGridDisplay();
    }

    @FXML
    private boolean isBoardFull(){
        for(int i = 0; i < 3; i++){
            for(int k = 0; k < 3; k++){
                if(gameBoard[i][k] == 0){
                    return false;
                }
            }
        }
        return true;
    }

}
