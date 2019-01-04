package project_euler_solutions;

import java.math.BigInteger;

public class Problem_015 {

	public static void main(String[] args) throws java.lang.Exception {
		//Problem Text:
		/*2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
		 * What is the sum of the digits of the number 2^1000?
		 * 
		* The solution to problem 20 is also here:
		 * n! means n x (n - 1) x ... x 3 x 2 x 1
		 * For example, 10! = 10 x 9 x ... x 3 x 2 x 1 = 3628800,
		 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
		 * Find the sum of the digits in the number 100!
		 */
		
		BigInteger input = new BigInteger("2");
		input = input.pow(1000);
		System.out.println("Problem 15:\nInput: " + input.toString());	
		System.out.println("Sum of digits: " + sumDigitsOf(input));
		System.out.println("\nProblem 20:");
		BigInteger result = new BigInteger("100");
		System.out.println(result.toString() + "! is " + factorial(result).toString());
		System.out.println("Sum of digits: " + sumDigitsOf(factorial(result)));
	}
	
	public static BigInteger factorial(BigInteger n) {
		BigInteger one = new BigInteger("1");
		if(n.compareTo(one) == 0) {
			return one;
		}
		return n.multiply(factorial(n.subtract(one)));
	}
	
	public static BigInteger sumDigitsOf(BigInteger n) {
		BigInteger zero = new BigInteger("0");
		BigInteger ten = new BigInteger("10");
		BigInteger sum = new BigInteger("0");
		while(n.compareTo(zero) != 0) {
			sum = sum.add(n.mod(ten));
			n = n.divide(ten);
		}
		return sum;
	}
}
