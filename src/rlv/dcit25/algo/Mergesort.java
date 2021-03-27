package rlv.dcit25.algo;

/**
 *
 * @author Russel Villacarlos
 */
public class Mergesort {

    static void sort(Integer A[]) {
        Integer T[] = new Integer[A.length];
        sort(A, T, 0, A.length - 1);
    }

    static void sort(Integer A[], Integer T[], int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            sort(A, T, lo, mid);        //Mergesort the left subarray
            sort(A, T, mid + 1, hi);    //Mergesort the right subarray
            merge(A, T, lo, mid, hi);   //Merge the left and the right subarrays
        }
    }

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
        Integer A[] = {6, 1, 3, 2, 9, 8};

        for (Integer x : A) {
            System.out.print(x + " ");
        }
        System.out.println();

        Mergesort.sort(A);

        for (Integer x : A) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
