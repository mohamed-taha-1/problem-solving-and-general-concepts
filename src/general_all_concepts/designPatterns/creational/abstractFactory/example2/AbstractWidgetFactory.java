package designPatterns.creational.abstractFactory.example2;

public interface AbstractWidgetFactory {

		public Window createWindow();
		public Scroll createScroll();
		public Button[] createNavigationButtons();
		
	}

