package a11;

import cgtools.*;

public class Plane implements Shape {

	public Material material;
	public Color color;
	public Point p;
	public Direction n;
	public double r = Double.POSITIVE_INFINITY;

	public Plane(Point p, Direction n, double r, Material material) {
		this.n = n;
		this.p = p;
		this.material = material;
		this.r = r;
	}

	public Hit intersect(Ray ray) {

		if (Vector.dotProduct(ray.d, n) == 0) { // man kann nicht durch 0 teilen
			return null;
		} else {
			double t = (Vector.dotProduct(Vector.subtract(p, ray.x0), n)) / Vector.dotProduct(ray.d, n); // t = ((p -
																											// x0) * n)
																											// / (d * n)

			if (!ray.contains(t)) {
				return null;
			}

			Point x = ray.pointAt(t);

			if (x != null) {

				if (Vector.length(Vector.subtract(x, p)) > r) {
					return null;
				} else {
					double u = x.x / r + 0.5;
					double v = x.z / r + 0.5;

					return new Hit(t, x, n, u, v, material);
				}
			} else {
				return null;
			}

		}
	}
}
