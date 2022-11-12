package com.example.conway;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static com.example.conway.constants.GameConstants.*;

/**
 * This class is responsible for drawing.
 * this class is drawing the board of the game, if the cell is alive the color is green if dead the color is white.
 */
public class BoardGamePainter {

    /**
     * Receiving the canvas and the game board and painting on the canvas.
     *
     * @param gc  - the canvas of the game.
     * @param mat - the grid of the game with information which cell alive and which is dead.
     */
    public void paintGrid(GraphicsContext gc, int[][] mat) {
        int rectSize = RECTANGLE_SIZE;
        double x = 0;
        double y = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                gc.setStroke(Color.BLACK);
                gc.strokeRect(x, y, rectSize, rectSize);
                if (mat[i][j] == ALIVE) {
                    gc.setFill(Color.GREEN);
                    gc.fillRect(x, y, rectSize, rectSize);
                }
                x += rectSize;
            }
            y += rectSize;
            x = 0;
        }
    }
}


