import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class mergeTwoFiles {
    public static void main(String[] args) throws Exception{
        String path="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String path2="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String pathOut="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\third.txt";
        BufferedReader reader=new BufferedReader(new FileReader(path));
        BufferedReader reader2=new BufferedReader(new FileReader(path2));
        PrintWriter writer=new PrintWriter(new FileWriter(pathOut));
        String line=reader.readLine();
        while(line!=null){
            writer.println(line);
            line=reader.readLine();
        }
        reader.close();
        line=reader2.readLine();
        while(line!=null){
            writer.println(line);
            line=reader2.readLine();
        }
        reader2.close();
        writer.close();
    }
}
