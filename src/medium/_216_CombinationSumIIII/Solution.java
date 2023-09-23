package medium._216_CombinationSumIIII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		helper(result, new ArrayList<>(), k, n, 1, new boolean[10]);
		return result;
	}

	private static void helper(List<List<Integer>> result, List<Integer> current, int k, int n, int start,
			boolean[] used) {
		if (k == 0 && n == 0) {
			result.add(new ArrayList<>(current));
			return;
		}

		if (k <= 0 || n < 0) {
			return;
		}

		for (int i = start; i <= 9; i++) {
			if (!used[i]) {
				current.add(i);
				used[i] = true;
				helper(result, current, k - 1, n - i, i + 1, used);
				current.remove(current.size() - 1);
				used[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		int k = 3, n = 7;
		System.out.println(combinationSum3(k, n));

	}

}
