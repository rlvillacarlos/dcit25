package rlv.dcit25.recursion;

/**
 *
 * @author Acer
 */
public class MaxTailRecursive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arr[] = {7,4,1,6,8,9};
        
        System.out.println(max(arr));
    }
 
    public static int max(int[] a) {
        return max(a, a[0], 1);
    }

    public static int max(int[] a, int tmpMax, int start) {
        if (start == a.length) {
            return tmpMax;
        }
        if(a[start] > tmpMax){
            return max(a, a[start], start + 1);
        }
        
        return max(a, tmpMax, start + 1);
    }
}
