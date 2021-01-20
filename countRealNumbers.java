import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class countRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String[] arrString=a.split(" ");
        Map<Double,Integer> map=new LinkedHashMap<>();
        for(int i=0;i<arrString.length;i++){
            double num=Double.parseDouble(arrString[i]);
            if(!map.containsKey(num)){
                map.put(num,1);
            }
           else{
                map.put(num,map.get(num)+1);
            }
        }
        for (Map.Entry<Double, Integer> str : map.entrySet()) {
            System.out.printf("%.1f -> %d%n",str.getKey(),str.getValue());
        }

    }
}
