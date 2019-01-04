package project_euler_solutions;

public class Problem_010 {

	public static void main(String[] args) {
		//Problem Text:
		//The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
		//Find the sum of all the primes below two million.
		
		int threshold = 2000000;
		int[] primes = new int[threshold];
		for(int i = 0; i < threshold; i++) {
			primes[i] = i;
		}
		//printNonZeroArray(primes);
		for(int i = 2; i < threshold/2; i++) {
			removeFactorsofX(i, primes);
		}
		//printNonZeroArray(primes);
		long sum = sumArray(primes);
		System.out.println("Sum of array contents: " + sum);
	}
	
	public static void removeFactorsofX(int factor, int[] array) {
		for(int i = 2 * factor; i < array.length; i += factor) {
			array[i] = 0;
		}
		array[1] = 0;
	}
	
	public static void printNonZeroArray(int[] array) {
		System.out.print("Contents in array: [");
		for(int i = 0; i < array.length; i++) {
			if(array[i] != 0) {
				System.out.print(array[i] + ", ");
			}
		}
		System.out.println("]");
	}
	
	public static long sumArray(int[] array) {
		long sum = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] != 0) {
				sum += array[i];
			}
		}
		return sum;
	}
}
