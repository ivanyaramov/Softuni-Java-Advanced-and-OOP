import java.util.*;
import java.util.stream.Collectors;

public class handOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> map=new LinkedHashMap<>();
        while(true){
            String line = scanner.nextLine();
            if(line.equals("JOKER")){
                break;
            }
            String[]nameAndSet=line.split(": ");
            String name=nameAndSet[0];
            String[]arrString=nameAndSet[1].split(", ");
            if(map.containsKey(name)){
                for(int i=0;i<arrString.length;i++){
                    map.get(name).add(arrString[i]);
                }
            }
            else{
                Set<String> set=new HashSet<>();
                set=Arrays.stream(arrString).collect(Collectors.toSet());
                map.put(name,set);
            }

        }
        int sum=0;
        for (Map.Entry<String, Set<String>> str : map.entrySet()) {

            for(String s: str.getValue()){
                int sumCur=0;
                if(Character.isDigit(s.charAt(0))){
                    if(s.charAt(0)=='1'){
                        sumCur+=10;
                    }
                    else{
                        sumCur+=Character.getNumericValue(s.charAt(0));
                    }
                }
                else if(s.charAt(0)=='J'){
                    sumCur+=11;
                }
                else if(s.charAt(0)=='Q'){
                    sumCur+=12;
                }
                else if(s.charAt(0)=='K'){
                    sumCur+=13;
                }
                else if(s.charAt(0)=='A'){
                    sumCur+=14;
                }

                if(s.charAt(s.length()-1)=='S'){
                    sumCur*=4;
                }
                else if(s.charAt(s.length()-1)=='H'){
                    sumCur*=3;
                }
                else if(s.charAt(s.length()-1)=='D'){
                    sumCur*=2;
                }
               sum+=sumCur;
            }

            System.out.printf("%s: %d%n",str.getKey(),sum);
            sum=0;

        }

    }
}
