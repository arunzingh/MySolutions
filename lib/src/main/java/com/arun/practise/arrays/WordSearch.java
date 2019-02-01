package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int[][] visited = new int[board.length][board[0].length];
        int k = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && existDfs(board, word, visited, k, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existDfs(char[][] board, String word, int[][] visited, int k, int i, int j) {

        // bounds check
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }

        if (board[i][j] != word.charAt(k) || visited[i][j] == 1) {
            return false;
        }

        if (k == word.length() - 1) {
            return true;
        }

        visited[i][j] = 1;

        boolean found = existDfs(board, word, visited, k + 1, i, j - 1)
                || existDfs(board, word, visited, k + 1, i, j + 1)
                || existDfs(board, word, visited, k + 1, i - 1, j)
                || existDfs(board, word, visited, k + 1, i + 1, j);

        visited[i][j] = 0;


        return found;
    }

    @Test
    public void test_exist() {
        WordSearch solution = new WordSearch();
        char[][] input = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        Assert.assertTrue(solution.exist(input, "ABCCED"));
        Assert.assertTrue(solution.exist(input, "SEE"));
        Assert.assertFalse(solution.exist(input, "ABCB"));
    }
}
