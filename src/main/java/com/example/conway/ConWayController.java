package com.example.conway;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * The Main controller,form here we're painting the generating new generations.
 */
public class ConWayController {

    @FXML
    private Canvas canv;

    private GraphicsContext gc;
    private ConWayLogic conWayLogic;
    private BoardGamePainter boardGamePainter;

    //Create the object of the game logic and the painter of the game,create the first screen.
    public void initialize() {
        this.gc = canv.getGraphicsContext2D();
        this.conWayLogic = new ConWayLogic();
        this.boardGamePainter = new BoardGamePainter();
        conWayLogic.generateRandomStartGrid();
        boardGamePainter.paintGrid(gc, conWayLogic.getGrid());
    }

    //on the click of the mouse we draw next generation.
    @FXML
    public void onGenerateButtonClick() {
        drawNextGeneration();

    }

    //Drawing the new generation,before we draw the generation the paint the screen to erase the prev gen.
    public void drawNextGeneration() {
        gc.fillRect(0, 0, canv.getWidth(), canv.getHeight());
        conWayLogic.calculateNextGeneration();
        boardGamePainter.paintGrid(gc, conWayLogic.getGrid());
    }


}
