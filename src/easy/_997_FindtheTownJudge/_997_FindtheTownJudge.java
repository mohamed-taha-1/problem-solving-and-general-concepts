package easy._997_FindtheTownJudge;

import java.util.ArrayList;
import java.util.List;

public class _997_FindtheTownJudge {

//	        Input: n = 2, trust = [[1,2]]
//			Output: 2

//	        Input: n = 3, trust = [[1,3],[2,3]]
//			Output: 3

//	        Input: n = 3, trust = [[1,3],[2,3],[3,1]]
//			Output: -1

	// actuall y there are 1 person is trusted by others and he not trust any body

	public static int findJudge(int n, int[][] trust) {

		List<Integer>[] list = new ArrayList[n + 1]; // Create an array of lists

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int[] arr : trust) {
			int str = arr[0];
			int dist = arr[1];
			list[str].add(dist);
		}

		int[] trustCounts = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			for (int trusted : list[i]) {
				trustCounts[trusted]++; // make a liked list 
			}
		}

		for (int i = 1; i <= n; i++) {
			if (trustCounts[i] == n - 1 && list[i].size()==0  ) { // loop over the linked lists 
				return i; // The person is trusted by everyone else
			}
		}

		return -1; // No town judge found
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 3 }, { 2, 3 }, { 3, 1 } };

		int n = 3;
		System.out.println(findJudge(n, arr));

	}

}
