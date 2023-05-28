import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BoardGenerator extends JPanel implements ActionListener {
    int[][] board;
    JButton[][] gridB;
    int temp;
    int sumC;
    int sumR;

    BoardGenerator(int size){
        this.setLayout(new GridLayout(size, size));
        this.setVisible(true);
        createGrid(size);
    }

    public void generateBoard(int size){

        do{
            board = new int[size][size];
            sumC = 0;
            sumR = 0;

            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    if(i==0){
                        if(j==0){
                            board[i][j] = 0;
                        }
                        else if (size <= 3) {
                            board[i][j] = new Random().nextInt(12) + 3;
                        } else board[i][j] = new Random().nextInt(20) + 3;
                    }
                    else if(j==0){
                        if(size>3){
                            board[i][j] = new Random().nextInt(20)+3;
                        }
                        else{
                            board[i][j] = new Random().nextInt(12)+3;
                        }
                    }
                    else{
                        board[i][j] = 0;
                    }
                }
            }

            for(int i=0; i<size; i++){
                sumR += board[0][i];
                sumC += board[i][0];
            }
        }while(sumC != sumR);


        for(int[] x: board){
            for(int y:x){
                System.out.print(y + " ");
            }
            System.out.println(); // pomocnicza petla, finalnie do usuniecia
        }
    }

    public void createGrid(int size){

        generateBoard(size);

        gridB = new JButton[size][size];

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++) {
                gridB[i][j] = new JButton();
                if(board[i][j] != 0){
                    temp = board[i][j];
                    gridB[i][j].setText(String.valueOf(temp));
                    gridB[i][j].setFont(new Font("MV Boli", Font.PLAIN, 45));
                    gridB[i][j].setEnabled(false);
                }
                else if(i==0 && j==0){
                    gridB[i][j].setEnabled(false);
                }
                else{
                    gridB[i][j].addActionListener(this);
                }

                this.add(gridB[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        for(int i=0; i<gridB.length; i++){
            for(int j=0; j<gridB[i].length; j++) {
                if(clicked == gridB[i][j]){
                    System.out.print(i);
                    System.out.println(j); // tu dalsza implementacja tzn. wyświetlenie siatki wyboru, przypisanie do memory
                }
            }
        }

    }
}