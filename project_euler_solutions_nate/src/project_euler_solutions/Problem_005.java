package project_euler_solutions;

public class Problem_005 {

	public static void main(String[] args) {
		//Problem text:
		//2520 is the smallest number that can be divided by 
		//each of the numbers from 1 to 10 without any remainder.
		//What is the smallest positive number that is evenly divisible
		//by all of the numbers from 1 to 20?
		
		//A few things to note:
		//If a number is divisible by 12, it is divisible by 2, 3, 4, and 6.
		//If a number is divisible by 15, it is divisible by 3 and 5.
		//If a number is divisible by 20, it is divisible by 2, 4, 5, and 10.
		//A number divisible by a composite number is also divisible by its prime factors.
		
		//Using this logic, we can omit multiples of: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		
		System.out.println("Program begin.");
		
		int length = 1000;
		int factors = 20;
		int lcm = -1;
		
		int[][] multiplesofX = new int[factors][length];
		
		for(int i = 0; i < factors; i++) {	//creating rows from 1 to num. of factors
			multiplesofX[i] = generateMultiplesArray(i + 1, length);
			if(i >= 10) printArray(multiplesofX[i]);
		}
		
		lcm = getLCM(multiplesofX[11 - 1], multiplesofX[19 - 1]); //the -1 accounts for the index shift
		System.out.println("Program end.");
	}
	
	public static int factorial(int n) {
		if(n >= 1) {
			return n * factorial(n-1);
		}
		return 1;
	}
	
	/**
	 * @param n
	 * @param interval
	 * @return true if divisible by each number in [1, interval], false otherwise
	 */
	public static boolean checkIfDivisible(double n, int interval) {
		for(double i = 1; i <= interval; i++) {
			if(n % i != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int[] generateMultiplesArray(int multiples, int length) {
		int[] result = new int[length];
		for(int i = 0; i < result.length; i++) {
			result[i] = multiples * (i + 1);
		}
		return result;
	}
	
	public static void printArray(int[] array) {
		System.out.print("[");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println("]");
	}
	
	public static int getLCM(int[] a, int[] b) {
		int lcm = -1;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < b.length; j++) {
				if(a[i] == b[j]) {
				lcm = a[i];
				System.out.println("LCM of multiples " + a[0] + 
						" and " + b[0] + " is " + lcm);
				return lcm;
				}
			}
		}
		System.out.println("LCM not found. Arrays too small.");
		return lcm;
	}
	
}
