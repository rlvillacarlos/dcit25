package rlv.dcit25.algo;

/**
 *
 * @author Russel Villacarlos
 */
public class RecursiveBinarySearch {

    public static boolean search(Integer A[], Integer x) {
        return search(A, 0, A.length - 1, x);
    }

    private static boolean search(Integer A[], int lo, int hi, Integer x) {
        if (lo > hi) {                          //If no element left
            return false;
        }

        int mid = lo + (hi - lo) / 2;

        if (A[mid].compareTo(x) == 0) {         //If 𝑚𝑖𝑑 == 𝑥
            return true;
        } else if (A[mid].compareTo(x) > 0) {   //If 𝑚𝑖𝑑 > 𝑥
            return search(A, lo, mid - 1, x);
        } else {				//If 𝑚𝑖𝑑 < 𝑥
            return search(A, mid + 1, hi, x);
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Integer A[] = {5, 9, 11, 17, 21, 81};

        System.out.println(RecursiveBinarySearch.search(A, 21));

        System.out.println(RecursiveBinarySearch.search(A, 10));
    }
}
