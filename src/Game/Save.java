package Game;

import java.io.*;

public class Save implements Serializable{

    static public void saveObj(BoardData ignoredObj) throws IOException {

        BoardData boardData = new BoardData(Board.board);

        FileOutputStream fileOut = new FileOutputStream("Saves/savedObj3.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(boardData);

        out.close();
        fileOut.close();

        System.out.println("Zapisano aktualną planszę.");
    }


    static public int[][] readObj() throws IOException, ClassNotFoundException {
        BoardData objRead;

        FileInputStream fileIn = new FileInputStream("Saves/savedObj3.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        objRead = (BoardData) in.readObject();

        in.close();
        fileIn.close();

        return objRead.getBoard();
    }

    static public void saveObj4(BoardData ignoredObj) throws IOException {

        BoardData boardData = new BoardData(Board.board);

        FileOutputStream fileOut = new FileOutputStream("Saves/savedObj4.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(boardData);

        out.close();
        fileOut.close();

        System.out.println("Zapisano aktualną planszę.");
    }


    static public int[][] readObj4() throws IOException, ClassNotFoundException {
        BoardData objRead;

        FileInputStream fileIn = new FileInputStream("Saves/savedObj4.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        objRead = (BoardData) in.readObject();

        in.close();
        fileIn.close();

        return objRead.getBoard();
    }

    static public void saveObj5(BoardData ignoredObj) throws IOException {

        BoardData boardData = new BoardData(Board.board);

        FileOutputStream fileOut = new FileOutputStream("Saves/savedObj5.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(boardData);

        out.close();
        fileOut.close();

        System.out.println("Zapisano aktualną planszę.");
    }


    static public int[][] readObj5() throws IOException, ClassNotFoundException {
        BoardData objRead;

        FileInputStream fileIn = new FileInputStream("Saves/savedObj5.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        objRead = (BoardData) in.readObject();

        in.close();
        fileIn.close();

        return objRead.getBoard();
    }
}
