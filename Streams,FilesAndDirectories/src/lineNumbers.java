import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class lineNumbers {
    public static void main(String[] args) throws Exception{
        String path="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String pathOut="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
        BufferedReader reader=new BufferedReader(new FileReader(path));
        PrintWriter writer=new PrintWriter(new FileWriter(pathOut));
        String line=reader.readLine();
        int br=0;
        while(line!=null){
            br++;
            writer.println(br+". "+line);

            line=reader.readLine();
        }
        writer.close();
    }
}
