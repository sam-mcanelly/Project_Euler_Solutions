
import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author Sam McAnelly
 * CWID: 11533007
 * Project Euler Problem 8
 * Largest product in a series
 */
public class AdjacentDigits {

    private static final String numSeries = "73167176531330624919225119674426574742355349194934" +
"96983520312774506326239578318016984801869478851843" +
"85861560789112949495459501737958331952853208805511" +
"12540698747158523863050715693290963295227443043557" +
"66896648950445244523161731856403098711121722383113" +
"62229893423380308135336276614282806444486645238749" +
"30358907296290491560440772390713810515859307960866" +
"70172427121883998797908792274921901699720888093776" +
"65727333001053367881220235421809751254540594752243" +
"52584907711670556013604839586446706324415722155397" +
"53697817977846174064955149290862569321978468622482" +
"83972241375657056057490261407972968652414535100474" +
"82166370484403199890008895243450658541227588666881" +
"16427171479924442928230863465674813919123162824586" +
"17866458359124566529476545682848912883142607690042" +
"24219022671055626321111109370544217506941658960408" +
"07198403850962455444362981230987879927244284909188" +
"84580156166097919133875499200524063689912560717606" +
"05886116467109405077541002256983155200055935729725" +
"71636269561882670428252483600823257530420752963450";
    
    private int largestSum = 0;
    private BigInteger largestProduct = BigInteger.valueOf(0);
    private int[] currentDigits;
    private int[] largestDigits;
    private char[] allDigits;
    private static int sizeOfSubSeries = 4;
    
    public static void main(String[] args){
        System.out.println("+---------------------+");
        System.out.println("+        Testing      +");
        System.out.println("+---------------------+");
        AdjacentDigits firstTest = new AdjacentDigits();
        firstTest.computeLargestSubSeries(numSeries, sizeOfSubSeries);
        if (firstTest.getLargestProduct().intValue() == 5832){
            System.out.println("+      Test Passed!   +");
            System.out.println("+---------------------+");
        } else {
            System.out.println("+      Test Failed!   +");
            System.out.println("+---------------------+");
        }
        System.out.println("\n");
        
        sizeOfSubSeries = 13;
        AdjacentDigits outputTest = new AdjacentDigits();
        
        outputTest.computeLargestSubSeries(numSeries, sizeOfSubSeries);
        System.out.print("The " + sizeOfSubSeries + " adjacent digits in 1000-digit series that have the greatest product are: ");
        for (int i = 0; i < outputTest.getLargestDigits().length; i++){
            if (i != outputTest.getLargestDigits().length - 1)
                System.out.print(outputTest.getLargestDigits()[i] + " * ");
            else
                System.out.print(outputTest.getLargestDigits()[i]);
        }
        System.out.print(" = ");
        System.out.println(outputTest.getLargestProduct());
        
    }
    
    public void computeLargestSubSeries(String series, int subSeriesSize) {
        
        largestDigits = new int[subSeriesSize];
        for (int i = 0; i < subSeriesSize; i++)
            largestDigits[i] = 0;
        allDigits  = series.toCharArray();
        currentDigits = new int[subSeriesSize];
        for (int i = 0; i < subSeriesSize; i++)
            currentDigits[i] = 0;
        
        
        
        for (int i = subSeriesSize - 1; i < allDigits.length; i++){
            for (int j = subSeriesSize - 1; j >= 0; j--){
                    if (((int)allDigits[i - j]) - 48 == 0){
                        i += subSeriesSize;
                        Arrays.fill(currentDigits, 0, currentDigits.length - 1, 0);
                        break;
                    }
                    currentDigits[subSeriesSize - 1 - j] = ((int)allDigits[i - j]) - 48;
            }
            if(computeSum(currentDigits) > largestSum) {
                largestSum = computeSum(currentDigits);
                largestProduct = computeProduct(currentDigits);
                this.setLargestDigits(currentDigits);
            }
        }
    }
    
    public BigInteger computeProduct(int[] digits) {
        BigInteger product = BigInteger.valueOf(1);
        for (int i = 0; i < digits.length; i++) {
            product = product.multiply(BigInteger.valueOf(digits[i]));
        }
        return product;
    }
    
   
    
    public int computeSum(int[] series){
        int sum = 0;
        for (int i: series){
            sum += i;
        }
        return sum;
    }
    
    private void setLargestSum(int sum){
        largestSum = sum;
    }
    
    private void setLargestDigits(int[] series){
        System.arraycopy(series, 0, largestDigits, 0, series.length);
    }
    
    public int[] getLargestDigits() {
        return largestDigits;
    }
    
    public int getLargestSum() {
        return largestSum;
    }
    
    public BigInteger getLargestProduct(){
        return largestProduct;
    }
}
