import javax.swing.*;

public class GamePanel extends JPanel {

    BoardGenerator board;

    GamePanel(int choice){
        this.setLayout(null);

        board = new BoardGenerator(choice); // param to wielkosc planszy, docelowo bedzie to przekazywane ze startpanel
        board.setBounds(30, 70, 500, 600);
        this.add(board);

        this.setVisible(true);
    }
}
