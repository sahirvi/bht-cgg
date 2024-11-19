package a10;

import cgtools.*;

public class DiffusesMaterial implements Material {

	public Sampler texture;
	
	public Color albedo;
	
	public DiffusesMaterial(Sampler texture) {
		this.texture = texture;
	}

	public Boolean absorb() {
		return true;
	}

	public Ray scatteredRay(Ray ray, Hit hit) {
		Direction d = Vector.normalize(Vector.add(randomDir(), hit.normal)); // d = nhit + r
		return new Ray(hit.x, d, Util.EPSILON, Double.POSITIVE_INFINITY); // x0 = xhit
	}

	public Color albedo(Ray ray, Hit hit) {
		return texture.getColor(hit.u,hit.v);
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
