package a10;

import cgtools.*;

public class Raytracer implements Sampler {
	PinholeCamera camera;
	Group scene;

	public Raytracer(PinholeCamera camera, Group scene) {
		this.camera = camera;
		this.scene = scene;
	}

	@Override
	public Color getColor(double x, double y) { // Raytracing Algorithmus
		Ray ray = camera.genRay(x, y); // generiert Ray durch die Pixel

		Color color = calculateRadiance(ray, scene, 10);
		return color;
	}

	Color calculateRadiance(Ray ray, Shape scene, int depth) {
		if (depth == 0) {
			return Color.black;
		}

		Hit hit = scene.intersect(ray);

		Material properties = hit.material;
		Ray scatteredRay = properties.scatteredRay(ray, hit);

		if (scatteredRay != null) {
			Color emission = properties.emission(ray, hit);
			Color albedo = properties.albedo(ray, hit);
			
			Color add = Color.add(albedo, emission);
			
			return Color.multiply(add, calculateRadiance(scatteredRay, scene, depth - 1));
		} else {
			return properties.emission(ray, hit);
		}
	}
}
