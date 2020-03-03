public class Card {
    private int value;
    private int suit;
    public Card(int value, int suit){
        this.value = value;
        this.suit = suit;
    }
    public int getValue(){
        return value;
    }
    public int getSuit(){
        return suit;
    }
    public String toString() {
        String printVal;
        String printSuit;
        if (value == 10) {
            printVal = "10";
        } else if (value == 11){
            printVal = " J";
        } else if (value == 12){
            printVal = " Q";
        } else if (value == 13){
            printVal = " K";
        } else if (value == 14){
            printVal = " A";
        } else {
            printVal = " "+value;
        }
        if (suit == 1){
            printSuit = "♣";
        } else if (suit == 2){
            printSuit = "♦";
        } else if (suit == 3){
            printSuit = "♥";
        } else {
            printSuit = "♠";
        }
        return printVal+printSuit;
    }
    //♠♥♣♦
}
