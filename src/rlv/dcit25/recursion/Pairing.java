package rlv.dcit25.recursion;

/**
 *
 * @author Acer
 */
public class Pairing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        printPairs("abcde".toCharArray());
    }
    
    static void printPairs(char a[]){
        printPairs(a, 0, 1);
    }
    
    static void printPairs(char a[], int x, int y){
        if(x < a.length - 1){
            System.out.println(a[x] + "" + a[y]);
            
            if(y == a.length - 1){
                printPairs(a,x + 1, x + 2);
            }else{
                printPairs(a,x, y + 1);
            }
        }
    }
    
}
