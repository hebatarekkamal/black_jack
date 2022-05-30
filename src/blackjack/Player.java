package blackjack;

public class Player {
    public String Name;
    public int Score;
    Card []arrofcards=new Card[11];

    public void setName(String name) {
        Name = name;
    }

    boolean statueb=false;           //indicates whether he got a blackjack or not.
    boolean statuel=true;
    //whether he already lost or not.


}
