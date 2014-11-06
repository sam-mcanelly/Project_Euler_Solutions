
/**
 *
 * @author Sam McAnelly
 * CWID: 11533007
 * Project Euler problem 2
 * Find the sum of the even fibonacci numbers that do not exceed four million
 */
public class EvenFib {
    
    public static void main(String[] args){
        System.out.println("The sum of even fibonacci numbers that do not exceed four million is: ");
        System.out.println(calculate(33));
    }
    
    public static int calculate(int n){
        int total = 0;
        if (n < 2)
            return n;
        int first = 0;
        int second = 1;
        int nth = 0;
        for(int i = 1; i < n; i++) {
            nth = first + second;
            first = second;
            second = nth;
            if (nth % 2 == 0){
                total += nth;
            }
        }
        return total;
    }
}
