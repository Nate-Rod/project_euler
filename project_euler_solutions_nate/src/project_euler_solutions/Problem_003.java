package project_euler_solutions;

public class Problem_003 {

	public static void main(String[] args) {
		//Problem text:
		//The prime factors of 13195 are 5, 7, 13 and 29.
		//What is the largest prime factor of the number 600851475143?
		long threshold = 13195;
		for(long i = 1; i <= Math.floor(threshold/2); i++) {
			if(threshold % i == 0) {
				System.out.println("Divisible by " + i);
			}
		}
	}
}
