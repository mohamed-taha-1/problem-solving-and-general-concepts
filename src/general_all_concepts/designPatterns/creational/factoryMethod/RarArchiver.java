package designPatterns.creational.factoryMethod;


import java.io.File;
import java.io.Serializable;

public class RarArchiver implements Archiver {

	@Override
	public void archive(File directory) {
		System.out.println("Rar archiver");
	}
	
}
