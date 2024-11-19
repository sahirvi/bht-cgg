package a08;

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

		// double a = Vector.dotProduct(ray.d, ray.d); // d²
		// double b = 2 * Vector.dotProduct(x01, ray.d); // 2x0d
		// double c = Vector.dotProduct(x01, x01) - Math.pow(radius, 2); // x0² - r²
		//
		// double discrimant = Math.pow(b, 2) - 4 * a * c; // b² - 4 * a * c
		//
		// if (discrimant >= 0) {
		//
		// double t0 = (-b - Math.sqrt(discrimant)) / 2 * a;
		// double t1 = (-b + Math.sqrt(discrimant)) / 2 * a;
		//

		// }
		//
		// if (ray.contains(t0)) {
		// Point x = ray.pointAt(t0); // Punkt t0 an der Kugel
		// Direction n = Vector.divide(Vector.subtract(x, center), radius);
		// return new Hit(t0, x, n, material);
		// }
		//
		// else if (ray.contains(t1)) {
		// Point x = ray.pointAt(t1); // Punkt t1 an der Kugel
		// Direction n = Vector.divide(Vector.subtract(x, center), radius);
		// return new Hit(t1, x, n, material);
		// } else {
		// return null;
		// }
		//
		// }
		return null;
	}

	private Hit hitAt(Ray ray, double t) {
		Point x = ray.pointAt(t); // Punkt t0 an der Kugel
		Direction n = Vector.divide(Vector.subtract(x, center), radius);

		return new Hit(t, x, n, material);
	}

}