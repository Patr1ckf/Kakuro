package Game;

import java.util.Random;

public class Board {
    public static int[][] board;

    public static void generateBoard(int size) {
        int sumR;
        int sumC;

        do {
            board = new int[size][size];
            sumC = 0;
            sumR = 0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i == 0) {
                        if (j == 0) {
                            board[i][j] = 0;
                        } else if (size <= 3) {
                            board[i][j] = new Random().nextInt(12) + 3;
                        } else board[i][j] = new Random().nextInt(20) + 3;
                    } else if (j == 0) {
                        if (size > 3) {
                            board[i][j] = new Random().nextInt(20) + 3;
                        } else {
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
        } while (sumC != sumR);
    }
}
