package Game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Save implements Serializable{

    static public void saveObj(Board obj) throws IOException {

//        Board.saving(Board.solvedBoard);

        FileOutputStream fileOut = new FileOutputStream("D:\\Java Projects\\Kakuro\\Saves\\savedObj.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(obj);
        fileOut.close();
        out.close();
    }
}
