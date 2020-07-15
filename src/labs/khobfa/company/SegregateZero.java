package labs.khobfa.company;

import java.util.Arrays;

public class SegregateZero {

    private static void segregate(int[] A) {
        int zeros = 0;
        int n = A.length;
        for (int j : A) {
            if (j == 0)
                zeros++;
        }

        for (int i = 0; i < n; i++) {
            if (i < zeros)
                A[i] = 0;
            else
                A[i] = 1;
        }
    }

    private static void segregate0And1(int[] A) {
        int type0 = 0;
        int type1 = A.length - 1;

        while (type0 < type1) {
            if (A[type0] == 0) {
                swap(type0, type1, A);
                type1--;
            } else
                type0++;
        }
    }

    private static void segregate01(int[] A) {
        int left = 0;
        int right = A.length - 1;

        while (left < right) {
            while (A[left] == 0 && left < right)
                left++;

            while (A[right] == 1 && right > left)
                right--;

            if (left < right) {
                A[right] = 1;
                A[left] = 0;
                left++;
                right--;
            }
        }
    }

    private static void swap(int type0, int type1, int[] A) {
        A[type1] = A[type1] + A[type0];
        A[type0] = A[type1] - A[type0];
        A[type1] = A[type1] - A[type0];
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 0, 1, 0, 1};
        System.out.println(Arrays.toString(A));
        segregate01(A);
        System.out.println(Arrays.toString(A));
    }
}
