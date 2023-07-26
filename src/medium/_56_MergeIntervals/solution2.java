package medium._56_MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solution2 {

	public static int[][] merge(int[][] intervals) {
		if (intervals.length <= 1) {
			return intervals;
		}

		// Sort intervals based on the starting value of each interval
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		List<int[]> mergedList = new ArrayList<>();
		int[] currentInterval = intervals[0];

		for (int i = 1; i < intervals.length; i++) {
			int[] nextInterval = intervals[i];

			if (currentInterval[1] >= nextInterval[0]) {
				// Overlapping intervals, update the end of the currentInterval
				currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
			} else {
				// Non-overlapping interval found, add currentInterval to the merged list
				mergedList.add(currentInterval);
				currentInterval = nextInterval; // Move to the next interval
			}
		}

		// Add the last interval (or the only interval) to the merged list
		mergedList.add(currentInterval);

		// Convert the ArrayList to a 2D array and return
		int[][] resultArray = new int[mergedList.size()][2];
		for (int i = 0; i < mergedList.size(); i++) {
			resultArray[i] = mergedList.get(i);
		}

	
		return resultArray;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 4 }, { 4, 5 } };

		merge(intervals);

	}

}
