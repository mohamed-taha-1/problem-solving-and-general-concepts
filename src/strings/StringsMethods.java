package strings;

public class StringsMethods {

	public static void main(String[] args) {
		System.out.println("===== String methods =====");
		System.out.println();
		
		String s = " hello ";
		
		System.out.println( s.trim() );
		System.out.println( s.strip() );
		System.out.println( s.substring(0,4) );
		
		
		String str = "Hello World Java";
		String[] parts = str.split("\\s+"); // based on white space 

		// Output the array elements
		for (String part : parts) {
		    System.out.println("split parts : "+part); // when split come to {l} it split the it and the remain character in new line
		}

	}

}
