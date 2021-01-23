import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class writeToFile {
    public static void main(String[] args) throws Exception{
        String path="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
    FileInputStream inputStream=new FileInputStream(path);
        FileOutputStream outputStream=new FileOutputStream("D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\out.txt");
        PrintWriter writer=new PrintWriter(outputStream);
        int oneByte=inputStream.read();
        Set<Character> set=new HashSet<>();
        set.add(',');
        set.add('.');
        set.add('!');
        set.add('?');
        while(oneByte>=0){
if(!set.contains((char)oneByte)){
    writer.print((char)oneByte);
}
oneByte=inputStream.read();
        }
        writer.close();
        inputStream.close();

    }
}
