import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class  writeEveryThirdLine {
    public static void main(String[] args) throws Exception{
        String path="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
       BufferedReader in =new BufferedReader(new FileReader(path));
       PrintWriter writer=new PrintWriter(new FileWriter("D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\out.txt"));
       String line=in.readLine();
       int br=1;
       while(line!=null){
           if(br%3==0){
               writer.println(line);
           }
           line=in.readLine();
           br++;
       }
       in.close();
        writer.close();
    }
}
