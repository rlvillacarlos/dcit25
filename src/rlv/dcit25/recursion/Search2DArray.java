package rlv.dcit25.recursion;

/**
 *
 * @author Acer
 */
public class Search2DArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arr[][] = {{7,4,1},
                        {6,8,9},
                        {2,14,5}};
        
        System.out.println(find(arr,14));
    }
    
    static boolean find(int a[][],int x){
        return find (a,0,0,x);
    }
    
     static boolean find(int a[][], int r, int c, int x){
        if (r == a.length){
            return false;
        }
        
        if(a[r][c] == x){
            return true;
        }
        
        if(c == a[r].length - 1){
            return find(a,r + 1, 0, x);
        }
        
        return find(a, r, c + 1, x);
        
    }
    
}
