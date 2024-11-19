package a11;

import cgtools.*;

public class Background implements Shape {

	public Material material;
	public Color color;

	public Background(Material material) {
		this.material = material;
	}

	public Hit intersect(Ray ray) {

		double t = Double.POSITIVE_INFINITY;
		if (ray.tMax == t) {

			Point x = ray.pointAt(t);
			Direction n = Vector.direction(t, t, t);
			double inclination = Math.acos(ray.d.y);
			double azimuth = Math.PI + Math.atan2(ray.d.x, ray.d.z);
			double u = azimuth / (2 * Math.PI);
			double v = inclination / Math.PI;
			return new Hit(t, x, n, u, v, material);
		} else
			return null;
	}

}