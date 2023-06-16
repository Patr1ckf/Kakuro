package Game;

import java.io.*;

public class Save implements Serializable{

    static public void saveObj(BoardData obj) throws IOException {

        BoardData boardData = new BoardData(Board.board);

        FileOutputStream fileOut = new FileOutputStream("D:\\Java Projects\\Kakuro\\Saves\\savedObj3.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(boardData);

        out.close();
        fileOut.close();

        System.out.println("Zapisano aktualną planszę.");
    }


    static public int[][] readObj() throws IOException, ClassNotFoundException {
        BoardData objRead = null;

        FileInputStream fileIn = new FileInputStream("D:\\Java Projects\\Kakuro\\Saves\\savedObj3.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        objRead = (BoardData) in.readObject();

        in.close();
        fileIn.close();

        return objRead.getBoard();
    }

    static public void saveObj4(BoardData obj) throws IOException {

        BoardData boardData = new BoardData(Board.board);

        FileOutputStream fileOut = new FileOutputStream("D:\\Java Projects\\Kakuro\\Saves\\savedObj4.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(boardData);

        out.close();
        fileOut.close();

        System.out.println("Zapisano aktualną planszę.");
    }


    static public int[][] readObj4() throws IOException, ClassNotFoundException {
        BoardData objRead = null;

        FileInputStream fileIn = new FileInputStream("D:\\Java Projects\\Kakuro\\Saves\\savedObj4.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        objRead = (BoardData) in.readObject();

        in.close();
        fileIn.close();

        return objRead.getBoard();
    }

    static public void saveObj5(BoardData obj) throws IOException {

        BoardData boardData = new BoardData(Board.board);

        FileOutputStream fileOut = new FileOutputStream("D:\\Java Projects\\Kakuro\\Saves\\savedObj5.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(boardData);

        out.close();
        fileOut.close();

        System.out.println("Zapisano aktualną planszę.");
    }


    static public int[][] readObj5() throws IOException, ClassNotFoundException {
        BoardData objRead = null;

        FileInputStream fileIn = new FileInputStream("D:\\Java Projects\\Kakuro\\Saves\\savedObj5.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        objRead = (BoardData) in.readObject();

        in.close();
        fileIn.close();

        return objRead.getBoard();
    }
}
