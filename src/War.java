public class War {
    public static void main(String[] args) {
        Deck fullDeck = new Deck();
        fullDeck.makeFull();
        System.out.println("Full deck of cards:");
        System.out.println(fullDeck);

        Deck halfDeck = new Deck();
        fullDeck.dealHalf(halfDeck);

        Player p1 = new Player(1);
        Player p2 = new Player(2);
        fullDeck.dealHalf(p1.stack);
        p2.stack = fullDeck;

        System.out.println("Player 1 stack:");
        System.out.println(p1.stack);
        System.out.println("Player 2 stack:");
        System.out.println(p2.stack);

        boolean run = true;
        while (p1.getStack().size() > 0){

        }
    }
}
