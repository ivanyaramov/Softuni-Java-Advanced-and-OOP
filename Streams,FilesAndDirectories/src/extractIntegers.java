import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class extractIntegers {
    public static void main(String[] args) throws Exception{
        String path="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream=new FileInputStream(path);
        Scanner scanner=new Scanner(inputStream);
        FileOutputStream outputStream=new FileOutputStream("D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\out.txt");
        PrintWriter writer=new PrintWriter(outputStream);
        while(scanner.hasNext()){
            if(scanner.hasNextInt()){
                int num=scanner.nextInt();
                writer.println(num);
            }
            scanner.next();
        }

      writer.flush();
        writer.close();
        inputStream.close();

    }
}
