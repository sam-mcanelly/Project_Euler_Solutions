
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Sam McAnelly
 * CWID: 11533007
 * Project Euler problem 3
 * Find the largest prime factor of 600851475143?
 */
public class PrimeFactorization {
    
    public static void main(String[] args){
        long number = 600851475143L;
        System.out.print("The largest prime factor of " + number + " is: ");
        System.out.println(largestPrimeFactor(number));
    }
    
    public static long largestPrimeFactor(long num){
        ArrayList<Integer> allFactors = new ArrayList<Integer>();
        for (int j = 2; j <= num; j++){
            while (num % j == 0){
                allFactors.add(j);
                num /= j;
            }
            
        }
        return Collections.max(allFactors);
    }
    
}
