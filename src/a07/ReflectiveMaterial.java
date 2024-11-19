package a07;

import cgtools.*;

public class ReflectiveMaterial implements Material {

	public Color albedo;
	public double s = 0; // Streuungsfaktor s

	public ReflectiveMaterial(Color albedo, double s) {
		this.albedo = albedo;
		this.s = s;
	}

	@Override
	public Boolean absorb() {
		return true;
	}

	@Override
	public Ray scatteredRay(Ray ray, Hit hit) {

		Direction r = Vector.subtract(ray.d, Vector.multiply(2 * Vector.dotProduct(hit.normal, ray.d), hit.normal));
		// r = d - 2 * (n * d) * n
		if (s != 0) {

			double limiter = s * 1000;
			while (limiter >= 0) {

				Direction rs = Vector.add(r, Vector.multiply(s, randomDir())); // rs = r + s * xrnd

				if (Vector.dotProduct(rs, hit.normal) > 0) {
					r = rs;
					break;

					// Direction rs;
					// do
					// rs = Vector.add(r, Vector.multiply(s, randomDir())); // rs = r + s * xrnd
					//
					// while (Vector.dotProduct(rs, hit.normal) > 0);
					// r = rs;
					// }
					// return new Ray(hit.x, r);

				}
				limiter--;
			}
		}
		return new Ray(hit.x, r, Util.EPSILON, Double.POSITIVE_INFINITY);
	}

	Direction randomDir() {
		Direction xrnd;
		do
			xrnd = Vector.direction(Random.random() * 2 - 1, Random.random() * 2 - 1, Random.random() * 2 - 1);
		while (Vector.length(xrnd) > 1);

		return xrnd;
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