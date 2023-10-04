package easy._168_ExcelSheetColumnTitle;

public class _168_ExcelSheetColumnTitle {

	// Given an integer columnNumber, return its corresponding column title as it
	// appears in an Excel sheet.

	/*
	 * Input: columnNumber = 1 Output: "A"
	 */

//	A -> 1
//	B -> 2
//	C -> 3
//	...
//	Z -> 26
//	AA -> 27
//	AB -> 28
//	...

	public static String convertToTitle(int columnNumber) {

//		String result="";
//		for(char i='A';i<='Z';i++) {
//			   if(columnNumber+64==i && columnNumber<=26) result+=i;
//			   else if(columnNumber>26 ) {
//				   result+= "A" +(char) (columnNumber - 26 + 'A' - 1);
//			   } 
//		}
		
		StringBuilder result2 = new StringBuilder();
		 while (columnNumber > 0) {
			 int remainder=(columnNumber - 1) % 26;
			 char digit = (char) ('A' + remainder);
			 result2.insert(0,digit);
			 columnNumber=(columnNumber-1)/26;
			 
		 }
		
		
		return result2.toString();
	}

	public static void main(String[] args) {
		System.out.println( convertToTitle(28) );

	}

}
