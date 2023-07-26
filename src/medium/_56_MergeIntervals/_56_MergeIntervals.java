package medium._56_MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class _56_MergeIntervals {

	public static int[][] merge(int[][] intervals) {

		if (intervals == null || intervals.length == 0) {
			return new int[0][];
		}

		List<List<Integer>> adedList = new ArrayList<>();

		for (int i = 0; i < intervals.length - 1; i++) {
			List<Integer> tempral = new ArrayList<>();
			int[] current1 = intervals[i];
			int[] next = intervals[i + 1];
			boolean check = false;
			for (int j = 0; j < current1.length; j++) {
				System.out.print(" \t " + current1[j] + "and " + next[j]);
				check = current1[current1.length - 1] <= next[current1.length - 1]
						&& current1[current1.length - 1] >= next[0];
				if (check) {
					tempral.add(current1[0]);
					tempral.add(next[current1.length - 1]);
					break;

				} else {
					tempral.add(next[j]);
				}

			}

			System.out.println();
			adedList.add(new ArrayList<>(tempral));
		}

		System.out.println(adedList.toString());

		int numRows = adedList.size();
		int[][] resultArray = new int[numRows][];

		for (int i = 0; i < numRows; i++) {
			List<Integer> rowList = adedList.get(i);
			int numCols = rowList.size();
			resultArray[i] = new int[numCols];

			for (int j = 0; j < numCols; j++) {
				resultArray[i][j] = rowList.get(j);
			}
		}

		return resultArray;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1,4 }, { 4, 5 } };

		merge(intervals);

	}

}
