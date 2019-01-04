package project_euler_solutions;

public class Problem_009 {

	public static void main(String[] args) {
		// Problem Text:
		/*A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
		 * a^2 + b^2 = c^2
		 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
		 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
		 * Find the product abc.
		 */
		
		//c^2 = a^2 + b^2
		//c = sqrt(a^2 + b^2)
		//thus: 1000 = a + b + sqrt(a^2 + b^2);
		
		int calculationNumber = 0;
		for(int a = 1; a <= 1000; a++) {
			for(int b = 1; b <= 1000; b++) {
				calculationNumber++;
				double c = Math.sqrt((a*a)+(b*b));
				if(a + b + c == 1000) {
					System.out.println(a + " + " + b  + " + " + c + " = 1000");
					System.out.println("Product of abc: " + (a*b*c));
					break;
				}
			}
		}
		System.out.println("Number of calculations: " + calculationNumber);
	}

}
