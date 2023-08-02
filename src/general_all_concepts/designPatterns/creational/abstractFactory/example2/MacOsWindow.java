package designPatterns.creational.abstractFactory.example2;

public class MacOsWindow implements Window {

	@Override
	public void repaint() {
		// Mac OSX specific behaviour
	}

	@Override
	public void setTitle(final String text) {
	}
	

}