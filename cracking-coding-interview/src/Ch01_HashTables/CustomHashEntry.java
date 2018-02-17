package Ch01_HashTables;

public class CustomHashEntry {
    private String key;
    private int value;

    CustomHashEntry(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}
