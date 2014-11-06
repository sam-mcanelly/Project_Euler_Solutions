
import java.math.BigInteger;

/**
 *
 * @author Sam McAnelly
 * CWID: 11533007
 * Project Euler Problem 6
 * Sum square difference
 */
public class SumSquareDifference {
    public static void main(String[] args){
        System.out.println("Testing...");
        if (squareOfSums(10) - sumOfSquares(10) == 2640)
            System.out.println("Test Passed!");
        else
            System.out.println("Test Failed!");

        System.out.println("\n");
        long answer = squareOfSums(100) - sumOfSquares(100);
        System.out.println("The difference between the square of the sums and the sum of the squares of the first 100 natural numbers is: ");
        System.out.println(answer);
    }
    
    public static long sumOfSquares(int totalNums){
        long sum = 0l;
        if (totalNums < 1){
            return 0l;
        }
        for(int i = 1; i <= totalNums; i++){
            sum += Math.pow(i, 2);
        }
        return sum;
    }
    
    public static long squareOfSums(int totalNums){
        long square = 0;
        for(int i = 1; i <= totalNums; i++){
            square += i;
        }
        return square * square;
    }
}
