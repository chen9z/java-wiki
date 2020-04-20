package alg.thk;

/**
 * N皇后问题
 * Created by chen on 2020/3/30.
 */
public class NQueenProblem {
    final int N = 4;

    void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean isSafe(int[][] board, int row, int col) {
        int i, j;
        for (i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        for (i = row, j = col; i >= 0 && j < 8; i--, j++) {
            if (board[i][j] == 1) return false;
        }
        return true;
    }

    boolean solveNQUtil(int[][] board, int row) {
        if (row >= N) return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 1;
            }
            if (solveNQUtil(board, row + 1)) {
                return true;
            }
            board[row][i] = 0;
        }
        return true;
    }

   public boolean solveNQ()
    {
        int board[][] = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };

        if (solveNQUtil(board, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }
}
