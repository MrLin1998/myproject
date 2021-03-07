package hello;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class collection implements Serializable {
    private static final long serialVersionUID = 110L;

    public static void main(String[] args) throws Exception {
        List<String> cc= new ArrayList<>();
        cc.add("ad");
        cc.add("vds");
        cc.add("ss");
        /*for (String s : cc) {
            System.out.println(s);
        }*/
        /*Iterator<String> it  = cc.iterator();
        while (it.hasNext()){

            Object obj=it.next();
            System.out.println(obj);
        }
        for (Object s:cc)
        {
            System.out.println(s);
        }*/
        /*HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"hangman");
        map.put(2, "soda");
        map.put(3,"lili" );
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer,String> entry:entries) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }*/
        FileOutputStream mu  = new FileOutputStream("serializable");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(mu);
        objectOutputStream.writeObject(cc);
        objectOutputStream.flush();
        objectOutputStream.close();

    }
    }