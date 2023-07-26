package searchInsertPosition;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class BinarySearch {
	public static void main(String[] args) {
		
		int [] arr= {1,2,4,5,6,7};
		  int[] sortedArr = Arrays.stream(arr)
	                .sorted()
	                .toArray();
		
		int item=5;
		
		int search=Arrays.binarySearch(sortedArr, item);
		
		if(search>=0) {
			System.out.println("Item is  founded at postion"+ search);
		}else{
		        System.out.println("Item not founded!");	
		}
		
		
	}

}
