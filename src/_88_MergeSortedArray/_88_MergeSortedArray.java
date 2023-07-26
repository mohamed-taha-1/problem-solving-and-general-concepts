package _88_MergeSortedArray;

import java.util.Arrays;

public class _88_MergeSortedArray {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		   int[] maxArray = new int[m + n];
		    int i = 0, j = 0, k = 0;

		    while(i<m && j<n) {
		    	
		    	if(nums1[i]<nums2[j]) {
		    		maxArray[k]=nums1[i];
		    		i++;
		    	}else {
		    		maxArray[k]=nums2[j];
		    		j++;
		    	}
		    	
		    	k++;	
		    }
		    
		    
		    
		    while(i<m) {
		    	maxArray[k]=nums2[i];
		    	i++;
		    	k++;
		    }
		    while(j<n) {
		    	maxArray[k]=nums2[j];
	    		j++;
	    		k++;
		    }
		    
		    System.arraycopy(maxArray, 0, nums1, 0, m+n);
		    

		System.out.println(Arrays.toString(maxArray));

	}

	public static void main(String[] args) {
		// now try to fix this bad example and convert it into a meaningful one

		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int m = 3;
		int[] nums2 = { 2, 5, 6 };
		int n = 3;

		merge(nums1, m, nums2, n);

	}

}
