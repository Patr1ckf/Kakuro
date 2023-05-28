import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel implements ActionListener {

    JButton easyButton;
    JButton mediumButton;
    JButton hardButton;
    private final FrameMain frameMain;

    StartPanel(FrameMain frameMain) {

        this.frameMain = frameMain;
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 200));

        easyButton = new JButton("Easy");
        mediumButton = new JButton("Medium");
        hardButton = new JButton("Hard");

        this.add(easyButton);
        this.add(mediumButton);
        this.add(hardButton);

        easyButton.addActionListener(this);
        mediumButton.addActionListener(this);
        hardButton.addActionListener(this);

        this.setPreferredSize(new Dimension(800,700));
        easyButton.setPreferredSize(new Dimension(200,200));
        mediumButton.setPreferredSize(new Dimension(200,200));
        hardButton.setPreferredSize(new Dimension(200,200));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == easyButton){
            System.out.println("you clicked easy");
            frameMain.game = new GamePanel(3, frameMain, this);
            frameMain.game.setBounds(50, 40, 800, 700);
            frameMain.remove(this);
            frameMain.add(frameMain.game);
            frameMain.revalidate();
            frameMain.repaint();
        }
        if(e.getSource() == mediumButton){
            System.out.println("you clicked medium");
            frameMain.game = new GamePanel(4, frameMain, this);
            frameMain.game.setBounds(50, 40, 800, 700);
            frameMain.remove(this);
            frameMain.add(frameMain.game);
            frameMain.revalidate();
            frameMain.repaint();
        }
        if(e.getSource() == hardButton){
            System.out.println("you clicked hard");
        }
    }
}
