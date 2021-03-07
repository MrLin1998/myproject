package hello;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class Myois {
    public static void main(String[] args) throws  Exception {
        ObjectInputStream serializable = new ObjectInputStream(new FileInputStream("serializable"));
        /* ArrayList<String>o = (ArrayList<String>)serializable.readObject();
        for (String i:o
             ) {
            System.out.println(i);
        }*/
        List<String> o = (List<String>) serializable.readObject();
        for (Object i : o
        ) {
            System.out.println(i);
        }
    }
}
