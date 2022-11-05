package com.example.conway;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Game of life based on Conway Logic
 * Created By Leonid Mazarsky
 */
public class GameOfLifeApplication extends Application {
    //Loading the FXML file and generating the opening screen
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameOfLifeApplication.class.getResource("game-of-life-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 310, 340);
        stage.setTitle("Game Of Life");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}