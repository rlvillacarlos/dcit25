package rlv.dcit25.lab;

import java.util.Scanner;

/**
 *
 * @author Russel L. Villacarlos
 */
public class Exercise1 {
    
    static class Element{
        Integer value;
        Integer group;

        public Element(Integer value, Integer group) {
            this.value = value;
            this.group = group;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int g = in.nextInt(), s = in.nextInt();
        int group_sizes[] = new int[g], total_size = 0;
        
        for(int i = 0; i < g; i++){
            group_sizes[i] = in.nextInt();
            total_size += group_sizes[i];
        }
        
        Element a[] = new Element[total_size];
        
        int k = 0;
        for(int i = 0; i < g; i++){
            for(int j = 0; j < group_sizes[i]; j++){
                a[k] = new Element(in.nextInt(), i + 1);
                k++;
            }
        }
        
        sort(a);

        Integer searches[] = new Integer[s];        
        for(int i = 0; i < s; i++){
            searches[i] = in.nextInt();            
        }
        
        for(Integer x: searches){
            System.out.println(search(a, x));
        }
        
    }
        
    static void sort(Element a[]){
        for (int i = 0; i < a.length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].value.compareTo(a[k].value) < 0) {
                    k = j;
                }
            }
            Element tmp = a[i];
            a[i] = a[k];
            a[k] = tmp;
        }
    }
    
    static int search(Element A[], Integer x) {
        int lo = 0, hi = A.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (A[mid].value.compareTo(x) == 0) {
                return A[mid].group;
            } else if (A[mid].value.compareTo(x) > 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
    
}
