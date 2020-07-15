package labs.khobfa.company;

import java.util.Arrays;

public class SegregateEvenAndOdd {

    private static void segregate(int[] A) {
        int even = 0;
        int odd = A.length - 1;

        while (even < odd) {
            while (A[even] % 2 == 0 && even < odd)
                even++;

            while (A[odd] % 2 != 0 && even < odd)
                odd--;

            if(even < odd) {
                swap(odd, even, A);
                odd--;
                even++;
            }
        }
    }

    private static void swap(int i, int j, int[] A) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] A = new int[]{12, 34, 45, 9, 8, 90, 3};
        System.out.println(Arrays.toString(A));
        segregate(A);
        System.out.println(Arrays.toString(A));
    }
}
