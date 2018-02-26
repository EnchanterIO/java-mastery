package Ch10_Sorting_Searching;

public class BinarySearch {
    private static boolean contains(int[] sortedArray, int needle) {
        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (needle == sortedArray[mid]) {
                return true;
            } else if (needle < sortedArray[mid]) {
                high = --mid;
            } else if (needle > sortedArray[mid]) {
                low = ++mid;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] sortedArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println(
            contains(sortedArray, Integer.valueOf(args[0]))
        );
    }
}
