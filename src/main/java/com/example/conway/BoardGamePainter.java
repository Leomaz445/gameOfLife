package com.example.conway;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static com.example.conway.constants.GameConstants.*;

/**
 * Here we have our drawing function of the game.
 */
public class BoardGamePainter {

    /*
        Receiving the canvas and the game board and painting on the canvas.
        @param gc - the canvas of the game.
        @param mat - the grid of the game.
     */
    public void paintGrid(GraphicsContext gc, int[][] mat) {
        int rectSize = RECTANGLE_SIZE;
        double x = 0;
        double y = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (mat[i][j] == ALIVE) {
                    gc.setFill(Color.GREEN);
                } else {
                    gc.setFill(Color.WHITE);
                }
                gc.fillRect(x, y, rectSize, rectSize);
                gc.strokeRect(x, y, rectSize, rectSize);
                x += rectSize;
            }
            y += rectSize;
            x = 0;
        }
    }
}


