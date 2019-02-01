package com.arun.practise.arrays;


import org.junit.Test;

import java.util.Arrays;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life,
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
 * using the following four rules (taken from the above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * The next state is created by applying the above rules simultaneously to every cell in the current state,
 * where births and deaths occur simultaneously.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [0,1,0],
 * [0,0,1],
 * [1,1,1],
 * [0,0,0]
 * ]
 * Output:
 * [
 * [0,0,0],
 * [1,0,1],
 * [0,1,1],
 * [0,1,0]
 * ]
 * Follow up:
 * <p>
 * Could you solve it in-place? Remember that the board needs to be updated at the same time:
 * You cannot update some cells first and then use their updated values to update other cells.
 * <p>
 * In this question, we represent the board using a 2D array. In principle, the board is infinite,
 * which would cause problems when the active area encroaches the border of the array.
 * How would you address these problems?
 */
public class GameOfLife {

    public static final int[][] adjacent = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    public static final int ALIVE = 2;
    public static final int DEAD = 3;


    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0)
            return;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int neighbourCount = getNeighbourCount(board, i, j);
                if (board[i][j] == 0 && neighbourCount == 3) {
                    board[i][j] = ALIVE;
                } else {
                    if (neighbourCount < 2) {
                        board[i][j] = DEAD;
                    } else if (neighbourCount > 3) {
                        board[i][j] = DEAD;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == DEAD)
                    board[i][j] = 0;
                else if (board[i][j] == ALIVE) {
                    board[i][j] = 1;
                }
            }
        }


    }

    private int getNeighbourCount(int[][] board, int i, int j) {
        int count = 0;
        for (int k = 0; k < adjacent.length; k++) {
            int row = i + adjacent[k][0];
            int column = j + adjacent[k][1];

            if (row < 0 || row >= board.length || column < 0 || column >= board[0].length)
                continue;

            if (board[row][column] == 1 || board[row][column] == DEAD)
                count++;

        }
        return count;
    }

    @Test
    public void test_gameOfLife() {
        GameOfLife solution = new GameOfLife();
        int[][] input = new int[4][3];
        input[0] = new int[]{0, 1, 0};
        input[1] = new int[]{0, 0, 1};
        input[2] = new int[]{1, 1, 1};
        input[3] = new int[]{0, 0, 0};

        solution.gameOfLife(input);

        for (int i = 0; i < input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }
    }

}
