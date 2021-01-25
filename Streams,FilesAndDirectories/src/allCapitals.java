import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class allCapitals {
    public static void main(String[] args) throws Exception{
        String path="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String pathOut="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        PrintWriter writer =new PrintWriter(new FileOutputStream(pathOut));
        String line=reader.readLine();
        while(line!=null){
            writer.println(line.toUpperCase());

            line=reader.readLine();
        }
        writer.close();

    }
}
