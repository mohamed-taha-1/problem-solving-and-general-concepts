package exceptionHandleng;


import java.io.FileNotFoundException;
import java.io.IOException;

public class ThrowsDemo {
	
	public static void main(String[] args) {
		ThrowsDemo demo = new ThrowsDemo();
//		demo.someMethod();
		
	}
	
	public void someMethod() throws FileNotFoundException {
		
	}

}


class ThrowsDemoOverride extends ThrowsDemo {
	
	@Override
	public void someMethod() {
		
	}
}
