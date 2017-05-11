package Model;

public class Card extends Constants {
    private final int suit;   //suita, sunt 4 tipuri aferente fiecarei carti: inima rosie, romb, trefla, pica
    private final int value;  //valoarea cartii in joc, de la 1 la 13

    public Card(int theValue, int theSuit){
        //TODO Construieste o carte pe baza informatiilor caracteristice
        value = theValue;
        suit = theSuit;
    }

    public int getSuit() { return suit;}

    public int getValue() { return value;}

    public String getSuitAsString(){
        //TODO Returneaza valorile ca stringuri
        switch ( suit ) {
            case SPADES:   return "Spades";
            case HEARTS:   return "Hearts";
            case DIAMONDS: return "Diamonds";
            case CLUBS:    return "Clubs";
            default:       return "??";
        }
    }

    public String getValueAsString(){
        //TODO Returneaza tipurile ca stringuri
        switch ( value ) {
            case 1:   return "Ace";
            case 2:   return "2";
            case 3:   return "3";
            case 4:   return "4";
            case 5:   return "5";
            case 6:   return "6";
            case 7:   return "7";
            case 8:   return "8";
            case 9:   return "9";
            case 10:  return "10";
            case 11:  return "JACK";
            case 12:  return "QUEEN";
            case 13:  return "KING";
            default:  return "WRONG VALUE";
        }
    }

    @Override
    public String toString() { return  getValueAsString() + " of " + getSuitAsString();}
}
