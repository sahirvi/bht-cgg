package a04;

import cgtools.*;

public class Background implements Shape {

	public Color color;

	public Background(Color color) {
		this.color = color;
	}

	public Hit intersect(Ray ray) {
		if (ray.tMax == Double.POSITIVE_INFINITY) {
			double t = Double.POSITIVE_INFINITY;
			Point x = ray.pointAt(t);
			Direction n = Vector.direction(0, 0, 0);
			return new Hit(t, x, n, color);
		} else {
			return null;
		}
	}
}