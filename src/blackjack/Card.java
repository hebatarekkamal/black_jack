package blackjack;

public class Card {
    private final int  suit;                                        /*attributes*/
    private final int rank;
    private final  int value;

    public Card(int rank, int suit , int value) {                /*constuctor*/
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }
    public Card(Card card)                                     /*copy constuctor*/
    { this.suit = card.suit;
        this.rank = card.rank;
        this.value = card.value; }

    public int getSuit() {                          /*getter for gui*/
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

}
