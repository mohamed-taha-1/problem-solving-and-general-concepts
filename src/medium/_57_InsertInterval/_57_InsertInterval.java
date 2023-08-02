package medium._57_InsertInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _57_InsertInterval {

	public static int[][] insert(int[][] intervals, int[] newInterval) {

		List<int[]> mergedIntervals = new ArrayList<>();
		int i = 0;
		int n = intervals.length;

		// Add all intervals that end before the new interval starts
		while (i < n && intervals[i][1] < newInterval[0]) {
			mergedIntervals.add(intervals[i]);
			i++;
		}

		// Merge overlapping intervals
		while (i < n && intervals[i][0] <= newInterval[1]) {
			newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			i++;
		}

		// Add the merged interval
		mergedIntervals.add(newInterval);

		// Add remaining intervals that come after the new interval
		while (i < n) {
			mergedIntervals.add(intervals[i]);
			i++;
		}

		// Convert the list of intervals to a 2D array
		int[][] result = new int[mergedIntervals.size()][2];
		for (int j = 0; j < mergedIntervals.size(); j++) {
			result[j] = mergedIntervals.get(j);
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 6, 9 } };
		int[] newInterval = { 2, 5 };

		for (int[] interval : insert(intervals, newInterval)) {
			System.out.println(Arrays.toString(interval));
		}

	}

}
