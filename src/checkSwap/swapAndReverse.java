package checkSwap;

import java.util.Arrays;

public class swapAndReverse {

	public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
        return arr;
    }

	public static void main(String[] args) {
	
	
		int[] arr = {1,2,3,4,5,6,7,8,9};

        // Call the reverse method on the entire array
        reverse(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
		
	

	}

}
