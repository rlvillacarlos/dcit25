package rlv.dcit25.algo;

/**
 *
 * @author Acer
 */
public class RootFinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(squareRoot(32, 0.0001));

    }

    public static double squareRoot(double n, double e){
        double lo = 0, hi = n;
        
        if (n < 1){
            lo = n;
            hi = 1;
        }
        
        while (true){
            double mid = lo + (hi-lo)/2;
            double m = (mid*mid) ;

            if(Math.abs(m - n) <= e){
                return mid;
            }else if(m > n){
                hi = mid;
            }else{
                lo = mid;
            }
        }
    }
}
