public class Player {
    private int playerNum;
    private Deck stack;
    public Player(int num){
        playerNum = num;
        stack = new Deck();
    }
    public Deck getStack(){
        return stack;
    }
    public String toString(){
        return stack.toString();
    }
}
