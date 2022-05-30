package blackjack;
import java.util.Random;
import java.util.Scanner;
public class Game {
    public Player[] arrofplayer = new Player[4];

    public Card[] card_deck = new Card[52];



    public void generate_cards() {
        int j=0;
        for (int suit1 = 0; suit1 < 4; suit1++) {
            for (int rank1 = 0; rank1 <= 12; rank1++) {
                if(rank1<9)
                {
                    this.card_deck[j]=new Card(rank1,suit1,rank1+1);
                    j++;}

                else {
                    card_deck[j] = new Card(rank1,suit1, 10);
                    j++;
                }
            }

        }

    }
    public Card draw_cards() {
        int randomchoice;

        do {
            Random rand = new Random();
            randomchoice = rand.nextInt(52);

        } while (card_deck[randomchoice] == null);
        Card new_card = new Card(card_deck[randomchoice].getRank(), card_deck[randomchoice].getSuit(), card_deck[randomchoice].getValue());
        card_deck[randomchoice] = null;


        return new_card;
    }

    public void setinfo() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i <= 2; i++) {
            System.out.println("enterplayer" + (i + 1) + "'s name  :");
            String he = input.next();
            arrofplayer[i] = new Player();
            arrofplayer[i].setName(he);
            for (int p = 0; p < 2; p++) {
                arrofplayer[i].arrofcards[p] = draw_cards();
                arrofplayer[i].Score += arrofplayer[i].arrofcards[p].getValue();
            }

        }

        arrofplayer[3] = new Player();
        arrofplayer[3].setName("delear");
        for (int p = 0; p < 2; p++) {
            arrofplayer[3].arrofcards[p] = draw_cards();
            arrofplayer[3].Score += arrofplayer[3].arrofcards[p].getValue();
        }
    }


    public int max_score() {
        int max = 0;
        for (int i = 0; i < 4; i++) {
            if (max < arrofplayer[i].Score&&arrofplayer[i].Score<=21)
                max = arrofplayer[i].Score;}
        return max;
    }
    public void add(Card b,int n){

        arrofplayer[3].arrofcards[n]=new Card( b.getRank(),b.getSuit(), b.getValue());
    }

}





