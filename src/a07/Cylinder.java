package a07;

import cgtools.*;

public class Cylinder implements Shape {

	public Point center; // Mittelpunkt des Zylinders
	public double height; // Höhe des Zylinder
	public double radius; // Radius des Zylinders
	public Material material;

	public Cylinder(Point center, double height, double radius, Material material) {

		this.center = center;
		this.height = height;
		this.radius = radius;
		this.material = material;
		
	}

	@Override
	public Hit intersect(Ray ray) {

		Point x01 = Vector.subtract(ray.x0, Vector.directionTo(center)); // Verschiebung des Strahls um -c

		x01 = Vector.point(x01.x, 0, x01.z); // Entfernung des y-Werts aus x01

		Direction rd = Vector.direction(ray.d.x, 0, ray.d.z); // Entfernung des y-Werts von ray.d

		double a = Vector.dotProduct(rd, rd); // d²
		double b = 2 * Vector.dotProduct(x01, rd); // 2x0d
		double c = Vector.dotProduct(x01, x01) - radius * radius; // x0² - r²
		double discriminant = (b * b) - (4 * a * c); // b² - 4 * a * c

		if (discriminant >= 0) {

			double t0 = (-b - Math.sqrt(discriminant)) / (2 * a);
			double t1 = (-b + Math.sqrt(discriminant)) / (2 * a);

			if (t0 > t1) { // Vertauschung von t0 und t1, falls t0 größer ist als t1
				double temp = t1;
				t1 = t0;
				t0 = temp;
			}

			if (ray.contains(t0)) {
				return hitAt(ray, t0);
			}

			if (ray.contains(t1)) {
				return hitAt(ray, t1);
			}
		}
		return null;
	}

	private Hit hitAt(Ray ray, double t) {

		Point x = ray.pointAt(t);

		if (x.y < center.y || x.y > (center.y + height)) {
			return null;
		}
		Direction n = Vector.divide(Vector.subtract(x, center), radius);

		n = Vector.normalize(Vector.direction(n.x, 0, n.z));

		return new Hit(t, x, n, material);
	}

}