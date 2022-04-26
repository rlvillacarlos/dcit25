package rlv.dcit25.algo;

/**
 *
 * @author Russel Villacarlos
 */
public class CountingSort {

    public static void sort(Integer A[]) {
        int max = A[0];
        
        for(int i = 1; i < A.length; i++){
            if(A[i].compareTo(max) > 0){
                max = A[i];
            }
        }
        
        sort(A,max + 1);
    }

    
    public static void sort(Integer A[], int k) {
        int C[] = new int[k];
        int B[] = new int[A.length];
        
        for (int i = 0; i < C.length; i++) {
            C[i] = 0;
        }
        for (int i = 0; i < A.length; i++) {
            C[A[i]]++;
            B[i] = A[i];
        }
        for (int i = 1; i < C.length; i++) {
            C[i] = C[i] + C[i - 1];
        }
        for (int i = B.length - 1; i >= 0; i--) {
            A[C[B[i]] - 1] = B[i];
            C[B[i]]--;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Integer A[] = {9, 11, 21, 5, 18, 17};
        
        for (Integer a : A) {
            System.out.print(a + " ");
        }

        System.out.println();

        CountingSort.sort(A);

        for (Integer a : A) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
