package project_euler_solutions;

import java.util.HashSet;

public class Problem_007 {

	public static void main(String[] args) {
		// By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
		// we can see that the 6th prime is 13.

		// What is the 10,001st prime number?
		// Sieve of Eratosthenes!
		
		int threshold = 104745;		//trial and error
		HashSet<Integer> primeList = new HashSet<Integer>(threshold);
		for (int i = 2; i <= threshold; i++) {
			primeList.add(i);
		}
		//System.out.println("Added: " + primeList.toString());
		for (int i = 2; i < (threshold/2)+1; i++) {
			removeFactorsofX(i, primeList, threshold);
		}
		System.out.println("Result: " + primeList.toString());
		System.out.println("Size of set: " + primeList.size());
		System.out.println("Check entry 10001.");
	}

	public static void removeFactorsofX(int factor, HashSet<Integer> hashSet, int threshold) {
		//System.out.println("Factors of " + factor + " removed:");
		for (int i = 2 * factor; i < threshold; i = factor + i) {
			hashSet.remove(i);
			//System.out.print(i + ", ");
		}
		//System.out.println("");
	}

}
