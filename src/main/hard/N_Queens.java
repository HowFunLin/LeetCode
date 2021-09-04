package main.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens {
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        String[][] checkerboard = new String[n][n];

        for (int i = 0; i < n; i++)
            Arrays.fill(checkerboard[i], ".");

        backtrack(checkerboard, 0);
        return res;
    }

    private void backtrack(String[][] checkerboard, int row) {
        int n = checkerboard.length;

        if (row == n) {
            List<String> solution = new ArrayList<>();

            for (String[] aCheckerboard : checkerboard) {
                StringBuilder builder = new StringBuilder();

                for (int j = 0; j < n; j++) {
                    builder.append(aCheckerboard[j]);
                }

                solution.add(builder.toString());
            }

            res.add(solution);
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(checkerboard, col, row))
                continue;
            checkerboard[row][col] = "Q";
            backtrack(checkerboard, row + 1);
            checkerboard[row][col] = ".";
        }
    }

    private boolean isValid(String[][] checkerboard, int col, int row) {
        for (int i = 0; i <= row; i++)
            if (checkerboard[i][col].equals("Q"))
                return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (checkerboard[i][j].equals("Q"))
                return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < checkerboard.length; i--, j++)
            if (checkerboard[i][j].equals("Q"))
                return false;

        return true;
    }
}
