package GUI;

import Game.Board;
import Game.GameSolver;
import Game.Save;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartPanel extends GameComponent implements ActionListener {
    private JButton easyButton;
    private JButton mediumButton;
    private JButton hardButton;
    private GamePanel gamePanel;
    private BufferedImage backgroundImage;

    public void setGamePanel(GameComponent gamePanel) {
        this.gamePanel = (GamePanel) gamePanel;
    }

    @Override
    public void create(Object...args){
        this.setBounds(0, 0 , 800, 700);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 200));
        this.addButtons();
        this.setVisible(true);

        try {
            backgroundImage = ImageIO.read(new File("rsc\\background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            Image scaledImage = backgroundImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            g.drawImage(scaledImage, 0, 0, null);
        }
    }
    public void addButtons(){
        easyButton = new JButton("Poziom 1");
        mediumButton = new JButton("Poziom 2");
        hardButton = new JButton("Poziom 3");

        easyButton.setPreferredSize(new Dimension(200,200));
        mediumButton.setPreferredSize(new Dimension(200,200));
        hardButton.setPreferredSize(new Dimension(200,200));

        easyButton.setBackground(Color.orange);
        mediumButton.setBackground(Color.orange);
        hardButton.setBackground(Color.orange);

        easyButton.setFont(new Font("Mv Boli", Font.BOLD, 27));
        mediumButton.setFont(new Font("Mv Boli", Font.BOLD, 27));
        hardButton.setFont(new Font("Mv Boli", Font.BOLD, 27));

        easyButton.addActionListener(this);
        mediumButton.addActionListener(this);
        hardButton.addActionListener(this);

        easyButton.setVisible(true);
        mediumButton.setVisible(true);
        hardButton.setVisible(true);

        easyButton.setFocusable(false);
        mediumButton.setFocusable(false);
        hardButton.setFocusable(false);

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
//                System.out.println("No saved board " + ex.getMessage());
                Board.generateBoard(3, false);
            }
            GamePanel.hardLevel = false;
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
//                System.out.println("No saved board " + ex.getMessage());
                Board.generateBoard(4, false);
            }            gamePanel.create(this);
            GamePanel.hardLevel = false;
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
//                    System.out.println("Board loaded");
                    GameSolver.solve(temp, 1, 1, Board.board.length);
                    Board.solvedBoard = new int[Board.board.length][Board.board.length];
                    Board.copyBoard(temp, Board.solvedBoard);
//                    Board.resetForUser(Board.board, Board.board.length);
                } else {
                    Board.generateBoard(4, true);
                }
            } catch (IOException | ClassNotFoundException ex) {
                Board.generateBoard(4, true);
            }
            GamePanel.hardLevel = true;
            gamePanel.create(this);
            gamePanel.showBoard(Board.board, 4);
            GamePanel.choosenSize = 4;
            GamePanel.ifHardChoosen = true;
            this.setVisible(false);
        }
    }
}
