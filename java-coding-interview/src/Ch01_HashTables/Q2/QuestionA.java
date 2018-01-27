package Ch01_HashTables.Q2;

import java.util.Hashtable;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class QuestionA {
    public static void main(String[] args) {
        System.out.println(isPermutation("xrpp", "rxpp"));
        System.out.println(isPermutation("xrpp", "rxp"));
        System.out.println(isPermutation("121", "211"));
        System.out.println(isPermutation("xrp", "lrp"));
    }

    private static boolean isPermutation(String haystack, String needle) {
        if (haystack.length() != needle.length()) {
            return false;
        }

        Hashtable<Character, Integer> haystackCharacters = countCharactersOccurrence(haystack);
        Hashtable<Character, Integer> needleCharacters = countCharactersOccurrence(needle);

        for (int i = 0; i < needle.length(); i++) {
            Character currentCharacter = needle.charAt(i);

            if (!haystackCharacters.containsKey(currentCharacter)) {
                return false;
            }

            if (!haystackCharacters.get(currentCharacter).equals(needleCharacters.get(currentCharacter))) {
                return false;
            }
        }

        return true;
    }

    private static Hashtable<Character, Integer> countCharactersOccurrence(String word) {
        Hashtable<Character, Integer> wordCharacters = new Hashtable<>();

        for (int i = 0; i < word.length(); i++) {
            Character currentChar = word.charAt(i);
            int occurrenceCount = 1;

            if (wordCharacters.containsKey(currentChar)) {
                occurrenceCount = wordCharacters.get(currentChar);
                ++occurrenceCount;
            }

            wordCharacters.put(currentChar, occurrenceCount);
        }

        return wordCharacters;
    }
}
