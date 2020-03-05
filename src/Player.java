import java.util.ArrayList;
import java.util.Collections;

public class Player {
    private int playerNum;
    private ArrayList<Card> stack;
    public Player(int num){
        playerNum = num;
        stack = new ArrayList<>();
    }
    public void addToStack(Card card){
        stack.add(card);
    }
    public void addToStack(ArrayList<Card> cards){
        for (int i = 0; i < cards.size(); i++){
            stack.add(cards.get(i));
        }
    }
    public void addToStack(Deck cards){
        for (int i = 0; i < cards.getNumCards(); i++){
            stack.add(cards.getCard(i));
        }
    }
    public Card getCard(int index){
        return stack.get(index);
    }
    public Card getTopCard(){
        return stack.get(0);
    }
    public ArrayList<Card> getStack(){
        return stack;
    }
    public void shuffleStack(){
        Collections.shuffle(stack);
    }
    public String toString(){
        String str = "Player "+playerNum+" stack: ";
        for (int i = 0; i < stack.size(); i++){
            str += stack.get(i).toString()+"| ";
        }
        return str;
    }
}
