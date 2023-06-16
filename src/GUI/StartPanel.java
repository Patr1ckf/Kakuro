package GUI;

import Game.Board;

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
        this.setBounds(50, 50 , 800, 700);
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
        easyButton = new JButton("POZIOM 1");
        mediumButton = new JButton("POZIOM 2");
        hardButton = new JButton("POZIOM 3");

        easyButton.setPreferredSize(new Dimension(200,200));
        mediumButton.setPreferredSize(new Dimension(200,200));
        hardButton.setPreferredSize(new Dimension(200,200));

        easyButton.setBackground(Color.orange);
        mediumButton.setBackground(Color.orange);
        hardButton.setBackground(Color.orange);

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
            Board.generateBoard(3, false);
            gamePanel.create(this);
            gamePanel.showBoard(Board.board, 3);
            GamePanel.choosenSize = 3;
            this.setVisible(false);
        }
        else if(e.getSource()==mediumButton){
            Board.generateBoard(4, false);
            gamePanel.create(this);
            gamePanel.showBoard(Board.board, 4);
            GamePanel.choosenSize = 4;
            this.setVisible(false);
        }
        else if(e.getSource()==hardButton){
            Board.generateBoard(4, true);
            gamePanel.create(this);
            gamePanel.showBoard(Board.board, 4);
            GamePanel.choosenSize = 4;
            GamePanel.ifHardChoosen = true;
            this.setVisible(false);
        }
    }
}
