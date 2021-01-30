import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class predicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<String> list= Arrays.stream(line.split(" "))
                .collect(Collectors.toList());
        BiFunction<String,String,Boolean> startsWith=
                (a,b)-> a.equals(b.substring(0,a.length()));
        BiFunction<String,String,Boolean> endsWith=
                (a,b)-> a.equals(b.substring(b.length()-a.length()));
        BiFunction<Integer,String,Boolean> matchesLength=
                (a,b)->a==b.length();
        line=scanner.nextLine();
        while(!line.equals("Party!")){
            String[] arrString=line.split(" ");
            String addOrRemove=arrString[0];
            String type=arrString[1];
            String condition=arrString[2];
            switch(addOrRemove){
                case "Remove":
theSwitch(addOrRemove,type,condition,list,startsWith,endsWith,matchesLength);
                    break;
                case "Double":
                    theSwitch(addOrRemove,type,condition,list,startsWith,endsWith,matchesLength);
                    break;
            }


            line=scanner.nextLine();
        }
        if(list.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }
        else {
            String lineFinal = list.stream().sorted().collect(Collectors.joining(", "));
            System.out.println(lineFinal + " are going to the party!");
        }
    }
    public static void theSwitch(String addOrRemove,String type,String condition,List<String> list,BiFunction<String,String,Boolean> startsWith,BiFunction<String,String,Boolean> endsWith,BiFunction<Integer,String,Boolean> matchesLength){
        int curSize=list.size();
        switch(type){
            case "StartsWith":
                for(int i=0;i<curSize;i++) {
                    String s=list.get(i);
                    if (startsWith.apply(condition,s)){
                        if(addOrRemove.equals("Remove")){

                        list.remove(s);
                        curSize--;
                        i--;}
                        else{
                            list.add(s);
                        }
                    }
                }
                break;

            case "EndsWith":
                for(int i=0;i<curSize;i++) {
                    String s=list.get(i);
                    if (endsWith.apply(condition,s)){
                        if(addOrRemove.equals("Remove")){

                            list.remove(s);
                            curSize--;
                            i--;}
                        else{
                            list.add(s);
                        }
                    }
                }
                break;

            case "Length":
                for(int i=0;i<curSize;i++) {
                    String s=list.get(i);
                    if (matchesLength.apply(Integer.parseInt(condition),s)){
                        if(addOrRemove.equals("Remove")){

                            list.remove(s);
                            curSize--;
                            i--;}
                        else{
                            list.add(s);
                        }
                    }
                }
                break;

        }



    }
}
