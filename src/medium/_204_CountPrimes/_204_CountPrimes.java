package medium._204_CountPrimes;

public class _204_CountPrimes {

	public static int countPrimes(int n) {
		if (n <= 2) {
			return 0;
		}

		boolean[] isPrime = new boolean[n];

		for (int i = 2; i < n; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i * i < n; i++) {
			System.out.println("i: \t" + i);

			if (!isPrime[i])
				continue; // is value of i=false

			for (int j = i * i; j < n; j = j + i) {
				isPrime[j] = false;

			}
		}

		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int n = 10;

		System.out.println(countPrimes(n));

	}

}
