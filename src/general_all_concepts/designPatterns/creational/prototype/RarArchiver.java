package designPatterns.creational.prototype;

import java.io.File;
import java.io.Serializable;



public class RarArchiver implements Archiver, Serializable {

	@Override
	public void archive(File directory) {
		System.out.println("Rar archiver");
	}
	
	@Override
	public Archiver clone() {
		return (Archiver) SerializationUtils.clone(this);
	}

}