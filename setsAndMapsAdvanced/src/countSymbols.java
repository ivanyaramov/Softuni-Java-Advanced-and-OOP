import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class countSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<Character,Integer> map=new TreeMap<>();
        for(int i=0;i<line.length();i++){
            if(!map.containsKey(line.charAt(i))){
                map.put(line.charAt(i),1);
            }
            else{
                map.put(line.charAt(i),map.get(line.charAt(i))+1);
            }
        }
        for (Map.Entry<Character, Integer> str : map.entrySet()) {
            System.out.printf("%c: %d time/s%n",str.getKey(),str.getValue());
        }

    }
}
