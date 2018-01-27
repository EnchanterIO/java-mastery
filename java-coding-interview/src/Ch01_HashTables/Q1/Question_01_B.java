package Ch01_HashTables.Q1;

/**
 * Implement an algorithm to determine if a string has all unique characters WITHOUT using a helper
 * data structure like a HashTable.
 */
public class Question_01_B {
    public static boolean hasUniqueChars(String word) {
        if (!word.matches("[A-Za-z0-9]+")) {
            throw new IllegalArgumentException(
                String.format("%s: Word too long. Only alpha numeric chars.", word)
            );
        }

        boolean[] wordCharacters = new boolean[128];

        for (int i = 0; i < word.length(); i++) {
            Character currentChar = word.charAt(i);

            if (wordCharacters[Character.getNumericValue(currentChar)]) {
                return false;
            }

            wordCharacters[currentChar] = true;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "Lukáš", "112"};

        for (String word : words) {
            try {
                System.out.printf("%s: %s", word, hasUniqueChars(word));
                System.out.println();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        }
    }
}
