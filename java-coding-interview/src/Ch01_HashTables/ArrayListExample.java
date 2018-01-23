package Ch01_HashTables;

import java.util.ArrayList;

public class ArrayListExample {
    private static ArrayList<String> mergeIntoArrayList(String[] words, String[] moreWords) {
        ArrayList<String> mergedOutput = new ArrayList<>();

        for (String w : words) {
            mergedOutput.add(w);
        }

        for (String w : moreWords) {
            mergedOutput.add(w);
        }

        return mergedOutput;
    }

    private static String[] mergeIntoArray(String[] words, String[] moreWords) {
        String[] mergedOutput = new String[words.length + moreWords.length];

        int mergedOutputIndex = 0;

        for (String word : words) {
            mergedOutput[mergedOutputIndex] = word;
            mergedOutputIndex++;
        }

        for (String word : moreWords) {
            mergedOutput[mergedOutputIndex] = word;
            mergedOutputIndex++;
        }

        return mergedOutput;
    }

    public static void main(String[] args) {
        String[] words = {"Today", "is"};
        String[] moreWords = {"Friday", "yey", "!"};

        mergeIntoArrayList(words, moreWords);
        mergeIntoArray(words, moreWords);
    }
}
