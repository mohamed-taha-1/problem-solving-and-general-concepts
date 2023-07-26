package medium._40_CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_CombinationSumII {

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

		List<List<Integer>> returnedList = new ArrayList<>();
		List<Integer> combinations = new ArrayList<>();
		Arrays.sort(candidates); // Sort the candidates to avoid duplicates
		backTrackForcompinations(returnedList, combinations, candidates, target, 0, new boolean[candidates.length]);
        
		return returnedList;

	}

	private static void backTrackForcompinations(List<List<Integer>> returnedList, List<Integer> combinations,
			int[] candidates, int target, int startIndex, boolean[] used) {

		if (target == 0) {
			returnedList.add(new ArrayList<>(combinations));
			return;
		} else {

			for (int i = startIndex; i < candidates.length; i++) {
				if (!used[i]) {
					 if (i > startIndex && candidates[i] == candidates[i - 1]) {
		                    continue; // Skip duplicates to avoid duplicate combinations
		                }
					
					
					if (candidates[i] <= target) {
						used[i] = true;
						combinations.add(candidates[i]);

						backTrackForcompinations(returnedList, combinations, candidates, target - candidates[i], i+1,
								used);

						combinations.remove(combinations.size() - 1);
						used[i] = false;

					}

				}
			}

		}

	}

	public static void main(String[] args) {
        int[] candidates= {10,1,2,7,6,1,5};  int target=8;
        
        System.out.println(combinationSum2(candidates , target) );
        
        
 	}

}
