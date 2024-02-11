public class SudokuSolver {

    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {
        //Sudoku Board
        int[][] board = {
                {0, 0, 0, 7, 0, 0, 5, 9, 4},
                {9, 0, 0, 8, 0, 6, 3, 0, 1},
                {2, 5, 0, 0, 4, 9, 0, 0, 0},
                {0, 6, 1, 0, 0, 7, 0, 0, 0},
                {7, 0, 0, 4, 0, 9, 0, 0, 5},
                {0, 0, 0, 3, 0, 0, 7, 1, 0},
                {0, 0, 0, 3, 8, 0, 0, 4, 6},
                {6, 0, 8, 1, 0, 7, 0, 0, 2},
                {5, 3, 4, 0, 0, 6, 0, 0, 0}
        };
    }

    //Check for number in row
    private static boolean isNInRow(int[][] board, int n, int row) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == n) {
                return true;
            }
        }
        return false;
    }

    //Check for number in column
    private static boolean isNInColumn(int[][] board, int n, int col) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][col] == n) {
                return true;
            }
        }
        return false;
    }

    //Check for number in box
    private static boolean isNInBox(int[][] board, int n, int row, int col) {
        int thisBoxRow = row - row % 3;
        int thisBoxCol = col - col % 3;

        for (int i = thisBoxRow; i < (thisBoxRow+3); i++) {
            for (int j = thisBoxCol; j < (thisBoxCol+3); j++) {
                if(board[i][j] == n) {
                    return true;
                }
            }
        }
        return false;
    }

    //Checks if valid placement based on if number already present in row, column or box
    private static boolean isValidPlacement(int[][] board, int n, int row, int col) {
        return !isNInRow(board, n, row) && !isNInColumn(board, n, col) && !isNInBox(board, n, row, col);
    }

    private static boolean solveBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE ; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int tryNum = 0; tryNum < GRID_SIZE; tryNum++) {
                        if (isValidPlacement(board, tryNum, row, col)) {
                            board[row][col] = tryNum;

                            if (solveBoard(board)) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
        }
    }
}
