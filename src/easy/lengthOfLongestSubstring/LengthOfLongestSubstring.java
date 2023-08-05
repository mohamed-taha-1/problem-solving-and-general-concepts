package lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
		  Set<Character> set = new HashSet<>();
		    int fixed = 0;
		    int max = 0;

		    for (int i = 0; i < s.length(); i++) {
		        if (!set.contains(s.charAt(i))) {
		            set.add(s.charAt(i));
		            max = Math.max(max, i - fixed + 1);
		        } else {
		            while (set.contains(s.charAt(i))) {
		                set.remove(s.charAt(fixed));
		                fixed++;
		            }
		            set.add(s.charAt(i));
		        }
		    }

		    return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
		int len=lengthOfLongestSubstring("aab");
		System.out.println(len);

	}

}
