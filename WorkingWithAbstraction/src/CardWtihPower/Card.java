package CardWtihPower;

public class Card {
    String rank;
    String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    public int calculate(){
        int rankPower =RankPowers.valueOf(rank).getValue();
        int suitPower=SuitPowers.valueOf(suit).getValue();

        return rankPower+suitPower;
    }
}
