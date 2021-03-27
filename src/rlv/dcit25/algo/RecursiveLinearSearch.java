package rlv.dcit25.algo;

/**
 *
 * @author Russel Villacarlos
 */
public class RecursiveLinearSearch {
    public static boolean search(Integer A[], Integer x) {
        return search(A, 0, x);
    }

    private static boolean search(Integer A[], int i, Integer x) {

        if (A.length == i) {            //If no element left
            return false;
        }

        if (A[i].compareTo(x) == 0) {	//If 𝑚𝑖𝑑 == 𝑥
            return true;
        } else {
            return search(A, i + 1, x);
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Integer A[] = {9, 11, 21, 5, 18, 17};

        System.out.println(RecursiveLinearSearch.search(A, 21));

        System.out.println(RecursiveLinearSearch.search(A, 10));
    }
}
