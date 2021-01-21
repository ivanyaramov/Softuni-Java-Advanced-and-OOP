import java.util.*;

public class averageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> map=new TreeMap<>();
        for(int i=0;i<count;i++){
            String a = scanner.nextLine();
            String[] arrString=a.split(" ");
            String name=arrString[0];
            double grade=Double.parseDouble(arrString[1]);
            if(!map.containsKey(name)){
                List<Double> list=new ArrayList<>();
                list.add(grade);
                map.put(name,list);
            }
            else{
                map.get(name).add(grade);
            }
            
        }
        for (Map.Entry<String, List<Double>> str : map.entrySet()) {
            double sum=0;
            for(double number: str.getValue()){
                sum+=number;
            }
            double average=sum/str.getValue().size();
            System.out.printf("%s -> ",str.getKey());
            str.getValue().stream().forEach(p-> System.out.printf("%.2f ",p));
            System.out.printf("(avg: %.2f)%n",average);
        }

    }
}
