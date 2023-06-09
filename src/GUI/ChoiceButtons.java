package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ChoiceButtons {

    private JFrame frame;
    private JPanel panel;
    private JButton[] choiceButtons;

    public ChoiceButtons() {
        frame = new JFrame("Choice Buttons");
        panel = new JPanel(new GridLayout(3, 3));
        choiceButtons = new JButton[9];

        // Utworzenie przycisków wyboru od 1 do 9
        for (int i = 0; i < 9; i++) {
            choiceButtons[i] = new JButton(String.valueOf(i + 1));
            choiceButtons[i].addActionListener(new ChoiceButtonClickListener());
            panel.add(choiceButtons[i]);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private static class ChoiceButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton clickedButton = (JButton) event.getSource();
            String buttonText = clickedButton.getText();
            System.out.println("Button " + buttonText + " clicked");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChoiceButtons();
            }
        });
    }
}
