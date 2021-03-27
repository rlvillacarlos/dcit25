package rlv.dcit25.algo;

/**
 *
 * @author Russel Villacarlos
 */
public class LinearSearch {
    
    public static boolean search(Integer A[], Integer x) {
        for (int i = 0; i < A.length; i++) {
            if (A[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Integer A[] = {9, 11, 21, 5, 18, 17};

        System.out.println(LinearSearch.search(A, 21));

        System.out.println(LinearSearch.search(A, 10));
    }
}
