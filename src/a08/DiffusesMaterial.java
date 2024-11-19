package a08;

import cgtools.*;

public class DiffusesMaterial implements Material {

	public Color albedo;

	public DiffusesMaterial(Color albedo) {
		this.albedo = albedo;
	}

	public Boolean absorb() {
		return true;
	}

	public Ray scatteredRay(Ray ray, Hit hit) {
		Direction d = Vector.normalize(Vector.add(randomDir(), hit.normal)); // d = nhit + r
		return new Ray(hit.x, d, Util.EPSILON, Double.POSITIVE_INFINITY); // x0 = xhit
	}

	public Color albedo(Ray ray, Hit hit) {
		return albedo;
	}

	public Color emission(Ray ray, Hit hit) {
		return Color.black; // keine Emission
	}

	Direction randomDir() {
		Direction rnd;
		do
			rnd = Vector.direction(Random.random() * 2 - 1, Random.random() * 2 - 1, Random.random() * 2 - 1);
		while (Vector.length(rnd) > 1);

		return rnd;
	}
}
