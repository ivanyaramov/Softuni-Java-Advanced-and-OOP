package CardRank;



public class Main {
    public static void main(String[] args) {
        CardRank[] values = CardRank.values();
        System.out.println("Card Ranks:");
        for(CardRank cur: values){
            System.out.printf("Ordinal value: %d; Name value: %s%n",cur.ordinal(),cur.name());
        }
    }
}
