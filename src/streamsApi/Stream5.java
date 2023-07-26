package streamsApi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream5 {

	public static void main(String[] args) {

		// stream on files and read data from the file

		File file = new File("1.test");
		file.deleteOnExit();
		PrintWriter out ;
		try {
		
			out= new PrintWriter(file);
		    out.println("a1");
		    out.println("a2");
		    out.println("a3");
		    out.println("a4");
		    out.print("a5");
		    out.close();
		    
		} catch (FileNotFoundException e) {

			e.getMessage();
		}
		
		
		Stream<String> fileStream;
		try {
			fileStream = Files.lines(Paths.get(file.getAbsolutePath()));
			System.out.println(" :::: Printed Strings from the file \n "+ fileStream.collect(Collectors.toList()));
		} catch (IOException e) {
			e.getMessage();
		}
		

	}
}
