import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {
    public StartPanel() {

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));

        JButton easyButton = new JButton("Easy");
        JButton mediumButton = new JButton("Medium");
        JButton hardButton = new JButton("Hard");

        add(easyButton);
        add(mediumButton);
        add(hardButton);

        easyButton.addActionListener(event -> JOptionPane.showMessageDialog(null, "You clicked the Easy button"));
        mediumButton.addActionListener(event -> JOptionPane.showMessageDialog(null, "You clicked the Medium button"));
        hardButton.addActionListener(event -> JOptionPane.showMessageDialog(null, "You clicked the Hard button"));

        setPreferredSize(new Dimension(400,150));
        easyButton.setPreferredSize(new Dimension(100,100));
        mediumButton.setPreferredSize(new Dimension(100,100));
        hardButton.setPreferredSize(new Dimension(100,100));

    }
}
