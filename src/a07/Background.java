package a07;

import cgtools.*;

public class Background implements Shape {

	public Material material;

	public Background(Material material) {
		this.material = material;
	}
	
	public Hit intersect(Ray ray) {
		if (ray.tMax == Double.POSITIVE_INFINITY) {
			double t = Double.POSITIVE_INFINITY;
			Point x = ray.pointAt(t);
			Direction n = Vector.direction(0, 0, 0);
			return new Hit(t, x, n, material);
		} else {
			return null;
		}
	}
}