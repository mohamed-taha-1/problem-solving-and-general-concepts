package designPatterns.behavioural.visitor;

public interface GeoElement {
	
	void accept(Visitor visitor);

}
