package Ch16_ModerateQuestions;

/**
 * Design a method to find the frequency of occurrences of any
 * given word in a book.
 */
public class A_WordFrequency {
    private static int getFrequency(String rawBook, String rawNeedle) {
        String[] book = rawBook.split("\\W");
        String needle = rawNeedle.trim().toLowerCase();
        int needleFrequency = 0;

        for (String word : book) {
            if (word.trim().toLowerCase().equals(needle)) {
                needleFrequency++;
            }
        }

        return needleFrequency;
    }

    public static void main(String[] args) {
        System.out.println(
            getFrequency("This interview questions are are useless.", "are")
        );
    }
}
