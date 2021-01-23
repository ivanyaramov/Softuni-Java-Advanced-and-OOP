import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class copyBytes {
    public static void main(String[] args) throws Exception{
        String path="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream=new FileInputStream(path);
        FileOutputStream outputStream=new FileOutputStream("D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\out.txt");
        PrintWriter writer=new PrintWriter(outputStream);
        int oneByte=inputStream.read();
        while(oneByte>=0){
            if(oneByte==10||oneByte==32){
                writer.print((char)oneByte);
            }
            else{
                writer.print(oneByte);
            }
            oneByte=inputStream.read();
        }
        writer.close();
        inputStream.close();

    }
}
