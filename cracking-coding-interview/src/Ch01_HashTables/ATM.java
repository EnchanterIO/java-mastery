package Ch01_HashTables;

import java.text.DecimalFormat;

public class ATM {
    /**
     * Given set of coins, as a classic atm, print all the money you would returned to the client with
     * a goal to use the least amount of coins/bills possible.
     */
    private static void printChange(double amount, double[] coins) {
        int[] change = new int[coins.length];

        for (int i = 0; i < coins.length; i++) {
            // Starting with biggest coin how many 1$ can I max use?
            while (amount >= coins[i]) {
                change[i]++;

                amount -= coins[i];
                // Because Java is nuts https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
                DecimalFormat amountFormat = new DecimalFormat("#.##");

                amount = Double.valueOf(amountFormat.format(amount));
            }

            System.out.println("Returns: " + change[i] + "x coin: " + coins[i]);
        }
    }

    public static void main(String[] args) {
        double[] coins = {1.0, 0.5, 0.2, 0.1, 0.01};

        printChange(6.26, coins);
    }
}
