package Game;

import java.io.Serializable;

public class BoardData implements Serializable {
    public int[][] boardSave;

    public BoardData(int[][] board) {
        this.boardSave = board;
    }

    public int[][] getBoard() {
        return boardSave;
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
