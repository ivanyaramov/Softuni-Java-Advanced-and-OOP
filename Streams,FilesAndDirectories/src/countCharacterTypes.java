import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class countCharacterTypes {
    public static void main(String[] args)throws Exception {
        String path="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String pathOut="D:\\failove_softuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        BufferedReader reader=new BufferedReader(new FileReader(path));
        Set<Character> vowels=new HashSet<>();
        PrintWriter writer=new PrintWriter(new FileWriter(pathOut));
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        Set<Character>punctuation=new HashSet<>();
        punctuation.add('!');
        punctuation.add(',');
        punctuation.add('.');
        punctuation.add('?');
        String line=reader.readLine();
        int vowelCount=0;
        int consonantCount=0;
        int punctuationCount=0;
        while(line!=null){
            for(int i=0;i<line.length();i++){
                char cur=line.charAt(i);
                if(vowels.contains(cur)){
                    vowelCount++;
                }
                else if(punctuation.contains(cur)){
                    punctuationCount++;
                }
                else if(cur!=' '){
                    consonantCount++;
                }

            }
            line=reader.readLine();
        }
        writer.print("Vowels: ");
        writer.println(vowelCount);
        writer.print("Consonants: ");
        writer.println(consonantCount);
        writer.print("Punctuation: ");
        writer.println(punctuationCount);
        writer.close();

    }
}
