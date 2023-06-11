package Game;

import java.util.Arrays;
import java.util.Random;

public class Board {
    public static int[][] board;
    public static int[][] solvedBoard;
    /////////////////////////////////////////////////////
    private static boolean hintUsed = false;

    public static void setHintUsed(boolean used) {
        hintUsed = used;
    }
    ///////////////////////////////////////////////////////

    public static void generateBoard(int size, boolean hardLevel) {
        board = new int[size][size];
        solvedBoard = new int[size][size];
        int sumR;
        int sumC;

        do {
            resetBoard(board);
            sumC = 0;
            sumR = 0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i == 0) {
                        if (j == 0) {
                            board[i][j] = 0;
                        } else if (size <= 4 && !hardLevel) {
                            board[i][j] = new Random().nextInt(12) + 3;
                        } else if (hardLevel){
                            board[i][j] = new Random().nextInt(18) + 7;
                        }
                    } else if (j == 0) {
                        if (hardLevel) {
                            board[i][j] = new Random().nextInt(18) + 7;
                        } else if(size <=4){
                            board[i][j] = new Random().nextInt(12) + 3;
                        }
                    } else {
                        board[i][j] = 0;
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                sumR += board[0][i];
                sumC += board[i][0];
            }

            if (sumC == sumR) {
                if (GameSolver.solve(board, 1, 1, size)) {
                    copyBoard(board, solvedBoard);
                    resetForUser(board, size);
                    break;
                }
            }
        } while(true);
    }
    public static boolean isBoardSolved() {
        ///////////////////////////////////////////////////////
        if (solvedBoard == null) {
            return false;
        }

        if(!hintUsed){
            /////////////////////////////////////////////////////
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] != solvedBoard[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void resetBoard(int[][] board) {
        for (int[] ints : board) {
            Arrays.fill(ints, 0);
        }
    }

    public static void copyBoard(int[][] source, int[][] destination) {
        for (int i = 0; i < source.length; i++) {
            System.arraycopy(source[i], 0, destination[i], 0, source[i].length);
        }
    }

    public static void resetForUser(int[][] board, int size){
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                board[i][j] =0;
            }
        }
    }
}
