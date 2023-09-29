package medium._229_MajorityElementII;

import java.util.ArrayList;
import java.util.List;

public class _229_MajorityElementII {

	
	//  find all elements that appear more than ⌊ n/3 ⌋ times.
	 public static List<Integer> majorityElement(int[] nums)
	 {
	    List<Integer> resultList=new ArrayList<>();
	    int candidate1 = 0, candidate2 = 1, count1 = 0, count2 = 0;
	    for(int num: nums)
	    {
	    	if(num==candidate1) count1++;
	    	else if(num == candidate2 ) count2++;
	    	else if(count1==0)
	    	{
	    		candidate1=num;
	    		count1=1;
	    	}
	    	else if(count2==0)
	    	{
	    		candidate2=num;
	    		count2=1;
	    	}
	    	else
	    	{
	    		count1--;
	    		count2--;
	    	}	
	    }
	    count1 = 0; count2 = 0;
	    for(int num: nums) 
	    {
	    	if(num==candidate1) count1++;
	    	else if(num==candidate2) count2++;   	
	    }
	    if(count1>nums.length/3) resultList.add(candidate1);
	    if(count2>nums.length/3) resultList.add(candidate2);
	 
		 return resultList;
	 }
	public static void main(String[] args) {
		int[] nums= {1,3,4,4,4};
		System.out.println(majorityElement(nums));
		
	}
}
