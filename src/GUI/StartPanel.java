package GUI;

import Game.Board;
import Game.GameSolver;
import Game.Save;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StartPanel extends GameComponent implements ActionListener {
    private JButton easyButton;
    private JButton mediumButton;
    private JButton hardButton;
    private GamePanel gamePanel;

    public void setGamePanel(GameComponent gamePanel) {
        this.gamePanel = (GamePanel) gamePanel;
    }

    @Override
    public void create(Object...args){
        this.setBounds(50, 50 , 800, 700);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 200));
        this.addButtons();
        this.setVisible(true);
    }

    public void addButtons(){
        easyButton = new JButton("Easy");
        mediumButton = new JButton("Medium");
        hardButton = new JButton("Hard");

        easyButton.setPreferredSize(new Dimension(200,200));
        mediumButton.setPreferredSize(new Dimension(200,200));
        hardButton.setPreferredSize(new Dimension(200,200));

        easyButton.addActionListener(this);
        mediumButton.addActionListener(this);
        hardButton.addActionListener(this);

        easyButton.setVisible(true);
        mediumButton.setVisible(true);
        hardButton.setVisible(true);

        this.add(easyButton);
        this.add(mediumButton);
        this.add(hardButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==easyButton){
            try {
                int[][] savedBoard = Save.readObj();
                if (savedBoard != null) {
                    Board.board = savedBoard;
                    int[][] temp = new int[ Board.board.length][ Board.board.length];
                    Board.copyBoard(savedBoard, temp);
                    System.out.println("Board loaded");
                    GameSolver.solve(temp, 1, 1, Board.board.length);
                    Board.solvedBoard = new int[Board.board.length][Board.board.length];
                    Board.copyBoard(temp, Board.solvedBoard);
//                    Board.resetForUser(Board.board, Board.board.length);
                } else {
                    Board.generateBoard(3, false);
                }
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("No saved board " + ex.getMessage());
                Board.generateBoard(3, false);
            }
            gamePanel.create(this);
            gamePanel.showBoard(Board.board, 3);
            GamePanel.choosenSize = 3;
            this.setVisible(false);
        }
        else if(e.getSource()==mediumButton){
            try {
                int[][] savedBoard = Save.readObj4();
                if (savedBoard != null) {
                    Board.board = savedBoard;
                    int[][] temp = new int[ Board.board.length][ Board.board.length];
                    Board.copyBoard(savedBoard, temp);
                    System.out.println("Board loaded");
                    GameSolver.solve(temp, 1, 1, Board.board.length);
                    Board.solvedBoard = new int[Board.board.length][Board.board.length];
                    Board.copyBoard(temp, Board.solvedBoard);
//                    Board.resetForUser(Board.board, Board.board.length);
                } else {
                    Board.generateBoard(4, false);
                }
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("No saved board " + ex.getMessage());
                Board.generateBoard(4, false);
            }            gamePanel.create(this);
            gamePanel.showBoard(Board.board, 4);
            GamePanel.choosenSize = 4;
            this.setVisible(false);
        }
        else if(e.getSource()==hardButton){
            try {
                int[][] savedBoard = Save.readObj5();
                if (savedBoard != null) {
                    Board.board = savedBoard;
                    int[][] temp = new int[ Board.board.length][ Board.board.length];
                    Board.copyBoard(savedBoard, temp);
                    System.out.println("Board loaded");
                    GameSolver.solve(temp, 1, 1, Board.board.length);
                    Board.solvedBoard = new int[Board.board.length][Board.board.length];
                    Board.copyBoard(temp, Board.solvedBoard);
//                    Board.resetForUser(Board.board, Board.board.length);
                } else {
                    Board.generateBoard(4, true);
                }
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("No saved board " + ex.getMessage());
                Board.generateBoard(4, true);
            }
            gamePanel.create(this);
            gamePanel.showBoard(Board.board, 4);
            GamePanel.choosenSize = 4;
            GamePanel.ifHardChoosen = true;
            this.setVisible(false);
        }
    }
}
