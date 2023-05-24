import javax.swing.*;
import java.awt.*;

public class FrameMain extends JFrame {

    GamePanel game;

    FrameMain(){
//        this.setLayout(null);
        this.setSize(new Dimension(900, 800));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        game = new GamePanel();
        this.add(game);

        this.setVisible(true);
    }
}
