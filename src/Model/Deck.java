package Model;

public class Deck {
    private Card[] deck;        /**vectorul cu cele 52 de carti din pachet**/
    private int nrCardsUsed;    /**numarul total de carti scoase din pachet**/

    public Deck(){
        //TODO construieste pachetul cu cele 52 de carti
        deck = new Card[52];
        int nrCards = 0;

        for(int suit = 0; suit < 4; suit++){
            for(int value = 1; value < 14; value++){
                deck[nrCards] = new Card(value,suit);
                nrCards++;
            }
        }
        nrCardsUsed = 0;
    }

    public void shuffle(){
        //TODO amesteca toate cartile din pachet
        for(int i = 0; i < 52; i++){
            int rand = (int)(Math.random()*(i+1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
    }

    public int nrCardsLeft(){
        //TODO returneaza nr de carti ramase in pachet dupa extrageri
        return 52 - nrCardsUsed;
    }

    public Card dealCard(){
        //TODO extrage o carte si o returneaza. Daca s-au folosit toate cartile se amesteca pachetul.
        if(nrCardsUsed == 52)
            shuffle();
        nrCardsUsed++;
        return deck[nrCardsUsed - 1];
    }
}
