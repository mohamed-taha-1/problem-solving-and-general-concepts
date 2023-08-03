package medium._77_Combinations;

import java.util.ArrayList;
import java.util.List;

public class _77_Combinations {

	public static List<List<Integer>> combine(int n, int k) {
	    List<List<Integer>> result = new ArrayList<>();
	    List<Integer> current = new ArrayList<>();

	    tahaBacktrack(result, current, 1, n, k);

	    return result;
	}

	private static void tahaBacktrack(List<List<Integer>> result, List<Integer> current, int start, int end,
	                                  int numOfCombinations) {

	    // base case
	    if (current.size() == numOfCombinations) {
	        result.add(new ArrayList<>(current));
	    } else {
	        for (int i = start; i <= end; i++) {
	            current.add(i);
	            tahaBacktrack(result, current, i + 1, end, numOfCombinations);
	            current.remove(current.size() - 1);
	        }
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(combine(4, 2));

	}

}
