package designPatterns.behavioural.visitor;

public interface ExportVisitor extends Visitor {

	public default void export(GeoElement... elements) {
		for (GeoElement geoElement : elements) {
			geoElement.accept(this);
		}
	}
}
