package rlv.dcit25.recursion;

import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class FactorialTailRecursive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(factorial(in.nextInt()));
    }
    
    public static int factorial(int n) {
        return factorial(n, 1);
    }
    
    public static int factorial(int n, int p) {
        if (n == 1) {
            return p;
        }
        return factorial(n - 1, n * p);
    }

}
