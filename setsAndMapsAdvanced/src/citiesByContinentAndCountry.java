import java.util.*;

public class citiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> map=new LinkedHashMap<>();
        for(int i=0;i<a;i++){
            String line = scanner.nextLine();
            String[] arrString=line.split(" ");
            String continent=arrString[0];
            String country=arrString[1];
            String city=arrString[2];
            if(!map.containsKey(continent)){
                Map<String,List<String>> mapCur=new LinkedHashMap<>();
                if(!mapCur.containsKey(country)){
                    List<String> list=new ArrayList<>();
                    list.add(city);
                    mapCur.put(country,list);
                    map.put(continent,mapCur);
                }
                else{
                    mapCur.get(country).add(city);
                }
            }
            else{
                if(!map.get(continent).containsKey(country)){
                    List<String> list=new ArrayList<>();
                    list.add(city);
                    map.get(continent).put(country,list);
                }
                else{
                    map.get(continent).get(country).add(city);
                }
            }

        }
        for (Map.Entry<String, Map<String, List<String>>> str : map.entrySet()) {
            System.out.println(str.getKey()+":");
            for (Map.Entry<String, List<String>> str2 : str.getValue().entrySet()) {
                System.out.print(str2.getKey()+" -> ");
                System.out.println(String.join(", ",str2.getValue()));
            }

        }

    }
}
