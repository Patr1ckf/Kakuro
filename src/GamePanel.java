import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

    BoardGenerator board;
    JButton backButton;
    private StartPanel startPanel;
    private final FrameMain frameMain;

    GamePanel(int choice, FrameMain frameMain, StartPanel startPanel) {
        this.setLayout(null);

        this.frameMain = frameMain;
        this.startPanel = startPanel;

        backButton = new JButton("wróc do menu");
        backButton.setBounds(30, 0, 170, 80);
        backButton.addActionListener(this);
        this.add(backButton);

        board = new BoardGenerator(choice); // param to wielkosc planszy, docelowo bedzie to przekazywane ze startpanel
        board.setBounds(30, 90, 500, 600);
        this.add(board);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){
            frameMain.remove(this);
            startPanel = new StartPanel(frameMain);
            startPanel.setBounds(50, 50 , 800, 700);
            frameMain.add(startPanel);
            frameMain.revalidate();
            frameMain.repaint();
            }
        }
}

