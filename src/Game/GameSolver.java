package Game;

import java.util.HashSet;
import java.util.Set;

public class GameSolver {

    public static boolean isValid(int[][] board, int column, int row, int value){

        int sumRow = 0;
        for (int c = column; c > 0; c--) {
            sumRow += board[row][c];
        }

        int sumColumn = 0;
        for (int r = row; r > 0; r--) {
            sumColumn += board[r][column];
        }

        if (sumRow + value > board[row][0] || sumColumn + value > board[0][column]) {
            return false;
        }

        for (int r = 0; r < row; r++) {
            if (board[r][column] == value) {
                return false;
            }
        }
        for (int c = 0; c < column; c++) {
            if (board[row][c] == value) {
                return false;
            }
        }
        return true;
    }

    public static boolean isCorrect(int[][] board, int size){
        for(int i=1; i < size; ++i){
            int sum = 0;
            Set<Integer> valuesSet = new HashSet<>();
            for (int j = 1; j < size; ++j) {
                int value = board[i][j];
                if (value != 0) {
                    if (valuesSet.contains(value)) {
                        return false;
                    }
                    valuesSet.add(value);
                }
                sum += value;
            }
            if(board[i][0] != sum){
                return false;
            }
        }

        for(int j=1; j < size; ++j){
            int sum = 0;
            Set<Integer> valuesSet = new HashSet<>();
            for (int i = 1; i < size; ++i) {
                int value = board[i][j];
                if(value != 0){
                    if(valuesSet.contains(value)){
                        return false;
                    }
                    valuesSet.add(value);
                }
                sum += value;
            }
            if(board[0][j] != sum){
                return false;
            }
        }
        return true;
    }

    public static boolean solve(int[][] board, int column, int row, int size){

        if(row == size){
//            printBoard(board);
            return true;
        }
        else if(column == size){
            return solve(board, 1, row + 1, size);
        }
        else if(board[row][column] != 0){
            return solve(board, column + 1, row, size);
        }
        else{
            for(int k=1; k<10; k++){
                if(isValid(board, column, row, k)){
                    board[row][column] = k;
                    if(solve(board, column + 1, row, size)){
                        if(isCorrect(board, size)){
                            return true;
                        }
                    }
                    board[row][column] = 0;
                }
            }
            return false;
        }
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println("=============");
    }
}

