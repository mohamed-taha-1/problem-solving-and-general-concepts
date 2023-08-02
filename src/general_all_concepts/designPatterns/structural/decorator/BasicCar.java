package designPatterns.structural.decorator;


public class BasicCar implements Car {

	@Override
	public void drive() {
		System.out.print("Basic Car Drives");
	}

}