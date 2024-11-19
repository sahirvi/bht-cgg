package a11;

import java.util.ArrayList;
import cgtools.*;

public class Raytracer implements Sampler {
	public final PinholeCamera camera;
	public final Group scene;
	public final ArrayList <Light> lights;

	public Raytracer(PinholeCamera camera, Group scene, ArrayList <Light> lights) {
		this.camera = camera;
		this.scene = scene;
		this.lights = lights;
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
			Color radiance = calculateRadiance(scatteredRay, scene, depth - 1);
			Color emission = properties.emission(ray, hit);
			Color albedo = properties.albedo(ray, hit);
			radiance = Color.add(emission, Color.multiply(radiance, albedo));

			if (hit.material instanceof DiffusesMaterial) {
				for (Light light : lights) {
					if (light.isVisible(hit.x, scene)) {
						Color l = light.radiance(hit.x);
						Color lr = Color.multiply(albedo, Color.multiply(l,
								Vector.dotProduct(Vector.normalize(light.direction(hit.x)), hit.normal)));
						radiance = Color.add(lr, radiance);
					}
				}
			}
			return radiance;
		} else {
			return properties.emission(ray, hit);
		}
	}
}
