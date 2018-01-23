package Ch01_HashTables;

import java.util.LinkedList;

public class CustomHashTable {
    private final static int TABLE_DEFAULT_SIZE = 16;
    private LinkedList<CustomHashEntry>[] table;

    CustomHashTable() {
        table = new LinkedList[TABLE_DEFAULT_SIZE];
    }

    public void put(String key, int value) {
        if (key == null) {
            throw new IllegalArgumentException("Key can't be null!");
        }

        int index = findIndex(key);
        LinkedList<CustomHashEntry> entry = table[index];

        if (entry == null) {
            doPut(key, value, index);

            return;
        }

        // As the HashTable index can be shared across different keys, it's necessary to check entry keys
        for (CustomHashEntry item : entry) {
            if (item.getKey().equals(key)) {
                entry.remove(item);
                entry.add(new CustomHashEntry(key, value));

                return;
            }
        }

        // the entry under index exists but doesn't contain this key yet
        doPut(key, value, index);
    }

    private void doPut(String key, int value, int index) {
        LinkedList<CustomHashEntry> entry = new LinkedList<>();
        CustomHashEntry newItem = new CustomHashEntry(key, value);

        entry.add(newItem);

        table[index] = entry;
    }

    private int findIndex(String key) {
        return calculateHashCode(key) % TABLE_DEFAULT_SIZE;
    }

    private int calculateHashCode(String key) {
        int mod = key.hashCode() % TABLE_DEFAULT_SIZE;

        return mod < 0 ? mod + TABLE_DEFAULT_SIZE : mod;
    }

    public Integer get(String key) {
        LinkedList<CustomHashEntry> entry = table[findIndex(key)];

        if (entry == null) {
            return null;
        }

        for (CustomHashEntry item : entry) {
            if (item.getKey().equals(key)) {
                return item.getValue();
            }
        }

        return null;
    }
}
