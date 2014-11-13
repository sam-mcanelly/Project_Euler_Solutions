

/**
 *
 * @author Sam McAnelly
 * CWID: 11533007
 * Project Euler Problem 5
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class SmallestMultiple {
	
    public static void main(String[] args){
    	int smallestNum = 0;
    	int incrementer = 60;
    	boolean found = false;
    	
    	// Search algorithm
    	// Only the last 10 need to be checked
    	long total;
    	long end;
    	long start = System.currentTimeMillis();
    	while (!found){
    		for (int i = 20; i > 10; i--){
    			if (incrementer % i != 0){
    				incrementer += 1;
    				break;
    			} else if (incrementer % i == 0 && i == 11){
    				found = true;
    			}
    		}
    	}
    	end = System.currentTimeMillis();
    	total = end - start;
    	
    	System.out.println("The smallest positive number evenly divisible by 1...20 is: " + incrementer);
    	System.out.println(total + "ms");
    	
    }
}
