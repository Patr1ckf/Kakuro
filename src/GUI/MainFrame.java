package GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    GamePanel gamePanel = new GamePanel();
    StartPanel startPanel = new StartPanel();

    public MainFrame(){
        this.setLayout(null);
        this.setSize(new Dimension(800, 700));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void showStartPanel(){
        startPanel.setGamePanel(gamePanel);
        startPanel.create();
        this.add(startPanel);
        this.revalidate();
        this.repaint();
    }

    public void showGamePanel(){
        this.add(gamePanel);
        this.revalidate();
        this.repaint();
    }
}
