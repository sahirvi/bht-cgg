package a09;

import java.util.ArrayList;

import cgtools.*;

public class Group implements Shape {

	protected ArrayList<Shape> shapes;

	public Transformation trans;

	public Group(Matrix matrix, Shape... shapes) {
		this(matrix);
		for (Shape s : shapes) {
			addShape(s);
		}
	}

	public Group(Shape... shapes) {
		this(Matrix.identity, shapes);
	}
	
	public Group(Matrix matrix) {
		this.trans = new Transformation(matrix);
		shapes = new ArrayList<Shape>();
	}

	public Group() {
		this(Matrix.identity);
	}

	public void addShape(Shape s) {
		shapes.add(s);
	}

	public Hit intersect(Ray ray) {

		Hit closest = null;
		Ray intersectRay = trans.transformRay(ray);
		for (Shape shape : shapes) {
			Hit hit = shape.intersect(intersectRay);
			if (closest == null || hit != null && hit.t < closest.t) {
				closest = hit;
			}
		}
		trans.transformHit(closest);
		return closest;
	}

}