import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class addVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        UnaryOperator<Double> addVat=p->p*1.2;
        System.out.println("Prices with VAT:");
        Arrays.stream(line.split(", "))
                .mapToDouble(Double::parseDouble)
                .map(addVat::apply)
                .forEach(p-> System.out.printf("%.2f%n",p));
    }
}
