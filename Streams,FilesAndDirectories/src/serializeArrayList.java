import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class serializeArrayList {
    public static void main(String[] args)throws Exception {
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("c");
        ObjectOutputStream oout=new ObjectOutputStream(new FileOutputStream("D:\\failove_softuni\\lista.ser"));
        oout.writeObject(list);
        oout.close();
    }
}
