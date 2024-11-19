package a08;

import cgtools.*;

public class TransparentMaterial implements Material {

	public Color albedo;
	public double opticalIndex; // Brechungsindex

	public TransparentMaterial(Color albedo, double opticalIndex) {
		this.albedo = albedo;
		this.opticalIndex = opticalIndex;
	}

	@Override
	public Boolean absorb() {
		return true;
	}

	@Override
	public Ray scatteredRay(Ray ray, Hit hit) {
		double n1 = 1; // Luft = 1.0
		double n2 = opticalIndex;
		Direction n = hit.normal;

		if (Vector.dotProduct(ray.d, n) > 0) { // if (n * d > 0)
			n1 = opticalIndex; // swap
			n2 = 1.0; // swap
			n = Vector.negate(hit.normal); // n = -n
		}

		Direction refracted = refract(n, Vector.normalize(ray.d), n1, n2);

		if (refracted != null && Random.random() > schlick(n, ray.d, n1, n2)) {
			return new Ray(hit.x, refracted, Util.EPSILON, Double.POSITIVE_INFINITY);
		}

		else {
			return new Ray(hit.x, reflect(n, ray.d), Util.EPSILON, Double.POSITIVE_INFINITY);
		}
	}

	double schlick(Direction n, Direction d, double n1, double n2) {
		// Schlick Approximation
		double r0 = Math.pow(((n1 - n2) / (n1 + n2)), 2); // r0 = (n1 - n2 / n1 + n2)²
		double schlick = r0 + (1 - r0) * Math.pow(1 + Vector.dotProduct(n, d), 5); // r(0) = r0 + (1 - r0)(1 + n * d)⁵
		return schlick;
	}

	Direction refract(Direction n, Direction d, double n1, double n2) {
		double r = n1 / n2; // r = n1/n2
		// Snells Law
		double c = -Vector.dotProduct(n, d); // c = -n * d
		double discriminant = 1 - r * r * (1 - c * c); // √(1-r²(1-c²))
		if (discriminant < 0) {
			return null;
		} else {
			Direction dt = Vector.add(Vector.multiply(r, d), Vector.multiply((r * c - Math.sqrt(discriminant)), n));
			// dt = rd + (rc - √(1-r²(1-c²))) * n
			return dt;
		}
	}

	Direction reflect(Direction d, Direction n) {
		Direction reflect = Vector.subtract(d, Vector.multiply(2 * Vector.dotProduct(n, d), n)); // r = d - 2 * (n * d) * n
		return reflect;
	}

	@Override
	public Color albedo(Ray ray, Hit hit) {
		return albedo;
	}

	@Override
	public Color emission(Ray ray, Hit hit) {
		return Color.black;
	}

}
