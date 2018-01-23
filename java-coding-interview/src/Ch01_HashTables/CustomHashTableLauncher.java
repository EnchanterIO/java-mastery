package Ch01_HashTables;

public class CustomHashTableLauncher {
    public static void main(String[] args) {
        CustomHashTable hashTable = new CustomHashTable();

        hashTable.put("Lukas", 10);
        hashTable.put("Lukas", 15);

        System.out.println(hashTable.get("Lukas"));
    }
}
