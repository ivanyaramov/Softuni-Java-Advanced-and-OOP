import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class sumBytes {
    public static void main(String[] args) throws Exception{
        String path="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedReader reader= Files.newBufferedReader(Paths.get(path));
        String line=reader.readLine();
        int sum=0;
        while(line!=null){

            for(int i=0;i<line.length();i++){
                sum+=(int)line.charAt(i);
            }

            line=reader.readLine();
        }
        System.out.println(sum);

    }
}
