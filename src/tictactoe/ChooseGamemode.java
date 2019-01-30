package tictactoe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ChooseGamemode {

    @FXML
    private AnchorPane root;

    //Change scenes with button press and using controller class
    /*
    Used this video for reference on how to change scenes without creating whole new windows:
    https://www.youtube.com/watch?v=RJOza3XQk34
    "JavaFX : Loading New FXML in the Same Scene / WIndow" By Genuine Coder
    */

    @FXML
    private void loadTwoPlayerGameScene() throws IOException {
        AnchorPane twoPlayerGameScene = FXMLLoader.load(getClass().getResource("twoPlayerGame.fxml"));
        root.getChildren().setAll(twoPlayerGameScene);
    }

    @FXML
    private void loadOnePlayerGameScene(){
        /* Used one player to test some ideas, and I thought two player would be easier to implement */
        System.out.println("OnePlayerGame is currently under construction");
        //AnchorPane onePlayerGameScene = FXMLLoader.load(getClass().getResource("onePlayerGame.fxml"));
        //root.getChildren().setAll(onePlayerGameScene);
    }
}