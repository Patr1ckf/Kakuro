import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

    BoardGenerator board;
    JButton backButton;



    GamePanel(int choice) {
        this.setLayout(null);

        backButton = new JButton("wroc do menu");
        backButton.setBounds(30, 0, 170, 80);
        this.add(backButton);
        backButton.addActionListener( this);

        board = new BoardGenerator(choice); // param to wielkosc planszy, docelowo bedzie to przekazywane ze startpanel
        board.setBounds(30, 90, 500, 600);
        this.add(board);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){
            System.out.println("powrociles do menu");
            new FrameMain();
         /* do naprawy
            startPanel = new StartPanel((FrameMain) FrameMain);
            startPanel.remove(this);
            startPanel.setBounds(50, 50 , 800, 700);

            this.setSize(new Dimension(900, 800));
            this.revalidate();
            this.repaint();

            this.add(startPanel);
            startPanel.setVisible(true);

        */
            }
        }
}

