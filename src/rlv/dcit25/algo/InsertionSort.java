package rlv.dcit25.algo;

/**
 *
 * @author Russel Villacarlos
 */
public class InsertionSort {
    
    public static void sort(Integer A[]) {
        for (int i = 1; i < A.length; i++) {
            Integer e = A[i];
            int j = i - 1;
            while (j >= 0 && A[j].compareTo(e) > 0){
                A[j+1] = A[j];
                j--;
            }
            A[j+1] = e;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Integer A[] = {9, 11, 21, 5, 18, 17};

        for (Integer a : A) {
            System.out.print(a + " ");
        }

        System.out.println();

        InsertionSort.sort(A);

        for (Integer a : A) {
            System.out.print(a + " ");
        }
        System.out.println("");

    }
}
