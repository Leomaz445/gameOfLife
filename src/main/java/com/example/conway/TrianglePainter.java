package com.example.conway;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static com.example.conway.constants.GameGrid.COLUMNS;
import static com.example.conway.constants.GameGrid.ROWS;

/**
 * Here we have our painting and drawing function of the game.
 */
public class TrianglePainter {

    private final int RECTANGLE_SIZE = 30;

    /*
        Receiving the canvas and the game board and painting on the canvas.
        @param gc - the canvas of the game.
        @param mat - the grid of the game.
     */
    public void painter(GraphicsContext gc, int[][] mat) {
        int rectSize = RECTANGLE_SIZE;
        double x = 0;
        double y = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (mat[i][j] == 1) {
                    gc.setFill(Color.GREEN);
                    gc.fillRect(x, y, rectSize, rectSize);
                    gc.strokeRect(x, y, rectSize, rectSize);
                } else {
                    gc.setFill(Color.WHITE);
                    gc.fillRect(x, y, rectSize, rectSize);
                    gc.strokeRect(x, y, rectSize, rectSize);
                }
                x += rectSize;
            }
            y += rectSize;
            x = 0;
        }
    }
}


