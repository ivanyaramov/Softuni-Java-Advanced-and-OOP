import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class appliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line=scanner.nextLine();
        String a = scanner.nextLine();
        Function<String,IntStream>arrayCreator =p-> Arrays.stream(p.split(" "))
                .mapToInt(Integer::parseInt);

        Function<IntStream,String> add=p->
                p.map(f->f+1)
                        .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        Function<IntStream,String> sub=p->
                p.map(f->f-1)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "));
        Function<IntStream,String> multiply=p->
                p.map(f->f*2)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "));
       String finall="";
        while(!a.equals("end")){
            switch(a){
                case "add":
                    line=add.apply(arrayCreator.apply(line));
                    break;
                case "subtract":
                    line=sub.apply(arrayCreator.apply(line));
                break;
                case "multiply":
                    line=multiply.apply(arrayCreator.apply(line));
            break;
                case "print":
                    System.out.println(line);
                    break;
            }

            a=scanner.nextLine();
        }
    }
}
