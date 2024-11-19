package a05;

import cgtools.*;

public class A05 {

	public static void main(String[] args) {
		final int width = 1500;
		final int height = 900;
		final String filename = "doc/a05-diffuse-spheres.png";

		PinholeCamera camera = new PinholeCamera(Math.PI / 3, width, height);
		Color gold = new Color(1, 0.5, 0);
		Color darkviolet = new Color(0.6, 0, 0.8);
		Color cyan = new Color(0, 1, 1);
		Color orangeRed = new Color(1, 0.27, 0);
		Color springGreen = new Color(0, 1, 0.49);
		Color brown = new Color(0.64, 0.16, 0.16);
		Color dodgerBlue = new Color(0.11, 0.53, 0.93);
		Color fireBrick = new Color(1, 0.19, 0.19);
		Color grey = new Color(0.14, 0.14, 0.14);
		Color chocolate = new Color(0.82, 0.41, 0.12);

		Color silver = new Color(0.8, 0.8, 0.8);
		final Group group = new Group(new Background(new BackgroundMaterial()),
				new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0, 1, 0), new DiffusesMaterial(silver)),
				new Sphere(Vector.point(-2.0, 0.3, -4), 0.8, new DiffusesMaterial(gold)),
				new Sphere(Vector.point(1.0, -0.2, -2), 0.3, new DiffusesMaterial(darkviolet)),
				new Sphere(Vector.point(-1.0, -0.4, -3), 0.1, new DiffusesMaterial(cyan)),
				new Sphere(Vector.point(-0.5, 0.4, -6), 0.9, new DiffusesMaterial(orangeRed)),
				new Sphere(Vector.point(-1.5, 0.8, -8), 1.5, new DiffusesMaterial(springGreen)),
				new Sphere(Vector.point(-1.0, -0.1, -5), 0.4, new DiffusesMaterial(brown)),
				new Sphere(Vector.point(-0.2, -0.3, -2), 0.2, new DiffusesMaterial(dodgerBlue)),
				new Sphere(Vector.point(1.4, 1.5, -9), 2, new DiffusesMaterial(fireBrick)),
				new Sphere(Vector.point(1.0, 0.0, -4), 0.5, new DiffusesMaterial(grey)),
				new Sphere(Vector.point(0.3, -0.43, -2), 0.08, new DiffusesMaterial(chocolate))
		);

		Image image = new Image(width, height);
		Raytracer raytracer = new Raytracer(camera, group);
		image.sample(raytracer, 10);
		image.write(filename);
		System.out.println("Wrote image: " + filename);
	}

}
