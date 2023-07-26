package nextPermutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class THirdSol {

	public static void nextPermutation(int[] arr) {
		int i = arr.length - 2;

		// Find the pivot element
		while (i >= 0 && arr[i] >= arr[i + 1]) {
			i--;
		}

		if (i >= 0) {
			int j = arr.length - 1;

			// Find the successor element
			while (arr[j] <= arr[i]) {
				j--;
			}

			// Swap the pivot and successor
			swap(arr, i, j);
		}

		// Reverse the elements to the right of the pivot
		reverse(arr, i + 1, arr.length - 1);
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void reverse(int[] arr, int start, int end) {
		while (start < end) {
			swap(arr, start, end);
			start++;
			end--;
		}
	}

	public static void main(String[] args) {

		int[] nums = { 3, 2, 1 };
		  nextPermutation(nums);

	}

}
