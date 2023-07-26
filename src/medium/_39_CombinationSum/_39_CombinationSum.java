package medium._39_CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class _39_CombinationSum {

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> returnList = new ArrayList<>();
	    List<Integer> combinations = new ArrayList<>();

	    helperBackTrack(returnList, combinations, target, candidates, 0);

	    return returnList;

	}

	private static void helperBackTrack(List<List<Integer>> returnList, List<Integer> combinations, int target,
			int[] candidates, int startIndex) {

		if (target == 0) {
			returnList.add(new ArrayList<>(combinations));
			return;
		} else {

			for (int i = startIndex; i < candidates.length; i++) {
				if (candidates[i] <= target) {

					combinations.add(candidates[i]);

					helperBackTrack(returnList, combinations, target - candidates[i], candidates, i);
					combinations.remove(combinations.size() - 1);

				}

			}

		}

	}

	public static void main(String[] args) {
		 int [] candidates = {2,3,5} ;int target = 8;
		
		 System.out.println( combinationSum(candidates, target) );
		
	}

}
