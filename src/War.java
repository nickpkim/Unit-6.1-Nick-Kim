public class War {
    public static void main(String[] args) {
        Deck fullDeck = new Deck();
        for (int i = 2; i <= 14; i++){
            Deck.add(new Card(i, ♠));
        }
    }
}
