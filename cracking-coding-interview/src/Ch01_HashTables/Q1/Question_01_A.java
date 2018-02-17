package Ch01_HashTables.Q1;

import java.util.Hashtable;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 */
public class Question_01_A {
    public static boolean hasUniqueChars(String word) {
        Hashtable<Integer, Character> wordCharacters = new Hashtable<>();

        for (int i = 0; i < word.length(); i++) {
            Character currentChar = word.charAt(i);

            if (wordCharacters.contains(currentChar)) {
                return false;
            }

            wordCharacters.put(i, currentChar);
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "112"};

        for (String word : words) {
            System.out.println(word + ": " + hasUniqueChars(word));
        }
    }
}
