package Ch01_HashTables.Q2;

import Ch01_HashTables.Common.CharacterOccurenceCounter;

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

        Hashtable<Character, Integer> haystackCharacters = CharacterOccurenceCounter.count(haystack);
        Hashtable<Character, Integer> needleCharacters = CharacterOccurenceCounter.count(needle);

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
}
