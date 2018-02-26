package Ch10_Sorting_Searching;

import java.util.Arrays;

public class BubbleSort {
    private static int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];

                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] unsortedArray = new int[] {2, 6, 1, 3, 8, 7, 7, 9};

        System.out.println(Arrays.toString(sort(unsortedArray)));
    }
}
