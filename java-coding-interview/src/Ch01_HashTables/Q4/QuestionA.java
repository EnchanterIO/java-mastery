package Ch01_HashTables.Q4;

import Ch01_HashTables.Common.CharacterOccurenceCounter;

import java.util.Hashtable;
import java.util.Set;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 */
public class QuestionA {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("tact coa"));
        System.out.println(isPalindromePermutation("tactt coa"));
    }

    /**
     * A palindrome can exists only in case the re-occurrence count of each character is even OR one character only is odd.
     *
     * Input: Tact Ccoa => 2x (t,a,c); 1x (o)
     * Palindrom: tac cat
     */
    private static boolean isPalindromePermutation(String word) {
        String wordWithoutSpaces = word.replaceAll("\\W", "");
        Hashtable<Character, Integer> wordChars = CharacterOccurenceCounter.count(wordWithoutSpaces);
        Set<Character> keys = wordChars.keySet();
        boolean foundOdd = false;

        for (Character key : keys) {
            if (wordChars.get(key) % 2 == 0) {
                continue;
            }

            // Already once found an odd char and now again which means it's not a valid palindrome
            if (foundOdd) {
                return false;
            }

            foundOdd = true;
        }

        return true;
    }
}
