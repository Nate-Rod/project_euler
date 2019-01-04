package project_euler_solutions;

import java.util.List;
import java.util.ArrayList;

public class Problem_021 {

	public static void main(String[] args) {
		//Problem text:
		/* Let d(n) be defined as the sum of proper divisors of n 
		 * (numbers less than n which divide evenly into n).
		 * If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair 
		 * and each of a and b are called amicable numbers.
		 * For example, the proper divisors of 220 are 
		 * 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
		 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
		 *
		 * Evaluate the sum of all the amicable numbers under 10000.
		 */
		
		/*  //Replace the asterisk with a '/' to try out the single case code.
		String sumString = "Sum of proper divisors of ";
		List<Integer> a = properDivisorsOf(220);
		List<Integer> b = properDivisorsOf(284);
		System.out.println(sumString + "220 is " + sumList(a));
		System.out.println(sumString + "284 is " + sumList(b));
		System.out.println("Are these two numbers amicable? " + isAmicable(220, 284));
		//*/
		int startInt = 1000;
		long startTime = System.currentTimeMillis();		//for deltatime calculations
		
		List<Integer> startList = sequentialList(startInt);
		System.out.println(startList.toString());
		for(int i : startList) {
			for(int j = i + 1; j <= startInt; j++) {
				if(isAmicable(i, j)) System.out.println(i + " and " + j + " are amicable.");
			}
		}
		
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("End of program.\nTime elapsed: " + elapsedTime + " milliseconds.");
		
		/* Runtime notes:
		 * 1000 values has a runtime of approx. 1200 ms.
		 * 1500 values has a runtime of approx. 3600 ms.
		 * 2000 values has a runtime of approx. 8200 ms.
		 * 2500 values has a runtime of approx. 19000 ms.
		 * At this rate, 10k will take forever.
		 */
	}
	
	//Creates a sequential list of numbers from [1, n] for any int n.
	public static List<Integer> sequentialList(int number){
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 1; i <= number; i++) {
			result.add(i);
		}
		return result;
	}
	
	public static List<Integer> properDivisorsOf(int number) {
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 2; i <= number/2; i++) {
			if(number % i == 0) {
				result.add(number/i);
			}
		}
		result.add(1);
		//System.out.println(result.toString());
		return result;
	}
	
	public static int sumList(List<Integer> divisorList) {
		int sum = 0;
		for(int i : divisorList) {
			sum += i;
		}
		return sum;
	}
	
	public static boolean isAmicable(int a, int b) {
		if (a == b) return false;
		List<Integer> aList = properDivisorsOf(a);
		List<Integer> bList = properDivisorsOf(b);
		return (sumList(aList) == b && sumList(bList) == a);
	}
}
