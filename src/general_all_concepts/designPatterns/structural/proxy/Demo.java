package designPatterns.structural.proxy;

public class Demo {
	
	public static void main(String[] args) {
		Internet internet = new ProxyInternet();
		
		internet.connectToHost("it-bulls.com");
		internet.connectToHost("facebook.com");
	}
}