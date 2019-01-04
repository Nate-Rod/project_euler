package project_euler_solutions;

public class Problem_004 {

	public static void main(String[] args) {
		/**This solution is missing something. TODO: Figure out where the error is.
		 * 888888 and 990099 are not solutions, but the algorithm is giving those as solutions.
		 */
		//A palindromic number reads the same both ways. 
		//The largest palindrome made from the product
		//of two 2-digit numbers is 9009 = 91 × 99.
		//Find the largest palindrome made from the product of two 3-digit numbers.

		//Consider the following theorem:
		//from http://jwilson.coe.uga.edu/emt669/Student.Folders/Bacchus.Mohamed/Pal/pal.html
		//**All palindromes with an even number of digits are divisible by 11.
		//**Note that the converse of this is not true.
		
		//111111
		//112211
		//113311
		//114411
		// ...
		//997799
		//998899
		//999999
		//Compiling a list of palindrome numbers:
		int numBank[] = new int[81];
		int xxxxAA = 11;		//these will be used
		int xxBBxx = 1100;		//to construct
		int CCxxxx = 110000;		//each number in the bank
		
		for(int i = 0; i < numBank.length; i++) {
			numBank[i] = xxxxAA + xxBBxx + CCxxxx;
			xxBBxx += 1100;
			if(i % 10 == 0) {
				xxxxAA += 11;
				CCxxxx += 110000;
			}
			if(xxBBxx >= 10000) {
				xxBBxx = 1100;
			}
			System.out.println(numBank[i]);
		}
		
		int maxPali = numBank[0];
		for(int i = 100; i <= 999; i++) {
			for(int j = 100; j <= 999; j++) {
				int result = i * j;
				for(int k = 0; k < numBank.length; k++) {
					if (result == numBank[k] && result >= maxPali) {
						maxPali = result; 
						System.out.print(i + " x " + j + " = " + result);
						System.out.println(" with last maxPali " + maxPali);
					}
				}	
			}
		}
		System.out.println("Max number found is " + maxPali);
	}
}
