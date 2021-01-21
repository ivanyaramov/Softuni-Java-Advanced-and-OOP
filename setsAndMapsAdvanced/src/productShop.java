import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class productShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String,Double> >map = new TreeMap<>();
        while(true){
            String a = scanner.nextLine();
            if(a.equals("Revision")){
                break;
            }
            String[] arrString=a.split(", ");
            String shop=arrString[0];
            String product=arrString[1];
            double price=Double.parseDouble(arrString[2]);
            if(!map.containsKey(shop)){
                Map<String,Double> mapCur=new LinkedHashMap<>();
                mapCur.put(product,price);
                map.put(shop,mapCur);
            }
            else{
                map.get(shop).put(product,price);
            }
        }
        for (Map.Entry<String, Map<String, Double>> str : map.entrySet()) {
            System.out.println(str.getKey()+"->");
            for (Map.Entry<String, Double> str2 : str.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n",str2.getKey(),str2.getValue());
            }

        }

    }
}
