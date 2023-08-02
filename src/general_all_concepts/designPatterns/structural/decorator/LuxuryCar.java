package designPatterns.structural.decorator;

public class LuxuryCar extends CarDecorator {

	public LuxuryCar(Car car) {
		super(car);
	}

	@Override
	public void drive() {
		super.drive();
		System.out.print(" And drives soft as luxury car");
	}
}
