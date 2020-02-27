import java.util.*;
public class Purse {
    private ArrayList<Coin> coins;

    public Purse() {
        coins = new ArrayList();
    }

    // adds aCoin to the purse
    public void add(Coin aCoin) {
        coins.add(aCoin);
    }

    // returns total value of all coins in purse
    public double getTotal() {
        double total = 0;
        for (int i = 0; i < coins.size(); i++){
            total += coins.get(i).getValue();
        }
        return total;
    }

    // returns the number of coins in the Purse that matches aCoin
// (both myName & myValue)
    public int count(Coin aCoin) {
        int matched = 0;
        for (int i = 0; i < coins.size(); i++){
            if (coins.get(i).equals(aCoin)){
                matched++;
            }
        }
        return matched;
    }

// returns the name of the Coin in the Purse that has the smallest value
    public String findSmallest(){
        int minIndex = 0;
        for (int i = 1; i < coins.size(); i++){
            if (coins.get(i).getValue() < coins.get(minIndex).getValue()){
                minIndex = i;
            }
        }
        return coins.get(minIndex).getName();
    }
    public String toString(){
        String str = "";
        for (int i = 0; i < coins.size(); i++){
            str += coins.get(i).toString()+"\n";
        }
        return str;
    }
}
