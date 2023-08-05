package lengthofLastWord;

public class LengthofLastWord {

	public static int lengthOfLastWord(String s) {
		String[] d = s.split("\\s+");
		return d[d.length - 1].length();
	}

	public static void main(String[] args) {

		lengthOfLastWord("Hello World");

	}

}
