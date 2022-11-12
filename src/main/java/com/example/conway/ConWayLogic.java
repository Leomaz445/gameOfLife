package com.example.conway;

import java.util.Random;

import static com.example.conway.constants.GameConstants.*;

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

    //generate the Starting grid we generate between two options 0 - is dead 1 is alive.
    public void generateRandomStartGrid() {
        Random randomGenerator = new Random();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                this.grid[i][j] = randomGenerator.nextInt(2);
            }
        }
    }

    //Generating the next generation by applying conway rules.
    public void calculateNextGeneration() {
        int[][] nextGeneration = new int[ROWS][COLUMNS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {

                int aliveNeighboursCounter = 0;
                for (int k = -1; k <= 1; k++)
                    for (int l = -1; l <= 1; l++)
                        if ((i + k >= 0 && i + k < ROWS) && (j + l >= 0 && j + l < COLUMNS))
                            aliveNeighboursCounter += grid[i + k][j + l];

                //deleting the cell itself because we counted in the loop before when we counted the alive cells.
                aliveNeighboursCounter -= grid[i][j];

                if ((grid[i][j] == ALIVE) && (aliveNeighboursCounter < TWO_NEIGHBOURS))
                    nextGeneration[i][j] = DEAD;
                else if ((grid[i][j] == ALIVE) && (aliveNeighboursCounter > THREE_NEIGHBOURS))
                    nextGeneration[i][j] = DEAD;
                else if ((grid[i][j] == DEAD) && (aliveNeighboursCounter == THREE_NEIGHBOURS))
                    nextGeneration[i][j] = ALIVE;
                else
                    nextGeneration[i][j] = grid[i][j];
            }
        }
        grid = nextGeneration;
    }
}
