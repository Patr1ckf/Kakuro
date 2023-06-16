package Game;

import java.util.Arrays;
import java.util.Random;

//import org.apache.commons.math4.*;
import org.apache.commons.math4.legacy.linear.MatrixUtils;
import org.apache.commons.math4.legacy.linear.RealMatrix;
import org.apache.commons.math4.legacy.linear.SingularValueDecomposition;


public class Board {
    public static int[][] board;
    public static int[][] solvedBoard;
    private static double[][] matrixValues;

    public static void generateBoard(int size, boolean hardLevel) {
        board = new int[size][size];
        solvedBoard = new int[size][size];
        int sumR;
        int sumC;
        int a;
        int b;


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
                            if(j==1){
                                board[i][j] = new Random().nextInt(12) + 3;
                            }
                            else{
                                a = board[i][j-1];
                                board[i][j] = new Random().nextInt(a)+1;
                            }
                        } else if (hardLevel){
                            if(j==1){
                                board[i][j] = new Random().nextInt(22) + 12;
                            }
                            else{
                                b = board[i][j-1];
                                board[i][j] = new Random().nextInt(b)+1;
                            }
                        }
                    } else if (j == 0) {
                        if (hardLevel) {
                            if(i==1){
                                board[i][j] = new Random().nextInt(22) + 12;
                            }
                            else{
                                b = board[i-1][j];
                                board[i][j] = new Random().nextInt(b)+1;
                            }
                        } else if(size <=4){
                            if(i==1){
                                board[i][j] = new Random().nextInt(12) + 3;
                            }
                            else{
                                a = board[i-1][j];
                                board[i][j] = new Random().nextInt(a)+1;
                            }
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
                if (GameSolver.solve(board, 1, 1, size) && multipleSolutions(size)) {
                    copyBoard(board, solvedBoard);
                    resetForUser(board, size);
//                    multipleSolutions(size);
                    break;
                }
            }
        } while(true);
    }
    public static boolean isBoardSolved() {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] != solvedBoard[i][j]) {
                        return false;
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


    public static boolean multipleSolutions(int size){
        RealMatrix expandedMatrix = null;
        int numRows;
        int numCols;
        int rankA = 0;
        double[][] integerMatrixSize3 = new double[][]{
                {1.0, 0.0, 1.0, 0.0},
                {0.0, 1.0, 0.0, 1.0},
                {1.0, 1.0, 0.0, 0.0},
                {0.0, 0.0, 1.0, 1.0}
        };

        double[][] integerMatrixSize4 = new double[][]{
                {1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0},
                {0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0},
                {0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0},
                {1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
                {0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0},
                {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0}
        };

        if(size == 3){
            matrixValues = new double[size+1][1];
        }
        else if(size == 4){
            matrixValues = new double[size+2][1];
        }

        for(int i=1; i<size; i++){
            matrixValues[i-1][0] = board[0][i];
        }
        for(int i=1; i<size; i++){
            if(size == 3){
                matrixValues[i - 3 + matrixValues.length][0] = board[i][0];
            }
            else{
                matrixValues[i - 4 + matrixValues.length][0] = board[i][0];
            }
        }

        if(size == 3){
            numRows = integerMatrixSize3.length;
            numCols = integerMatrixSize3[0].length;

            expandedMatrix = MatrixUtils.createRealMatrix(numRows, numCols + 1);

            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    expandedMatrix.setEntry(i, j, integerMatrixSize3[i][j]);
                }
                expandedMatrix.setEntry(i, numCols, matrixValues[i][0]);
            }

            org.apache.commons.math4.legacy.linear.RealMatrix matrixSize3 = MatrixUtils.createRealMatrix(integerMatrixSize3);
            SingularValueDecomposition matrixSize3Svd = new SingularValueDecomposition(matrixSize3);
            rankA = matrixSize3Svd.getRank();
//            System.out.println("Rank A: " + rankA);
        }
        else if(size == 4){
            numRows = integerMatrixSize4.length;
            numCols = integerMatrixSize4[0].length;

            expandedMatrix = MatrixUtils.createRealMatrix(numRows, numCols + 1);

            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    expandedMatrix.setEntry(i, j, integerMatrixSize4[i][j]);
                }
                expandedMatrix.setEntry(i, numCols, matrixValues[i][0]);
            }

            org.apache.commons.math4.legacy.linear.RealMatrix matrixSize4 = MatrixUtils.createRealMatrix(integerMatrixSize4);
            SingularValueDecomposition matrixSize4Svd = new SingularValueDecomposition(matrixSize4);
            rankA = matrixSize4Svd.getRank();
//            System.out.println("rank A: " + rankA);
        }


        assert expandedMatrix != null;
        SingularValueDecomposition expandedMatrixSvd = new SingularValueDecomposition(expandedMatrix);
        int rankAB = expandedMatrixSvd.getRank();
//        System.out.println("rank A/B: " + rankAB);


/*
        numRows = expandedMatrix.getRowDimension();
        numCols = expandedMatrix.getColumnDimension();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(expandedMatrix.getEntry(i, j) + " ");
            }
            System.out.println();
        }
*/

        return rankA == rankAB;


    }
}
