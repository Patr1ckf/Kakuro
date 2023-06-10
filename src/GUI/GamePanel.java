package GUI;

import Game.Board;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
//import static GUI.PrintButton.frame;
//import static GUI.PrintButton.main;

public class GamePanel extends GameComponent implements ActionListener {
    private final JLayeredPane layeredPane;
    private final JPanel gridPanel = new JPanel();
    private StartPanel startPanel;
    private JButton backButton;
    private JPanel gridOfButtons;
    private JButton[][] gridB;
    private JButton[] choiceButtons;
    private JButton buttonX;
    private JButton clickedBoard;
    private JButton PrintButton;
    private int iToADD;
    private int jToADD;

    GamePanel(){
        addBackButton();
        addPrintButton();
        this.setLayout(null);
        this.setVisible(false);
        this.setBounds(50, 0, 800, 750);
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(30, 90, 700, 750);
        this.add(layeredPane);
    }
    public void create(Object...args){
        this.startPanel = (StartPanel) args[0];
        this.setVisible(true);
        this.add(gridPanel);
        layeredPane.add(gridPanel, Integer.valueOf(0));
        createChoiceButtons();
    }

    public void showBoard(int[][] board, int size){
        gridB = new JButton[size][size];
        gridPanel.setLayout(new GridLayout(size, size));
        gridPanel.setBounds(0, 0, 500, 600);
        int temp;

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++) {
                gridB[i][j] = new JButton();
                if(board[i][j] != 0){
                    temp = board[i][j];
                    gridB[i][j].setText(String.valueOf(temp));
                    gridB[i][j].setFont(new Font("MV Boli", Font.PLAIN, 45));
                    gridB[i][j].setEnabled(false);
                }
                else if(i==0 && j==0){
                    gridB[i][j].setEnabled(false);
                }
                else{
                    gridB[i][j].addActionListener(this);
                }
                gridPanel.add(gridB[i][j]);
            }
        }
    }

    public void clearBoard() {
        gridPanel.removeAll();
        gridPanel.revalidate();
        gridPanel.repaint();
    }
    public void addPrintButton(){
        PrintButton = new JButton("zapisz w postaci screena");
        PrintButton.setBounds(230, 20, 200, 50);
        PrintButton.addActionListener(this);
        PrintButton.setVisible(true);
        this.add(PrintButton);
    }
    public void addBackButton(){
        backButton = new JButton("wróc do menu");
        backButton.setBounds(50, 20, 140, 50);
        backButton.addActionListener(this);
        backButton.setVisible(true);
        this.add(backButton);
    }

    public void createChoiceButtons(){
        gridOfButtons = new JPanel(new GridBagLayout());
        gridOfButtons.setOpaque(false);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
//        constraints.insets = new Insets(1, 1, 1, 1);

        choiceButtons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            choiceButtons[i] = new JButton(String.valueOf(i + 1));
            choiceButtons[i].setFont(new Font("Mv Boli", Font.PLAIN, 18));
            choiceButtons[i].addActionListener(e -> {
                JButton clicked = (JButton) e.getSource();
                for (JButton choiceButton : choiceButtons) {
                    if (clicked == choiceButton) {
                        System.out.println(choiceButton);
                        clickedBoard.setText(clicked.getText());
                        clickedBoard.setFont(new Font("MV Boli", Font.PLAIN, 45));
                        Board.board[iToADD][jToADD] = Integer.parseInt(clickedBoard.getText());
                        gridOfButtons.setVisible(false);

                        for(int[] l:Board.board){
                            for(int j:l){
                                System.out.print(j +" ");
                            }
                            System.out.println();
                        }
                    }
                }
            });
            constraints.gridx = i % 3;
            constraints.gridy = i / 3;
            gridOfButtons.add(choiceButtons[i], constraints);
        }

        buttonX = new JButton("X");
        buttonX.setFont(new Font("Mv Boli", Font.PLAIN, 18));
        buttonX.setHorizontalAlignment(SwingConstants.CENTER);
        buttonX.addActionListener(e -> {
            System.out.println("X");
            clickedBoard.setText("");
            gridOfButtons.setVisible(false);
        });
        constraints.gridx = 1;
        constraints.gridy = 3;
        gridOfButtons.add(buttonX, constraints);

        gridOfButtons.setVisible(false);
        layeredPane.add(gridOfButtons, Integer.valueOf(1));

    }
    public void showChoiceOfButtons(int x, int y){
        if(gridB.length==3){
            gridOfButtons.setBounds(x+10, y+70, 150, 150);
        }
        else if(gridB.length==4){
            for (int i = 0; i < 9; i++) {
                choiceButtons[i].setFont(new Font("Mv Boli", Font.PLAIN, 14));
            }
            buttonX.setFont(new Font("Mv Boli", Font.PLAIN, 12));
            gridOfButtons.setBounds(x+10, y+65, 135, 135);
        }
        else if(gridB.length==5){
            for (int i = 0; i < 9; i++) {
                choiceButtons[i].setFont(new Font("Mv Boli", Font.PLAIN, 12));
            }
            buttonX.setFont(new Font("Mv Boli", Font.PLAIN, 12));

            gridOfButtons.setBounds(x+10, y+50, 130, 130);
        }

        gridOfButtons.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            this.setVisible(false);
            clearBoard();
            startPanel.setVisible(true);

            if(gridOfButtons != null){
                gridOfButtons.setVisible(false);
            }
        }

        if(e.getSource()==PrintButton) {
            BufferedImage image = new BufferedImage(  gridPanel.getWidth(),   gridPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = image.createGraphics();
            gridPanel.print(graphics2D);
            String baseFileName = "panel";
            String fileExtension = "jpg";
            int fileCount = 1;
            File outputFile;
            do {
                String fileName = baseFileName + "_" + fileCount + "." + fileExtension;
                outputFile = new File(fileName);
                fileCount++;
            } while (outputFile.exists());

            // Zapis obrazu do pliku JPG
            try {
                ImageIO.write(image, "jpg", outputFile);
                System.out.println("Zapisano obraz do pliku: " + outputFile.getAbsolutePath());
            } catch (Exception a) {
                a.printStackTrace();
            }
        }

        clickedBoard = (JButton) e.getSource();
        for(int i=0; i< gridB.length; i++){
            for(int j=0; j<gridB[i].length; j++){
                if(clickedBoard == gridB[i][j]){
                    System.out.println(i + "" + j);
                    iToADD = i;
                    jToADD = j;
                    showChoiceOfButtons(gridB[i][j].getX(), gridB[i][j].getY());
                }
            }
        }
    }
}
