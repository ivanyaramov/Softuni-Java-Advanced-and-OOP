import java.io.FileInputStream;
import java.io.FileOutputStream;

public class copyAPicture {
    public static void main(String[] args)throws Exception {
        String path="D:\\камера\\DCIM\\PICT0001.jpg";
        String pathOut="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\picture-copy.jpg";
        FileInputStream inputStream=new FileInputStream(path);
        FileOutputStream outputStream=new FileOutputStream(pathOut);
        byte[] bytes=inputStream.readAllBytes();
        for(byte cur:bytes){
            outputStream.write(cur);
        }
        inputStream.close();
        outputStream.close();
    }
}
