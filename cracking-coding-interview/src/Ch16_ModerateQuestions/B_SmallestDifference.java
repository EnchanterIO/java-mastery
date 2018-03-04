package Ch16_ModerateQuestions;

import java.util.Arrays;

/**
 * Given two arrays of integers, compute the pair of values (one value in each array) with the smallest (non-negative) difference.
 *
 * Return the difference.
 */
public class B_SmallestDifference {
    /**
     * Takes O(A*B) time.
     */
    private static int findSmallestDiffUsingBruteForce(int[] array1, int[] array2) {
        if (array1.length == 0 || array2.length == 0) {
            return -1;
        }

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                int tempDiff = Math.abs(array1[i] - array2[j]);
                if (tempDiff < minDiff) {
                    minDiff = tempDiff;
                }
            }
        }

        return minDiff;
    }

    /**
     * If we instead, sort the arrays and then just move the pointer
     * in an array that won't obviously make the difference larger.
     *
     * The algorithm takes O(A log A + B log B) time to sort and O (A + B) time
     * to find the minimum difference.
     *
     * Therefore, the overall runtime is O(A log A + B log B).
     */
    public static int findSmallestDiff(int[] array1, int[] array2) {
        if (array1.length == 0 || array2.length == 0) {
            return -1;
        }

        Arrays.sort(array1);
        Arrays.sort(array2);

        int minDiff = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;

        while (a < array1.length && b < array2.length) {
            int tempDiff = Math.abs(array1[a] - array2[b]);

            if (tempDiff < minDiff) {
                minDiff = tempDiff;
            }

            if (array1[a] < array2[b]) {
                a++;
            } else {
                b++;
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] array1 = new int[] {1,3,15,11,2};
        int[] array2 = new int[] {23,127,235,19,8};

        System.out.println(
            "Find smallest diff using brute force: "
            + findSmallestDiffUsingBruteForce(array1, array2)
        );

        System.out.println(
            "Find smallest diff using optimized algorithm: "
            + findSmallestDiff(array1, array2)
        );
    }
}
