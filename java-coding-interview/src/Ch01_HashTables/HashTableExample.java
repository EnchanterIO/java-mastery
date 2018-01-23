package Ch01_HashTables;

import java.util.Hashtable;

public class HashTableExample {
    public static void main(String[] args) {
        Hashtable<String, Integer> UsersBalances = new Hashtable<>();
        UsersBalances.put("Lukas", 125);
        UsersBalances.put("Axel", 300);

        System.out.printf(
                "Axel balance is: %d.",
                UsersBalances.get("Axel")
        );
    }
}
