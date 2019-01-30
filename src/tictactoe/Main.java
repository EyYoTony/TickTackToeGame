package tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        //Set Application Title
        primaryStage.setTitle("Tic-Tac-Toe");

        //Initial Scene - menu
        Parent chooseGamemode = FXMLLoader.load(getClass().getResource("chooseGamemode.fxml"));

        primaryStage.setScene(new Scene(chooseGamemode, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}