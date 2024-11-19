package a04;

import cgtools.*;

public class A04 {

	public static void main(String[] args) {
		final int width = 1500;
		final int height = 900;
		final String filename = "doc/a04-3-spheres.png";
		final String filenameScene = "doc/a04-scene.png";

		final PinholeCamera camera = new PinholeCamera((Math.PI / 2), width, height);
		final Color darkgrey = new Color(0.3, 0.3, 0.3);
		final Color silver = new Color(0.5, 0.5, 0.5);
		final Color lightblue = new Color(0, 0.5, 1);
		final Group threespheres = 
			new Group(
				new Background(darkgrey),
				new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0, 1, 0), Color.gray),
				new Sphere(Vector.point(-1.0, -0.25, -2.5), 0.7, Color.red),
				new Sphere(Vector.point(0.0, -0.25, -2.5), 0.5, Color.green),
				new Sphere(Vector.point(1.0, -0.25, -2.5), 0.7, Color.blue));
		
		final Group scene = 
			new Group(
				new Background(lightblue),
				new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0, 1, 0), Color.white),

				new Sphere(Vector.point(-0.81, -0.6, -3.4), 0.2, silver),
				new Sphere(Vector.point(-0.4, -0.6, -3.4), 0.2, silver),
				new Sphere(Vector.point(0.0, -0.6, -3.4), 0.2, silver),
				new Sphere(Vector.point(0.4, -0.6, -3.4), 0.2, silver),
				new Sphere(Vector.point(0.81, -0.6, -3.4), 0.2, silver),
				new Sphere(Vector.point(-0.81, -0.17, -3.4), 0.2, silver),
				new Sphere(Vector.point(-0.4, -0.17, -3.4), 0.2, silver),
				new Sphere(Vector.point(0.0, -0.17, -3.4), 0.2, silver),
				new Sphere(Vector.point(0.4, -0.17, -3.4), 0.2, silver),
				new Sphere(Vector.point(0.81, -0.17, -3.4), 0.2, silver),
				new Sphere(Vector.point(-0.81, 0.26, -3.4), 0.2, silver),
				new Sphere(Vector.point(-0.4, 0.26, -3.4), 0.2, silver),
				new Sphere(Vector.point(0.0, 0.26, -3.4), 0.2, silver),
				new Sphere(Vector.point(0.4, 0.26, -3.4), 0.2, silver),
				new Sphere(Vector.point(0.81, 0.26, -3.4), 0.2, silver),
				new Sphere(Vector.point(-0.81, 0.69, -3.4), 0.2, silver),
				new Sphere(Vector.point(-0.4, 0.69, -3.4), 0.2, silver),
				new Sphere(Vector.point(0.0, 0.69, -3.4), 0.2, silver),
				new Sphere(Vector.point(0.4, 0.69, -3.4), 0.2, silver),
				new Sphere(Vector.point(0.81, 0.69, -3.4), 0.2, silver),
				new Sphere(Vector.point(-0.81, 1.12, -3.4), 0.2, silver),
				new Sphere(Vector.point(-0.4, 1.12, -3.4), 0.2, silver),
				new Sphere(Vector.point(0.0, 1.12, -3.4), 0.2, silver),
				new Sphere(Vector.point(0.4, 1.12, -3.4), 0.2, silver),
				new Sphere(Vector.point(0.81, 1.12, -3.4), 0.2, silver),

				new Sphere(Vector.point(-0.81, -0.6, -3.2), 0.2, silver),
				new Sphere(Vector.point(-0.4, -0.6, -3.2), 0.2, silver),
				new Sphere(Vector.point(0.0, -0.6, -3.2), 0.2, silver),
				new Sphere(Vector.point(0.4, -0.6, -3.2), 0.2, silver),
				new Sphere(Vector.point(0.81, -0.6, -3.2), 0.2, silver),
				new Sphere(Vector.point(-0.81, -0.17, -3.2), 0.2, silver),
				new Sphere(Vector.point(-0.4, -0.17, -3.2), 0.2, silver),
				new Sphere(Vector.point(0.0, -0.17, -3.2), 0.2, silver),
				new Sphere(Vector.point(0.4, -0.17, -3.2), 0.2, silver),
				new Sphere(Vector.point(0.81, -0.17, -3.2), 0.2, silver),
				new Sphere(Vector.point(-0.81, 0.26, -3.2), 0.2, silver),
				new Sphere(Vector.point(-0.4, 0.26, -3.2), 0.2, silver),
				new Sphere(Vector.point(0.0, 0.26, -3.2), 0.2, silver),
				new Sphere(Vector.point(0.4, 0.26, -3.2), 0.2, silver),
				new Sphere(Vector.point(0.81, 0.26, -3.2), 0.2, silver),
				new Sphere(Vector.point(-0.81, 0.69, -3.2), 0.2, silver),
				new Sphere(Vector.point(-0.4, 0.69, -3.2), 0.2, silver),
				new Sphere(Vector.point(0.0, 0.69, -3.2), 0.2, silver),
				new Sphere(Vector.point(0.4, 0.69, -3.2), 0.2, silver),
				new Sphere(Vector.point(0.81, 0.69, -3.2), 0.2, silver),
				new Sphere(Vector.point(-0.81, 1.12, -3.2), 0.2, silver),
				new Sphere(Vector.point(-0.4, 1.12, -3.2), 0.2, silver),
				new Sphere(Vector.point(0.0, 1.12, -3.2), 0.2, silver),
				new Sphere(Vector.point(0.4, 1.12, -3.2), 0.2, silver),
				new Sphere(Vector.point(0.81, 1.12, -3.2), 0.2, silver),

				new Sphere(Vector.point(-0.81, -0.6, -2.5), 0.2, silver),
				new Sphere(Vector.point(-0.4, -0.6, -2.5), 0.2, silver),
				new Sphere(Vector.point(0.0, -0.6, -2.5), 0.2, silver),
				new Sphere(Vector.point(0.4, -0.6, -2.5), 0.2, silver),
				new Sphere(Vector.point(0.81, -0.6, -2.5), 0.2, silver),
				new Sphere(Vector.point(-0.81, -0.17, -2.5), 0.2, silver),
				new Sphere(Vector.point(-0.4, -0.17, -2.5), 0.2, silver),
				new Sphere(Vector.point(0.0, -0.17, -2.5), 0.2, silver),
				new Sphere(Vector.point(0.4, -0.17, -2.5), 0.2, silver),
				new Sphere(Vector.point(0.81, -0.17, -2.5), 0.2, silver),
				new Sphere(Vector.point(-0.81, 0.26, -2.5), 0.2, silver),
				new Sphere(Vector.point(-0.4, 0.26, -2.5), 0.2, silver),
				new Sphere(Vector.point(0.0, 0.26, -2.5), 0.2, silver),
				new Sphere(Vector.point(0.4, 0.26, -2.5), 0.2, silver),
				new Sphere(Vector.point(0.81, 0.26, -2.5), 0.2, silver),
				new Sphere(Vector.point(-0.81, 0.69, -2.5), 0.2, silver),
				new Sphere(Vector.point(-0.4, 0.69, -2.5), 0.2, silver),
				new Sphere(Vector.point(0.0, 0.69, -2.5), 0.2, silver),
				new Sphere(Vector.point(0.4, 0.69, -2.5), 0.2, silver),
				new Sphere(Vector.point(0.81, 0.69, -2.5), 0.2, silver),
				new Sphere(Vector.point(-0.81, 1.12, -2.5), 0.2, silver),
				new Sphere(Vector.point(-0.4, 1.12, -2.5), 0.2, silver),
				new Sphere(Vector.point(0.0, 1.12, -2.5), 0.2, silver),
				new Sphere(Vector.point(0.4, 1.12, -2.5), 0.2, silver),
				new Sphere(Vector.point(0.81, 1.12, -2.5), 0.2, silver),

				new Sphere(Vector.point(-0.81, -0.6, -2.3), 0.2, silver),
				new Sphere(Vector.point(-0.4, -0.6, -2.3), 0.2, silver),
				new Sphere(Vector.point(0.0, -0.6, -2.3), 0.2, silver),
				new Sphere(Vector.point(0.4, -0.6, -2.3), 0.2, silver),
				new Sphere(Vector.point(0.81, -0.6, -2.3), 0.2, silver),
				new Sphere(Vector.point(-0.81, -0.17, -2.3), 0.2, silver),
				new Sphere(Vector.point(-0.4, -0.17, -2.3), 0.2, silver),
				new Sphere(Vector.point(0.0, -0.17, -2.3), 0.2, silver),
				new Sphere(Vector.point(0.4, -0.17, -2.3), 0.2, silver),
				new Sphere(Vector.point(0.81, -0.17, -2.3), 0.2, silver),
				new Sphere(Vector.point(-0.81, 0.26, -2.3), 0.2, silver),
				new Sphere(Vector.point(-0.4, 0.26, -2.3), 0.2, silver),
				new Sphere(Vector.point(0.0, 0.26, -2.3), 0.2, silver),
				new Sphere(Vector.point(0.4, 0.26, -2.3), 0.2, silver),
				new Sphere(Vector.point(0.81, 0.26, -2.3), 0.2, silver),
				new Sphere(Vector.point(-0.81, 0.69, -2.3), 0.2, silver),
				new Sphere(Vector.point(-0.4, 0.69, -2.3), 0.2, silver),
				new Sphere(Vector.point(0.0, 0.69, -2.3), 0.2, silver),
				new Sphere(Vector.point(0.4, 0.69, -2.3), 0.2, silver),
				new Sphere(Vector.point(0.81, 0.69, -2.3), 0.2, silver),
				new Sphere(Vector.point(-0.81, 1.12, -2.3), 0.2, silver),
				new Sphere(Vector.point(-0.4, 1.12, -2.3), 0.2, silver),
				new Sphere(Vector.point(0.0, 1.12, -2.3), 0.2, silver),
				new Sphere(Vector.point(0.4, 1.12, -2.3), 0.2, silver),
				new Sphere(Vector.point(0.81, 1.12, -2.3), 0.2, silver),

				new Sphere(Vector.point(-0.81, -0.6, -2.1), 0.2, silver),
				new Sphere(Vector.point(-0.4, -0.6, -2.1), 0.2, silver),
				new Sphere(Vector.point(0.0, -0.6, -2.1), 0.2, silver),
				new Sphere(Vector.point(0.4, -0.6, -2.1), 0.2, silver),
				new Sphere(Vector.point(0.81, -0.6, -2.1), 0.2, silver),
				new Sphere(Vector.point(-0.81, -0.17, -2.1), 0.2, silver),
				new Sphere(Vector.point(-0.4, -0.17, -2.1), 0.2, silver),
				new Sphere(Vector.point(0.0, -0.17, -2.1), 0.2, silver),
				new Sphere(Vector.point(0.4, -0.17, -2.1), 0.2, silver),
				new Sphere(Vector.point(0.81, -0.17, -2.1), 0.2, silver),
				new Sphere(Vector.point(-0.81, 0.26, -2.1), 0.2, silver),
				new Sphere(Vector.point(-0.4, 0.26, -2.1), 0.2, silver),
				new Sphere(Vector.point(0.0, 0.26, -2.1), 0.2, silver),
				new Sphere(Vector.point(0.4, 0.26, -2.1), 0.2, silver),
				new Sphere(Vector.point(0.81, 0.26, -2.1), 0.2, silver),
				new Sphere(Vector.point(-0.81, 0.69, -2.1), 0.2, silver),
				new Sphere(Vector.point(-0.4, 0.69, -2.1), 0.2, silver),
				new Sphere(Vector.point(0.0, 0.69, -2.1), 0.2, silver),
				new Sphere(Vector.point(0.4, 0.69, -2.1), 0.2, silver),
				new Sphere(Vector.point(0.81, 0.69, -2.1), 0.2, silver),
				new Sphere(Vector.point(-0.81, 1.12, -2.1), 0.2, silver),
				new Sphere(Vector.point(-0.4, 1.12, -2.1), 0.2, silver),
				new Sphere(Vector.point(0.0, 1.12, -2.1), 0.2, silver),
				new Sphere(Vector.point(0.4, 1.12, -2.1), 0.2, silver),
				new Sphere(Vector.point(0.81, 1.12, -2.1), 0.2, silver));

		class Raytracer implements Sampler {
			PinholeCamera camera;
			Group scene;

			public Raytracer(PinholeCamera camera, Group scene) {
				this.camera = camera;
				this.scene = scene;
			}

			@Override
			public Color getColor(double x, double y) { // Raytracing Algorithmus
				Ray ray = camera.genRay(x, y); // generiert Ray durch die Pixel
				Hit hit = scene.intersect(ray);

				return Util.shade(hit.n, hit.c);
			}
		}

		Image image = new Image(width, height);
		Image imageScene = new Image(width, height);
		Raytracer raytracer = new Raytracer(camera, threespheres);
		Raytracer raytracer1 = new Raytracer(camera, scene);
		image.sample(raytracer, 10);
		imageScene.sample(raytracer1, 10);
		image.write(filename);
		imageScene.write(filenameScene);
		System.out.println("Wrote image: " + filename);
		System.out.println("Wrote image: " + filenameScene);
	}
}