package rlv.dcit25.recursion;

import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(factorial(in.nextInt()));
    }
    
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
