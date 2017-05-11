package Model;

import java.util.Vector;

public class Hand {
    private Vector hand; /**cartile din mana**/

    public Hand(){
        hand = new Vector();
    }

    public void clear(){
        //TODO Elimina toate cartile din mana
        hand.removeAllElements();
    }

    public int getCardCount(){
        //TODO Cate carti are jucatorul in mana
        return hand.size();
    }

    public void addCard(Card card){
        //TODO Adauga o carte in pachetul din mana
        if(card != null)
            hand.addElement(card);
    }

    public void removeCard(Card card){
        //TODO Elimina o anumita carte
        hand.removeElement(card);
    }

    public void removeCard(int position){
        //TODO Elimina cartea de pe o anumita pozitie
        if(position > 0 && position < hand.size())
            hand.removeElementAt(position);
    }

    public Card getCard(int position){
        //TODO Obtine cartea de pe o anumita posizite
        if(position >= 0 && position < hand.size())
            return (Card)hand.elementAt(position);
        else
            return null;
    }

    public void sortBySuite(){
        //TODO Sorteaza dupa tip
    }

    public void sortByValue(){
        //TODO Sorteaza dupa valoare
    }
}
