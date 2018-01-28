package Ch01_HashTables.Common;

import java.util.Hashtable;

public class CharacterOccurenceCounter {
    public static Hashtable<Character, Integer> count(String word) {
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
