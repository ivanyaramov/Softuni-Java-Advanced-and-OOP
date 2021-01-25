import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class wordCount {
    public static void main(String[] args) throws Exception {
        String path="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String path2="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String pathOut="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt";
        BufferedReader reader=new BufferedReader(new FileReader(path));
        BufferedReader reader2=new BufferedReader(new FileReader(path2));
        PrintWriter writer=new PrintWriter(new FileWriter(pathOut));
        String[]words=reader.readLine().split(" ");
        String line=reader2.readLine();
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],0);
        }
        while(line!=null){
            String[] words2=line.split(" ");
            for(String w2:words2){
                for(String w1:words){
                    if(w1.equals(w2)){
                        map.put(w1,map.get(w1)+1);
                    }
                }
            }
line=reader.readLine();
        }
        map.entrySet().stream()
                .sorted((b,a)->Integer.compare(a.getValue(),b.getValue()))
                .forEach(p-> writer.printf("%s - %d%n",p.getKey(),p.getValue()));




writer.close();

    }
}
