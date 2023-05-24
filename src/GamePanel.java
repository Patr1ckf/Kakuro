import javax.swing.*;

public class GamePanel extends JPanel {

    BoardGenerator board;

    GamePanel(){
//        this.setLayout(null);

        board = new BoardGenerator(3); // param to wielkosc planszy, docelowo bedzie to przekazywane ze startpanel
        this.add(board);

        this.setVisible(true);
    }
}
