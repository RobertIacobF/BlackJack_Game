package Controller;

import Model.Card;
import Model.Deck;

import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        boolean userWins;       /**Daca jucatorul a castigat**/
        System.out.println("Welcome to this awesome BlackJack Game");

        userWins = playBlackJack();
        if(userWins)
            System.out.println("Congrats, you won!");
        else
            System.out.println("Sorry bro, maybe next time you will be more lucky.");
    }

    private static boolean playBlackJack() {
        Deck deck = new Deck();                             /**Un nou pachet de carti**/
        BlackJackHand dealerHand = new BlackJackHand();     /**Mana de carti a dealer-ului(pc-ul)**/
        BlackJackHand playerHand = new BlackJackHand();     /**Mana de carti a jucatorului**/

        //TODO Amesteca pachetul si ofera cate 2 carti jucatorilor
        deck.shuffle();
        dealerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());

        //TODO Verific daca unul dintre jucatori are BlackJack
        if(dealerHand.getBlackJackTotalValue() == 21){
            System.out.println("Dealer has:" + dealerHand.getCard(0) + " and " + dealerHand.getCard(1) + ".");
            System.out.println("You have:" + playerHand.getCard(0) + " and " + playerHand.getCard(1) + ".");
            System.out.println("Dealer is the winner, he has BlackJack.");
            return false;
        }
        if(playerHand.getBlackJackTotalValue() == 21){
            System.out.println("Dealer has:" + dealerHand.getCard(0) + " and " + dealerHand.getCard(1) + ".");
            System.out.println("You have:" + playerHand.getCard(0) + " and " + playerHand.getCard(1) + ".");
            System.out.println("You are the winner, you have BlackJack.");
            return true;
        }

        //TODO Daca nici unul dintre jucatori nu are BlackJack, jocul continua
        Scanner sc = new Scanner(System.in);
        while (true){
            //TODO Arata cartile jucatorului si o carte a dealerului
            System.out.print("Your cards are: ");
            for(int i = 0; i < playerHand.getCardCount(); i++){
                System.out.print(playerHand.getCard(i) + " ");
            }
            System.out.println();
            System.out.println("Your total is: " + playerHand.getBlackJackTotalValue());
            System.out.println("Dealer's card is: " + dealerHand.getCard(0));
            System.out.println("Do you want to draw another card? (Y/N)");

            char userAction; /**Raspunsul jucatorului cu Y/N**/
            do{
                userAction = sc.next().charAt(0);
                if(userAction != 'Y' && userAction != 'N')
                    System.out.println("Please answer only with Y or N");
            }while(userAction != 'Y' && userAction != 'N');

            /**Daca zice nu, jucatorul nu mai ia carti**/
            if(userAction == 'N'){
                break;
            }

            /**Daca zice da, jocul se continua**/
            else{
                Card newCard = deck.dealCard();
                playerHand.addCard(newCard);
                System.out.println("Your card is: " + newCard + ",");
                System.out.println("Your total is now: " + playerHand.getBlackJackTotalValue());
                if(playerHand.getBlackJackTotalValue() > 21){
                    System.out.println("BUSTED. You get over 21. You lose");
                    System.out.println("Dealer's other card was" + dealerHand.getCard(1));
                    return false;
                }
            }
        }
        sc.close();

        /**Pana in punctul acesta jucatorul are 21 sau mai putin. E randul dealerului sa traga o carte. Trebuie sa depaseasca 16. Daca are peste 21, dealerul pierde**/
        System.out.print("Dealer's cards are: ");
        System.out.print(dealerHand.getCard(0) + " ");
        System.out.print(dealerHand.getCard(1) + " ");
        System.out.println();
        while (dealerHand.getBlackJackTotalValue() <= 16){
            Card newCard = deck.dealCard();
            System.out.println("Dealer's card is: " + newCard + ",");
            dealerHand.addCard(newCard);
            if(dealerHand.getBlackJackTotalValue() > 21){
                System.out.println("Dealer is BUSTED. He got over 21. You win");
                return true;
            }
        }
        System.out.println("Dealer's total is: " + dealerHand.getBlackJackTotalValue());

        /**Pana in acest punct ambii jucatori au 21 sau mai putin. Se determina castigatorul comparand cartile din mana**/
        if(dealerHand.getBlackJackTotalValue() == playerHand.getBlackJackTotalValue()){
            System.out.println("Dealer wins. You lose");
            return false;
        }
        else if(dealerHand.getBlackJackTotalValue() > playerHand.getBlackJackTotalValue()){
            System.out.println("Dealer has" + dealerHand.getBlackJackTotalValue() + " and you " + playerHand.getBlackJackTotalValue() + ". He wins");
            return false;
        }
        else{
            System.out.println("You have " + playerHand.getBlackJackTotalValue() + " and dealer has " + dealerHand.getBlackJackTotalValue() + ". You win");
            return true;
        }
    }
}
