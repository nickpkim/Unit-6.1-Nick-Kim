import java.util.ArrayList;
public class War {
    public static void main(String[] args) {
        Deck fullDeck = new Deck();
        fullDeck.makeFull();
        System.out.println("Full deck of cards:");
        System.out.println(fullDeck);

        ArrayList<Card> halfDeck = new ArrayList<>();
        fullDeck.dealHalf(halfDeck);

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        p1.addToStack(halfDeck);
        p2.addToStack(fullDeck);

        System.out.println(p1.toString());
        System.out.println(p2.toString());

        int rounds = 0;
        while (p1.getStack().size() > 0 && p2.getStack().size() > 0){
            ArrayList<Card> pile = new ArrayList<>();
            pile.add(p1.getTopCard());
            pile.add(p2.getTopCard());
            if (p1.getTopCard().getValue() > p2.getTopCard().getValue()){
                p1.addToStack(pile);
            }
            if (p2.getTopCard().getValue() > p1.getTopCard().getValue()){
                p2.addToStack(pile);
            }
            p1.getStack().remove(0);
            p2.getStack().remove(0);
            if (p1.getTopCard().getValue() == p2.getTopCard().getValue()){
                int p1Sum = 0;
                int p2Sum = 0;
                int p1Highest = p1.getTopCard().getValue();
                int p2Highest = p2.getTopCard().getValue();
                int p1HighestSuit = p1.getTopCard().getSuit();
                int p2HighestSuit = p2.getTopCard().getSuit();
                for (int i = 0; i < 4; i++){
                    pile.add(p1.getStack().get(i));
                    p1Sum += p1.getStack().get(i).getValue();
                    pile.add(p2.getStack().get(i));
                    p2Sum += p2.getStack().get(i).getValue();
                }
                if (p1Sum > p2Sum){
                    p1.addToStack(pile);
                    for (int i = 0; i < 5; i++){
                        p1.getStack().remove(0);
                        p2.getStack().remove(0);
                    }
                }
                if (p2Sum > p1Sum){
                    p2.addToStack(pile);
                    for (int i = 0; i < 5; i++){
                        p1.getStack().remove(0);
                        p2.getStack().remove(0);
                    }
                }
                if (p1Sum == p2Sum){

                }
            }
            rounds++;
        }
        if (p1.getStack().size() == 0){
            System.out.println("Player 2 won after "+rounds+" rounds");
        } else {
            System.out.println("Player 1 won after "+rounds+" rounds");
        }
    }
}
