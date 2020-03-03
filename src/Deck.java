import java.util.ArrayList;
public class Deck {
    private ArrayList<Card> cards;
    public Deck(){
        cards = new ArrayList();
    }
    public void makeFull(){
        for (int suit = 1; suit <= 4; suit++){
            for (int value = 2; value <= 14; value++){
                cards.add(new Card(value, suit));
            }
        }
    }
    public void dealHalf(ArrayList<Card> half){
        for (int i = 51; i > 25; i--){
            int index = (int)(Math.random()*i);
            half.add(cards.get(index));
            cards.remove(index);
        }
    }
    public void add(Card card){
        cards.add(card);
    }
    public int getNumCards(){
        return cards.size();
    }
    public Card getCard(int index){
        return cards.get(index);
    }
    public String toString(){
        String str = "";
        for (int i = 0; i < cards.size(); i++){
            str += cards.get(i).toString()+"| ";
        }
        return str;
    }
}
