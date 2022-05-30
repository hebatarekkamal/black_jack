package blackjack;

import java.util.Scanner;
public class BlackJack {
    static  Game game=new Game();


    public static void main(String[] args) {
        GUI gui = new GUI();


        Scanner input = new Scanner(System.in);
        Scanner in=new Scanner(System.in);

        game.generate_cards();


        game.setinfo();

        gui.runGUI( game.card_deck,game.arrofplayer[0].arrofcards, game.arrofplayer[1].arrofcards, game.arrofplayer[2].arrofcards,game.arrofplayer[3].arrofcards );

        for (int numberofplayer = 0; numberofplayer < 3; numberofplayer++) {
            System.out.println("player " + (numberofplayer + 1) + " :");
            int numberofcard=2;
            System.out.println();
            System.out.println("(hit or stand : )");
            System.out.println("1)hit ");
            System.out.println("2)stand");
            int hors=in.nextInt();

            while(hors==1 && numberofcard<=10 && game.arrofplayer[numberofplayer].Score<21) {
                game.arrofplayer[numberofplayer].arrofcards[numberofcard] =game.draw_cards();
                gui.updatePlayerHand(game.arrofplayer[numberofplayer].arrofcards[numberofcard], numberofplayer);

                game.arrofplayer[numberofplayer].Score += game.arrofplayer[numberofplayer].arrofcards[numberofcard].getValue();
                if( game.arrofplayer[numberofplayer].Score>=21)
                    break;
                else {System.out.println("(hit or stand : )");
                    System.out.println("1)hit ");
                    System.out.println("2)stand");
                    hors = in.nextInt();
                    numberofcard++;
                }
            }
        }


        int m = game.max_score();
        int cardofdelar = 2;
        while (game.arrofplayer[3].Score<21&&cardofdelar<11&&game.arrofplayer[3].Score<=m)
        {  Card chose= game.draw_cards();
            game.add(chose,cardofdelar);
            game.arrofplayer[3].Score+=chose.getValue();
            gui.updateDealerHand(game.arrofplayer[3].arrofcards[cardofdelar], game.card_deck);
            cardofdelar++;
        }

        int numberofwinner=0;
        int final_max=game.max_score();
        for(int w=0;w<4;w++)
        {
            if(game.arrofplayer[w].Score==final_max)
                numberofwinner++;
        }
        if(numberofwinner==1)
        {for(int y=0;y<4;y++)
            if(game.arrofplayer[y].Score==final_max) {
                if(final_max==21)
                    System.out.println("blackjack is "+(y+1)+" "+game.arrofplayer[y].Name);
                else
                    System.out.println("winner is player "+(y+1)+" "+game.arrofplayer[y].Name);

            }
        }
        else
            System.out.println("PUSH");




    }
}
