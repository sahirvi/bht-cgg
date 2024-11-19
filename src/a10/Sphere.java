package a10;

import cgtools.*;

public class Sphere implements Shape {

	public Point center; // Mittelpunkt der Kugel
	public double radius; // Abstand zwischen Mittelpunkt und Punkt auf der Oberfläche der Kugel
	public Material material;
	public Color color;

	public Sphere(Point center, double radius, Material material) {
		this.center = center;
		this.radius = radius;
		this.material = material;
	}

	public Hit intersect(Ray ray) {

		Vector x01 = Vector.subtract(ray.x0, Vector.directionTo(center)); // Verschiebung des Strahls um -c

		double p = 2 * Vector.dotProduct(ray.d, x01);
		double q = Vector.dotProduct(x01, x01) - radius * radius;
		double d = (p / 2) * (p / 2) - q;

		if (d >= 0) {
			double sqrt = Math.sqrt(d);
			double t0 = -(p / 2) - sqrt;
			double t1 = -(p / 2) + sqrt;
			if (t0 > t1) {
				double temp = t1;
				t1 = t0;
				t0 = temp;
			}
				if (ray.contains(t0)) 
					return hitAt(ray, t0);
				if (ray.contains(t1))
					return hitAt(ray, t1);
		}
		return null;
	}

	private Hit hitAt(Ray ray, double t) {
		Point x = ray.pointAt(t); // Punkt t0 an der Kugel
		Direction n = Vector.divide(Vector.subtract(x, center), radius);
		double inclination = Math.acos(n.y);
        double azimuth = Math.PI + Math.atan2(n.x, n.z);
        double u = azimuth / (2 * Math.PI);
        double v = inclination / Math.PI;

        return new Hit(t, x, n, u, v, material);
	}

}