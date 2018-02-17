package Ch01_HashTables;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sentence = new StringBuilder();
        String [] words = {"Java", "is", "awesome"};

        for (String word : words) {
            sentence.append(word);
            sentence.append(" ");
        }

        System.out.println(sentence.toString());
    }
}
