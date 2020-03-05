import java.util.ArrayList;
public class War {
    public static void main(String[] args) {
        int totalRounds = 0;
        for (int l = 0; l < 10000; l++){
            Deck fullDeck = new Deck();
            fullDeck.makeFull();
            //System.out.println("Full deck of cards:");
            //System.out.println(fullDeck);

            ArrayList<Card> halfDeck = new ArrayList<>();
            fullDeck.dealHalf(halfDeck);

            Player p1 = new Player(1);
            Player p2 = new Player(2);
            //p1.addToStack(new Card(4,4));
            //p2.addToStack(new Card(4,3));
            p1.addToStack(halfDeck);
            p2.addToStack(fullDeck);

            int rounds = 0;
            boolean sameValue = false;
            boolean p1FinalFour;
            boolean p2FinalFour;
            while (p1.getStack().size() > 0 && p2.getStack().size() > 0){
                if (rounds % 5000 == 0){
                    p1.shuffleStack();
                    p2.shuffleStack();
                }
                //System.out.println();
                //System.out.println(p1.toString());
                //System.out.println(p2.toString());
                if (p1.getStack().size() <= 4){
                    p1FinalFour = true;
                } else {
                    p1FinalFour = false;
                }
                if (p2.getStack().size() <= 4){
                    p2FinalFour = true;
                } else {
                    p2FinalFour = false;
                }
                ArrayList<Card> pile = new ArrayList<>();
                pile.add(p1.getTopCard());
                pile.add(p2.getTopCard());
                if (p1.getTopCard().getValue() > p2.getTopCard().getValue()){
                    p1.addToStack(pile);
                }
                if (p2.getTopCard().getValue() > p1.getTopCard().getValue()){
                    p2.addToStack(pile);
                }
                if (p2.getTopCard().getValue() == p1.getTopCard().getValue()){
                    sameValue = true;
                }
                p1.getStack().remove(0);
                p2.getStack().remove(0);
                //System.out.println(pile);
                if (sameValue){
                    sameValue = false;
                    int handNum = 4;
                    if (p1FinalFour){
                        handNum = p1.getStack().size();
                    }
                    if (p2FinalFour){
                        handNum = p2.getStack().size();
                    }
                    if (handNum == 0){
                        continue;
                    }
                    //System.out.println("Values match");
                    int p1Sum = 0;
                    int p2Sum = 0;
                    for (int i = 0; i < handNum; i++){
                        pile.add(p1.getStack().get(i));
                        p1Sum += p1.getStack().get(i).getValue();
                        pile.add(p2.getStack().get(i));
                        p2Sum += p2.getStack().get(i).getValue();
                    }
                    //System.out.println("p1Sum: "+p1Sum+" p2Sum: "+p2Sum);
                    Card p1Highest = p1.getTopCard();
                    for (int i = 1; i < handNum; i++){
                        if (p1.getCard(i).getValue() > p1Highest.getValue()){
                            p1Highest = p1.getCard(i);
                        }
                    }
                    //System.out.println("p1Highest "+p1Highest);
                    Card p2Highest = p2.getTopCard();
                    for (int i = 1; i < handNum; i++){
                        if (p2.getCard(i).getValue() > p2Highest.getValue()){
                            p2Highest = p2.getCard(i);
                        }
                    }
                    //System.out.println("p2Highest "+p2Highest);
                    //int p1HighestSuit = p1Highest.getSuit();
                    //int p2HighestSuit = p2Highest.getSuit();
                    if (p1Sum > p2Sum){
                        p1.addToStack(pile);
                        for (int i = 0; i < handNum; i++){
                            p1.getStack().remove(0);
                            p2.getStack().remove(0);
                        }
                    }
                    if (p2Sum > p1Sum){
                        p2.addToStack(pile);
                        for (int i = 0; i < handNum; i++){
                            p1.getStack().remove(0);
                            p2.getStack().remove(0);
                        }
                    }
                    if (p1Sum == p2Sum){
                        if (p1Highest.getValue() > p2Highest.getValue()){
                            p1.addToStack(pile);
                            for (int i = 0; i < handNum; i++){
                                p1.getStack().remove(0);
                                p2.getStack().remove(0);
                            }
                        }
                        if (p2Highest.getValue() > p1Highest.getValue()){
                            p2.addToStack(pile);
                            for (int i = 0; i < handNum; i++){
                                p1.getStack().remove(0);
                                p2.getStack().remove(0);
                            }
                        }
                        if (p1Highest == p2Highest){
                            if (p1Highest.getSuit() > p2Highest.getSuit()){
                                p1.addToStack(pile);
                                for (int i = 0; i < handNum; i++){
                                    p1.getStack().remove(0);
                                    p2.getStack().remove(0);
                                }
                            }
                            if (p2Highest.getSuit() > p1Highest.getSuit()){
                                p2.addToStack(pile);
                                for (int i = 0; i < handNum; i++){
                                    p1.getStack().remove(0);
                                    p2.getStack().remove(0);
                                }
                            }
                        }
                    }
                }
                rounds++;
            }
            //System.out.println("Game Over");
            if (p1.getStack().size() == 0){
                //System.out.println("Player 2 won after "+rounds+" rounds");
            } else {
                //System.out.println("Player 1 won after "+rounds+" rounds");
            }
            totalRounds += rounds;
        }
        //System.out.println();
        //System.out.println();
        System.out.println("AVERAGE NUMBER OF ROUNDS PER GAME (10000 GAMES): "+(totalRounds/10000));
    }
}
