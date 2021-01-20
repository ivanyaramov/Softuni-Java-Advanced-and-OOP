import java.util.*;

public class softUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> guests=new TreeSet<>();
        ;
        while(true){
            String line = scanner.nextLine();
            if(line.equals("PARTY")){
                break;
            }
           guests.add(line);
        }

        while(true){
            String line = scanner.nextLine();
            if(line.equals("END")){
                break;
            }
           guests.remove(line);
        }
        System.out.println(guests.size());
        guests.forEach(p-> System.out.println(p));

    }
}
