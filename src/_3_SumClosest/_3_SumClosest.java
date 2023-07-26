package _3_SumClosest;

public class _3_SumClosest {

	public static int threeSumClosest(int[] nums, int target) {

		int sum = 0;
		int n = nums.length;
		int k = n;
		int i = 0;
		int j = i + 1;
		
		
		while(j+1!=k) {
			sum=nums[i]+nums[j]+nums[k];
			i++;
		}
		
		System.out.println("the first sum befor i returend to 0 again"+ sum);
		
		if(sum>=target) {
			return sum;	
		}
		
		i=0;
		j=i+1;
		while(k>i) {
			sum=nums[i]+nums[j]+nums[k];
			k--;
		}
		
		System.out.println("the second sum "+ sum);
		
		return sum;
		
		
	}

	public static void main(String[] args) {
		int[] nums = { -1,2,1,-4 };
		int target = 1;

		System.out.println(threeSumClosest(nums, target));

	}

}
