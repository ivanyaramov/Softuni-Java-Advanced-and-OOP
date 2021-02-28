package CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CardSuit[] values = CardSuit.values();
        System.out.println("Card Suits:");
        for(CardSuit cur: values){
            System.out.printf("Ordinal value: %d; Name value: %s%n",cur.ordinal(),cur.name());
        }
    }
}
