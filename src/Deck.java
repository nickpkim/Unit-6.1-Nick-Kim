import java.util.ArrayList;
public class Deck {
    private ArrayList<Card> cards;
    public Deck(){
        cards = new ArrayList();
    }
    public void add(Card card){
        cards.add(card);
    }
    public String toString(){
        String str = "";
        for (int i = 0; i < cards.size(); i++){
            str += cards.get(i).toString()+"| ";
        }
        return str;
    }
}
