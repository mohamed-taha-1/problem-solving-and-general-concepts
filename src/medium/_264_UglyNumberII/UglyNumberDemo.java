package medium._264_UglyNumberII;

public class UglyNumberDemo {

	 public static  int nthUglyNumber(int n) {
		 if (n <= 0) {
		        return 0;
		    }

		    int[] uglyNumbers = new int[n];
		    uglyNumbers[0] = 1;
		    int index2 =0, index3=0, index5=0;
		    
		    for(int i=1;i<n;i++) {
		    	int nextIndex=Math.min(uglyNumbers[index2]*2, Math.min(uglyNumbers[index3]*3, uglyNumbers[index5]*5));
		    	uglyNumbers[i]=nextIndex;
		    	
		    	if(uglyNumbers[index2]*2==nextIndex) index2++;
		    	if(uglyNumbers[index3]*3==nextIndex) index3++;
		    	if(uglyNumbers[index5]*5==nextIndex) index5++;
		    	
		    }
		    
		    return uglyNumbers[n-1];
	}
	public static void main(String[] args) {
		int number=10;
		System.out.println(nthUglyNumber(number));
	}

}
