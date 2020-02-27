public class Player {
    private int playerNum;
    private Deck hand;
    public Player(int num){
        playerNum = num;
        hand = new Deck();
    }
    public String toString(){
        return hand.toString();
    }
}
