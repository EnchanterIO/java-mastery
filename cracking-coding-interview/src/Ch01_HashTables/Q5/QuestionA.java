package Ch01_HashTables.Q5;

import Ch01_HashTables.Common.CharacterOccurenceCounter;

import java.util.Hashtable;
import java.util.Set;

/**
 * There are three types of edits that can be performed on strings: insert, remove, replace a character.
 *
 * Given 2 strings, write a function to check if they are 1 or 0 edits away.
 *
 * Example:
 *     pale, ple -> true
 *     pales, pale -> true
 *     pale, bale -> true
 *     pale, bake -> false
 */
public class QuestionA {
    public static void main(String[] args) {
        System.out.println("Test passed: " + (true == isEditable("pale", "ple")));
        System.out.println("Test passed: " + (true == isEditable("pale", "vale")));
        System.out.println("Test passed: " + (false == isEditable("pala", "vall")));
        System.out.println("Test passed: " + (true == isEditable("pales", "pale")));
        System.out.println("Test passed: " + (false == isEditable("palee", "paless")));
        System.out.println("Test passed: " + (true == isEditable("palles", "pales")));
        System.out.println("Test passed: " + (false == isEditable("pallles", "pales")));
        System.out.println("Test passed: " + (false == isEditable("pale", "bake")));
    }

    private static boolean isEditable(String haystack, String needle) {
        int charsDifferenceCount = Math.abs(haystack.length() - needle.length());

        // words have to be the same or with difference of 1 length
        if (charsDifferenceCount > 1) {
            return false;
        }

        return isOneEditAway(haystack, needle);
    }

    private static boolean isOneEditAway(String haystack, String needle) {
        Hashtable<Character, Integer> haystackChars = CharacterOccurenceCounter.count(haystack);
        Hashtable<Character, Integer> needleChars = CharacterOccurenceCounter.count(needle);

        boolean wasEditUsed = false;

        Set<Character> needleCharsKeys = needleChars.keySet();
        for (Character key : needleCharsKeys) {
            // Each needle char must be in the haystack and has the same occurrence number
            // if it's not an EDIT operation can be used but only ONCE
            if (haystackChars.containsKey(key) && (haystackChars.get(key).equals(needleChars.get(key)))) {
                continue;
            }

            if (wasEditUsed) {
                return false;
            }

            wasEditUsed = true;
        }

        return true;
    }
}
