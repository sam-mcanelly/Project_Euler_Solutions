
import java.util.Arrays;

/**
 *
 * @author Sam McAnelly
 * Project Euler Problem 50
 * Calculate the largest prime under one million that is the sum of consecutive primes
 *
 */
public class PrimeSum {
    
    private static int count;
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        System.out.println("The largest prime less than one million that is the sum of consecutive primes is: " + calculate(1000000));
        System.out.println("Number of Primes: " + count);
        System.out.println(System.currentTimeMillis() - start + "ms");
    }
    
    public static long calculate(int ceil) {
        long ans = 0;
        count = 0;
        long[] primes = generatePrimes(ceil);
        long[] sums = generateSums(primes);
        
        for (int i = count; i < sums.length; i++){
            for (int j = i - count + 1; j >= 0; j--){
                if (sums[i] - sums[j] > ceil)
                    break;
                else if (Arrays.binarySearch(primes, sums[i] - sums[j]) > -1){
                    count = i - j;
                    ans = sums[i] - sums[j];
                }
            }
        }
        return ans;
    }
    
    private static long[] generatePrimes(int max) {
    boolean[] isComp = new boolean[max + 1];
    for (int i = 2; i * i <= max; i++) {
        if (!isComp [i]) {
            for (int j = i; i * j <= max; j++) {
                isComp [i*j] = true;
            }
        }
    }
    int numPrimes = 0;
    for (int i = 2; i <= max; i++) {
        if (!isComp [i]) numPrimes++;
    }
    long[] primes = new long[numPrimes];
    int index = 0;
    for (int i = 2; i <= max; i++) {
        if (!isComp [i]) primes [index++] = i;
    }
    return primes;
    
}

    
    public static long[] generateSums(long[] p){
        long[] ans = new long[p.length + 1];
        ans[0] = 0;
        for (int i = 0; i < p.length; i++){
            ans[i + 1] = p[i] + ans[i];
        }
        return ans;
    }
    
}
