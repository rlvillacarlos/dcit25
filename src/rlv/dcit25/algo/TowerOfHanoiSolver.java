package rlv.dcit25.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class TowerOfHanoiSolver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Number of disk: ");
        int disks = in.nextInt();
        in.nextLine();
        
        
        List<Character> rods = new ArrayList(List.of('A','B','C'));
        System.out.printf("Source rod (%s): ", rods.toString().replaceAll("\\[|\\]", ""));
        char source = in.next().toUpperCase().charAt(0);

        if(!rods.contains(source)){
            System.exit(0);
        }
        
        rods.remove((Character)source);
        
        System.out.printf("Target rod (%s): ", rods.toString().replaceAll("\\[|\\]", ""));
        
        char target = in.next().toUpperCase().charAt(0);

        if(!rods.contains(target)){
            System.exit(0);
        }
        
        rods.remove((Character)target);
        System.out.println("Moves:");
        System.out.println("\t" + moves(disks, source, rods.get(0), target).replaceAll("\n", "\n\t"));
    }
    
    static String moves(int n, char s, char e, char t){
        if (n == 1) {
            return "Transfer disk 1 from " + s + " to " + t;
        }
        
        return moves(n - 1, s, t, e)
                + "\nTransfer disk " + n + " from " + s + " to " + t + "\n"
                + moves(n - 1, e, s, t);
    }
}
