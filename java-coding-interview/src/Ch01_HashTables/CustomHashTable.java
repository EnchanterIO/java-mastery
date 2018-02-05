package Ch01_HashTables;

import java.util.LinkedList;

public class CustomHashTable {
    private LinkedList<CustomHashEntry>[] table;
    private int tableSize = 6;
    private int entriesCount = 0;

    CustomHashTable() {
        table = new LinkedList[tableSize];
    }

    public void put(String key, int value) {
        if (key == null) {
            throw new IllegalArgumentException("Key can't be null!");
        }

        if (shouldResize()) {
            resize();
            put(key, value);
        }

        int index = findIndex(key);
        LinkedList<CustomHashEntry> entry = table[index];

        if (entry == null) {
            doPut(key, value, index);

            return;
        }

        // As the HashTable index can be shared across different keys
        // it's necessary to check entry keys
        for (CustomHashEntry item : entry) {
            if (item.getKey().equals(key)) {
                // Update existing key with the new value
                entry.remove(item);
                entry.add(new CustomHashEntry(key, value));

                return;
            }
        }

        // the entry under index exists but doesn't contain this key yet
        // add it
        entry.add(new CustomHashEntry(key, value));
        increaseTableSize();
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

    public int size() {
        return entriesCount;
    }

    private void doPut(String key, int value, int index) {
        LinkedList<CustomHashEntry> entry = new LinkedList<>();
        CustomHashEntry newItem = new CustomHashEntry(key, value);

        entry.add(newItem);

        table[index] = entry;
        increaseTableSize();
    }

    private void increaseTableSize() {
        entriesCount++;
    }

    private int findIndex(String key) {
        return calculateHashCode(key) % tableSize;
    }

    private int calculateHashCode(String key) {
        int mod = key.hashCode() % tableSize;

        return mod < 0 ? mod + tableSize : mod;
    }

    /**
     * Keeps the load factor below 50%.
     *
     * @return boolean
     */
    private boolean shouldResize() {
        return tableSize != 0 && entriesCount >= tableSize / 2;
    }

    private void resize() {
        LinkedList<CustomHashEntry>[] tableCopy = table;
        tableSize = tableSize * 2;
        table = new LinkedList[tableSize];
        entriesCount = 0;

        for (LinkedList<CustomHashEntry> entries : tableCopy) {
            if (entries == null) {
                continue;
            }

            for (CustomHashEntry entry : entries) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }
}
