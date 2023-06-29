package rlv.dcit25.recursion;

/**
 *
 * @author Acer
 */
public class Max {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arr[] = {7,4,1,6,8,9};
        
        System.out.println(max(arr));
    }
    
    public static int max(int[] a) {
        return max(a, 0);
    }

    public static int max(int[] a, int start) {
        if (start == a.length - 1) {
            return a[start];
        }
        return Math.max(a[start], max(a, start + 1));
    }

    
}
