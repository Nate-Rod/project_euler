package project_euler_solutions;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;


public class Problem_025 {

	private static final BigInteger ONE = new BigInteger("1");
	private static final BigInteger ZERO = new BigInteger("0");

	public static void main(String[] args) {
		/*
		 * Problem Text: The Fibonacci sequence is defined by the recurrence relation:
		 * F(n) = F(n−1) + F(n−2), where F1 = 1 and F2 = 1. Hence the first 12 terms
		 * will be: F1 = 1 F2 = 1 F3 = 2 F4 = 3 F5 = 5 F6 = 8 F7 = 13 F8 = 21 F9 = 34
		 * F10 = 55 F11 = 89 F12 = 144 The 12th term, F12, is the first term to contain
		 * three digits. What is the index of the first term in the Fibonacci sequence
		 * to contain 1000 digits?
		 */
		
		int size = 4782; //found via trial and error because it was faster than automating it
		long startTime = System.currentTimeMillis();
		//List<Integer> fibList = new LinkedList<Integer>();
		List<BigInteger> bigIntFibList = new LinkedList<BigInteger>();
		//fibList = genIntListToTerm(45);
		bigIntFibList = genBigIntList(size);
		System.out.println(getLengthOf(bigIntFibList.get(size - 1)));
		
		
		// End of program
		System.out.println("Program runtime: " + (System.currentTimeMillis() - startTime) + " ms.");
	}

	// recursive test int method. VERY slow past 40 digits.
	public static int intFib(int n) {
		if (n <= 1) return n;
		return intFib(n - 1) + intFib(n - 2);
	}
	
	public static int getLengthOf(BigInteger n) {
		return n.toString().length();
	}

	//generative list solution using int data types as parameters. Much faster.
	public static List<Integer> genIntListToTerm(int n) {
		List<Integer> resultList = new LinkedList<Integer>();
		resultList.add(1);
		resultList.add(1);
		for(int i = 2; i < n; i++) {
			resultList.add(resultList.get(i - 1) + resultList.get(i - 2));
		}
		return resultList;
	}
	
	public static List<BigInteger> genBigIntList(int n) {
		List<BigInteger> resultList = new LinkedList<BigInteger>();
		resultList.add(ONE);
		resultList.add(ONE);
		for(int i = 2; i < n; i++) {
			resultList.add(resultList.get(i - 1).add(resultList.get(i - 2)));
		}
		return resultList;
	}


}
