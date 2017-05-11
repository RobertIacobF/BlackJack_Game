package Controller;

import Model.Card;
import Model.Hand;

public class BlackJackHand extends Hand {
    public int getBlackJackTotalValue(){
        int total = 0;
        boolean ace = false;
        int totalCards = getCardCount();

        for(int i = 0; i < totalCards; i++){
            Card tempCard;
            int tempCardVal;

            tempCard = getCard(i);              /**A i-a carte**/
            tempCardVal = tempCard.getValue();  /**Valoarea celei de-a i-a carte**/

            if(tempCardVal > 10){
                tempCardVal = 10;               /**Daca a i-a carte este un J,Q,K**/
            }
            if(tempCardVal == 1){
                ace = true;                     /**Daca a i-a carte este 1 atunci exista macar un A in mana**/
            }
            total += tempCardVal;
        }

        if(ace == true && total + 10 <= 21){    /**Daca in mana se gaseste un A si daca este favorabil jucatorului sa il foloseasca cu valoarea 11**/
            total += 10;                        /**Atunci se adauga la total 10 deoarece a fost luat deja in considerare pe cand avea valoarea 1**/
        }

        return total;
    }
}
