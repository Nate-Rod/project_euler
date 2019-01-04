package project_euler_solutions;

public class Problem_014 {

	public static void main(String[] args) {
		//Problem Text:
		/*The following iterative sequence is defined for the set of positive integers:
		 * n -> n/2 (n is even)
		 * n -> 3n + 1 (n is odd)
		 * Using the rule above and starting with 13, we generate the following sequence:
		 * 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
		 * 
		 * It can be seen that this sequence (starting at 13 and finishing at 1) 
		 * contains 10 terms. Although it has not been proved yet (Collatz Problem), 
		 * it is thought that all starting numbers finish at 1.
		 * 
		 * Which starting number, under one million, produces the longest chain?
		 * NOTE: Once the chain starts the terms are allowed to go above one million.
		 */
		long maxLength = 0;
		long numEntry = 0;
		for(long i = 0; i < 1000000; i++) {
			long currentLength = collatzChainLength(i);
			//System.out.println(i + " sequence length: " + currentLength);
			if(currentLength > maxLength) {
				maxLength = currentLength;
				numEntry = i;
			}
		}
		System.out.println("Maximum found length: " + maxLength + " at starting value " + numEntry);
	}
	
	public static long collatzChainLength(long start) {
		long length = 1;
		while(start > 1) {
			//System.out.print(start + " -> ");
			if(start % 2 == 0) {
				start = start / 2;
			} else if (start % 2 != 0) {
				start = (3 * start) + 1;
			}
			length++;
		}
		//System.out.println(start);
		return length;
	}
}
