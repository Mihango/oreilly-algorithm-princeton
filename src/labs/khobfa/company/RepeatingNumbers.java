package labs.khobfa.company;

public class RepeatingNumbers {

    private static void printRepeating(int[] A) {
        int size = A.length - 1;
        int i;
        for (i = 0; i < size; i++) {
            if(A[Math.abs(A[i])] > 0) {
                A[Math.abs(A[i])] = -A[Math.abs(A[i])];
            }
            else
                System.out.println(Math.abs(A[i]) + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2,2}; //{4, 6, 4, 5, 2, 3, 1};
        printRepeating(arr);//, 5);
    }
}
