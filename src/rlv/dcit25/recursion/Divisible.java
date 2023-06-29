/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rlv.dcit25.recursion;

/**
 *
 * @author Acer
 */
public class Divisible {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arr[] = {7,24,1,6,8,9};
        printDivisible(arr, 3);
    }
    
    static void printDivisible(int a[], int d){
        printDivisible(a, 0, d);
    }
    
    static void printDivisible(int a[], int i, int d){
        if(i < a.length){
            if(a[i] % d == 0){
                System.out.println(a[i]);
            }
            printDivisible(a, i+1, d);
        }
        
    }
}
