package rlv.dcit25.algo;

/**
 *
 * @author Russel Villacarlos
 */
public class BinarySearch {
    
    public static boolean search(Integer A[], Integer x) {
        int lo = 0, hi = A.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (A[mid].compareTo(x) == 0) {         //If 𝑚𝑖𝑑 == 𝑥
                return true;
            } else if (A[mid].compareTo(x) > 0) {   //If 𝑚𝑖𝑑 > 𝑥
                hi = mid - 1;
            } else {                                //If 𝑚𝑖𝑑 < 𝑥
                lo = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Integer A[] = {5, 9, 11, 17, 21, 81};

        System.out.println(BinarySearch.search(A, 21));

        System.out.println(BinarySearch.search(A, 10));
    }
}
