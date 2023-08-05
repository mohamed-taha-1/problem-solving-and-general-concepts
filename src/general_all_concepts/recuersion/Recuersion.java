package recuersion;

import java.util.Arrays;

public class Recuersion {

	public static int factorial(int n) {
		// base case or if i==n
		if (n <= 1)
			return 1;
		int fact = n * factorial(n - 1);
		return fact;
	}

	public static void fill(int[] b, int n) {
		if (n < 0) {
			return;
		}
		b[n] = n;
		fill(b, n - 1);
	}

	public static int sum(int[] b, int n) {

		int total = 0;
		if (n < 0)
			return total;
		else {
			total = b[n] + sum(b, n - 1);
			return total;
		}

	}

	public static void main(String[] args) {
		System.out.println(" we just work on 1 parameter and after one call -1 \n");
		System.out.println(factorial(5));

		// ------------ second example

		System.out.println("the filled array \n");

		int[] a = new int[10];
		fill(a, a.length - 1);
		System.out.println("the array is " + Arrays.toString(a));

		// ---- third example
		int[] c = { 3, 53, 2, 1, 1, 4, 1, 1, 1 };
		System.out.println("The sum " + sum(c, c.length - 1));

	}

}
