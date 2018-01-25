package Ch01_HashTables;

public class CustomHashTableLauncher {
    public static void main(String[] args) {
        CustomHashTable hashTable = new CustomHashTable();

        hashTable.put("Lukas", 10);
        hashTable.put("Lukas", 15);
        hashTable.put("Marek", 1);
        hashTable.put("Armin", 2);
        hashTable.put("Tomas", 3);

        System.out.println(hashTable.get("Lukas"));
        System.out.println(hashTable.get("Marek"));
        System.out.println(hashTable.size());
    }
}
