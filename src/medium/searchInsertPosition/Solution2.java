package searchInsertPosition;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	
	public static int searchInsert(int[] array, int target) {
	    List<Integer> arrayList = new ArrayList<>();
	    for (int num : array) {
	        arrayList.add(num);
	    }

	    for (int i = 0; i < arrayList.size(); i++) {
	        if (target == arrayList.get(i)) {
	            return i;
	        } else if (target < arrayList.get(i)) {
	            arrayList.add(i, target);
	            int[] newArray = new int[arrayList.size()];
	            for (int j = 0; j < arrayList.size(); j++) {
	                newArray[j] = arrayList.get(j);
	            }
	            return searchInsert(newArray, target);
	        }
	    }

	    arrayList.add(target);
	    int[] newArray = new int[arrayList.size()];
	    for (int j = 0; j < arrayList.size(); j++) {
	        newArray[j] = arrayList.get(j);
	    }
	    return searchInsert(newArray, target);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		int target = 8;
		System.out.println(searchInsert(nums, target));

	}

}
