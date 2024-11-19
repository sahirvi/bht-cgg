package a05;

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
		Direction r = null;
		double x = Random.random(); // zwischen 0 und 1
		double y = Random.random(); // zwischen 0 und 1
		double z = Random.random(); // zwischen 0 und 1
//
//		if ((x * x) + (y * y) + (z * z - 0.3) <= 1) {
//			r = Vector.direction(x, y, z);
//		} else {
//			return null;
//		}
		r = Vector.direction(x * 2 - 1, y * 2 - 1, z * 2 - 1); // um Werte im Bereich von -1 und 1 zu bekommen
		Direction d = Vector.normalize(Vector.add(r, hit.normal)); // d = nhit + r
		return new Ray(hit.x, d); // x0 = xhit

	}

	public Color albedo(Ray ray, Hit hit) {
		return albedo;
	}

	public Color emission(Ray ray, Hit hit) {
		return Color.black; // keine Emission
	}
}
