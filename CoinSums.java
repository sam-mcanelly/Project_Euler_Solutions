
/**
 * 
 * @author Sam McAnelly
 * CWID: 11533007
 * Project Euler Problem 31
 * Find the total number of possible ways to create 2 pounds with coins
 *
 */

public class CoinSums {
	private static final int TOTAL_COIN_VALUE = 200;
	
	
	public static void main(String[] args) {
		long end;
		long start = System.currentTimeMillis();
		System.out.println(calculateUniqueCombos());
		end = System.currentTimeMillis();
		System.out.println(end - start + " ms");

	}
	
	public static int calculateUniqueCombos() {
		int total = 0;
		for (int i = TOTAL_COIN_VALUE; i >= 0; i -= 200){
			for (int j = i; j >= 0; j -= 100) {
				for (int k = j; k >= 0; k -= 50) {
					for (int l = k; l >= 0; l -= 20) {
						for (int m = l; m >= 0; m -= 10) {
							for (int n = m; n >= 0; n -= 5) {
								for (int o = n; o >= 0; o -= 2){
									total++;
								}
							}
						}
					}
				}
			}
		}
		return total;
	}

}
