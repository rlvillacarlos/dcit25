package rlv.dcit25.algo;

/**
 *
 * @author Russel Villacarlos
 */
public class SelectionSort {
    
    public static void sort(Integer A[]) {
        for (int i = 0; i < A.length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j].compareTo(A[k]) < 0) {
                    k = j;
                }
            }
            Integer tmp = A[i];
            A[i] = A[k];
            A[k] = tmp;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Integer A[] = {9, 11, 21, 5, 18, 17};

        for (Integer a : A) {
            System.out.print(a + " ");
        }

        System.out.println();

        SelectionSort.sort(A);

        for (Integer a : A) {
            System.out.print(a + " ");
        }

    }
}
