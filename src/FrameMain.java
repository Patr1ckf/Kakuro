import javax.swing.*;
import java.awt.*;

public class FrameMain extends JFrame {

    GamePanel game;
    StartPanel startPanel;

    FrameMain(){
        this.setLayout(null);
        this.setSize(new Dimension(900, 800));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        startPanel = new StartPanel(this);
        startPanel.setBounds(50, 50 , 800, 700);
        this.add(startPanel);

        this.setVisible(true);
    }
}
