package com.example.conway;

import java.util.Random;

import static com.example.conway.constants.GameGrid.COLUMNS;
import static com.example.conway.constants.GameGrid.ROWS;

/**
 * The main function of the game that controlling the logic of the game.
 * here we generate the first grid of the game, and the next generations.
 */
public class ConWayLogic {

    private int[][] grid = new int[ROWS][COLUMNS];

    //get Grid - return the grid.
    public int[][] getGrid() {
        return grid;
    }
    //generate the Starting grid
    public void generateRandomStartGrid() {
        Random randomGenerator = new Random();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                this.grid[i][j] = randomGenerator.nextInt(2);
            }
        }
    }

    //Generating the next generation by applying conway rules.
    public void nextGenerationCalculation() {
        int aliveNeighborsCounter;
        int[][] nextGenerationGrid = new int[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                aliveNeighborsCounter = 0;

                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        if ((i + k >= 0 && i + k < ROWS) && (j + l >= 0 && j + l < COLUMNS))
                            aliveNeighborsCounter += grid[i + k][j + l];
                    }
                }
                aliveNeighborsCounter -= grid[i][j];
                if ((grid[i][j] == 1) && (aliveNeighborsCounter < 2))
                    nextGenerationGrid[i][j] = 0;
                else if ((grid[i][j] == 1) && (aliveNeighborsCounter > 3))
                    nextGenerationGrid[i][j] = 0;
                else if ((grid[i][j] == 0) && (aliveNeighborsCounter == 3))
                    nextGenerationGrid[i][j] = 1;
                else
                    nextGenerationGrid[i][j] = grid[i][j];
            }
        }
        this.grid = nextGenerationGrid;
    }
}
