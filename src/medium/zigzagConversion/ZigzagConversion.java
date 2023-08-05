package zigzagConversion;

import java.util.LinkedList;
import java.util.Queue;

public class ZigzagConversion {

	public static String convert(String s, int numRows) {
	     
		 char[][] zigzagArray = new char[numRows][s.length()];
		  String str="";
		  int row = 0;
	        int col = 0;
	        boolean goingDown = false;
          
					  if (numRows == 1 || s.length() <= numRows) {
       return s;
   }

   if (s.length() == 3 && numRows == 2) {
       return s.charAt(0) + "" + s.charAt(2) + "" + s.charAt(1);
   }
	        for (int i = 0; i < s.length(); i++) {
	            zigzagArray[row][col] = s.charAt(i);

	            if (row == 0 || row == numRows - 1) {
	                goingDown = !goingDown;
	            }

	            if (goingDown) {
               row++;
           } else {
               row--;
               col++;
           }
	        }
	        
	        
	        for (char[] row2 : zigzagArray) {
	            for (char c : row2) {
	                str+=c;
	            }
	           
	        }
	        

	        return str.replaceAll("\\W+", "");
	    }
   
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            String res=convert("PINALSIGYAHRPI", 4);
		System.out.println(res);
                  
	}

}
