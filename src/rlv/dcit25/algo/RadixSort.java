package rlv.dcit25.algo;

/**
 *
 * @author Russel Villacarlos
 */
public class RadixSort {

    public static void sort(Integer A[], int radix) {
        int max = getMax(A);
        int passes = getMaxDigits(max, radix);
        int C[] = new int[radix];
        int B[] = new int[A.length];
        
        for(int p = 1; p <= passes; p++){
            
            for (int i = 0; i < C.length; i++) {
                C[i] = 0;
            }
            
            for (int i = 0; i < A.length; i++) {
                int d = getDigit(A[i], radix, p);
                C[d]++;
                B[i] = A[i];
            }
            
            for (int i = 1; i < C.length; i++) {
                C[i] = C[i] + C[i - 1];
            }
            
            for (int i = B.length - 1; i >= 0; i--) {
                int d = getDigit(B[i], radix, p);
                A[C[d] - 1] = B[i];
                C[d]--;
            }
        }        
    }

    

    private static int getDigit(int i, int radix, int position){
        int r = 0;
        
        for(int p = 1; p <= position ; p++){
            r = i % radix;
            i = i / radix;
        }

        return r;
    }
    
    private static int getMaxDigits(int i, int radix){
        int d = 1;
        
        while(true){
            i = i / radix;
            
            if(i == 0){
                break;
            }
            
            d++;
        }
        return d;
    }
    
    private static int getMax(Integer A[]){
        int max = A[0];
        
        for (int i = 1; i < A.length; i++){
            if(A[i].compareTo(max) > 0){
                max = A[i];
            }
        }
        
        return max;
    }
    
    public static void main(String[] args){
        Integer A[] = {9, 901, 321, 5109, 180, 17,2000};
        int max = getMax(A);

        for (Integer a : A) {
            System.out.print(a + " ");
        }

        System.out.println();

        RadixSort.sort(A, (int)Math.floor(Math.log(A.length)));

        for (Integer a : A) {
            System.out.print(a + " ");
        }

        System.out.println();
    }
}
