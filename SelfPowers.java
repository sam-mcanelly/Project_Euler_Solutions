
/**
 *
 * @author Sam McAnelly
 * CWID: 11533007
 * Project Euler problem 48
 * Find the last ten digits of the series 1^1 + 2^2 + 3^3 +4^4 ... 1000^1000
 */
public class SelfPowers {
    
    
    public static void main(String[] args) {
        long endTime;
        long startTime = System.currentTimeMillis();
        long solution = calculateSeries();
        endTime = System.currentTimeMillis();
        System.out.println(solution);
        System.out.println(endTime - startTime + "ms");
    }
    
    /**
     * Default calculateSeries method. Calls calculateSeries(10000000000l) to get 10 digits back
     * @return calculateSeries(10000000000l)
     */
    public static long calculateSeries() {
        //ensures that we get ten digits back
        return calculateSeries(10000000000l);
    }
    
    /**
     * Calculates the last ten digits of the power series n^n
     * @param mod determines the length of the last digits to return (10 in the default case)
     * @return ans - last ten digits of the n^n series from 1...1000
     */
    public static long calculateSeries (long mod) {
        long ans = 0;
        for (int j = 1; j <= 1000; j++){
            long tmp = j;
            for (int k = 1; k < j; k++) {
                tmp *= j;
                if (tmp >= (Long.MAX_VALUE / 1000)){
                    tmp %= mod;
                }
            }
            ans += tmp;
            ans %= mod;
        }
        return ans;
    }
}
