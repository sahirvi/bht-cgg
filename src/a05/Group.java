package a05;

public class Group implements Shape {

	final Shape[] shapes;

	public Group(Shape... shapes) {
		this.shapes = shapes;
	}

	public Hit intersect(Ray ray) {
		Hit closest = null;
		for (Shape shape : shapes) {
			Hit hit = shape.intersect(ray);
			if (closest == null || hit != null && hit.t < closest.t) {
				closest = hit;
			}
		}
		return closest;
	}
}