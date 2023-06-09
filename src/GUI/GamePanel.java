package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends GameComponent implements ActionListener {
    private StartPanel startPanel;
    private JButton backButton;
    private final JPanel gridPanel = new JPanel();

    GamePanel(){
        addBackButton();
        this.setLayout(null);
        this.setVisible(false);
        this.setBounds(50, 40, 800, 700);
    }
    public void create(Object...args){
        this.startPanel = (StartPanel) args[0];
        this.setVisible(true);
        this.add(gridPanel);
    }

    public void showBoard(int[][] board, int size){
        JButton[][] gridB = new JButton[size][size];
        gridPanel.setLayout(new GridLayout(size, size));
        gridPanel.setBounds(30, 90, 500, 600);
        int temp;

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
                gridPanel.add(gridB[i][j]);
            }
        }
    }

    public void clearBoard() {
        gridPanel.removeAll();
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    public void addBackButton(){
        backButton = new JButton("wróc do menu");
        backButton.setBounds(50, 0, 170, 80);
        backButton.addActionListener(this);
        backButton.setVisible(true);
        this.add(backButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            this.setVisible(false);
            clearBoard();
            startPanel.setVisible(true);
        }
    }
}
