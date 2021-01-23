import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class sortLines {
    public static void main(String[] args) throws Exception {
        String path="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\out.txt";
        List<String> lines= Files.readAllLines(Path.of(path));
        PrintWriter writer=new PrintWriter(new FileWriter(pathOut));
        Collections.sort(lines);
        for(int i=0;i<lines.size();i++){
        writer.println(lines.get(i));
        }
        writer.close();

    }
}
