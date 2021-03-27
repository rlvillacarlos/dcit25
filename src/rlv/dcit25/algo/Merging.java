package rlv.dcit25.algo;

/**
 *
 * @author Russel Villacarlos
 */
public class Merging {
    
    static void merge(Integer A[], Integer T[], int lo, int i, int hi) {
        int l = lo, r = i + 1;
        for (int j = lo; j <= hi; j++) {
            if (l > i) {                            //The left subarray is consumed
                T[j] = A[r];
                r++;
            } else if (r > hi) {                    //The right subarray is consumed
                T[j] = A[l];
                l++;
            } else if (A[l].compareTo(A[r]) < 0) {  //The element from the left is smaller
                T[j] = A[l];
                l++;
            } else {                                //The element from the right is smaller
                T[j] = A[r];
                r++;
            }
        }
        for (int j = lo; j <= hi; j++) {
            A[j] = T[j];
        }
    }
    
    public static void main(String[] args) throws java.lang.Exception {
        Integer A[] = {1, 7, 8, 10, 3, 9, 10, 15, 21};
        Integer T[] = new Integer[A.length];

        for (Integer x : A) {
            System.out.print(x + " ");
        }
        System.out.println();

        Merging.merge(A, T, 0, 3, A.length - 1);

        for (Integer x : A) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
