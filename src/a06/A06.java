package a06;

import cgtools.*;

public class A06 {

	public static void main(String[] args) {
		final int width = 1500;
		final int height = 900;
		final String filename1 = "doc/a06-mirrors-glass-1.png";
		final String filename2 = "doc/a06-mirrors-glass-2.png";

		PinholeCamera camera = new PinholeCamera(Math.PI / 3, width, height);

		Color fireBrick = new Color(1, 0.19, 0.19);
		Color dodgerBlue = new Color(0.11, 0.53, 0.93);
		Color darkviolet = new Color(0.6, 0, 0.8);

		Color silver = new Color(0.8, 0.8, 0.8);
		final Group group1 = new Group(new Background(new BackgroundMaterial()),
				new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0, 1, 0), new DiffusesMaterial(silver)),
				new Sphere(Vector.point(-1.0, 0.1, -3), 0.5, new ReflectiveMaterial(Color.white, 0)),
				new Sphere(Vector.point(0.0, 0.1, -3), 0.5, new DiffusesMaterial(fireBrick)),
				new Sphere(Vector.point(1.0, 0.1, -3), 0.5, new ReflectiveMaterial(Color.white, 0.2))

		);

		final Group group2 = new Group(new Background(new BackgroundMaterial()),
				new Plane(Vector.point(0.0, -0.5, 0.0), Vector.direction(0, 1, 0), new DiffusesMaterial(silver)),
				new Sphere(Vector.point(0.0, 0.2, -4), 0.7, new TransparentMaterial(Color.white, 1.5)),
				new Sphere(Vector.point(0.0, -0.34, -2), 0.15, new DiffusesMaterial(dodgerBlue)),
				new Sphere(Vector.point(0.5, -0.34, -3), 0.15, new DiffusesMaterial(dodgerBlue)),
				new Sphere(Vector.point(-0.5, -0.34, -3), 0.15, new DiffusesMaterial(dodgerBlue)),
				new Sphere(Vector.point(1.0, -0.34, -4), 0.15, new DiffusesMaterial(dodgerBlue)),
				new Sphere(Vector.point(-1.0, -0.34, -4), 0.15, new DiffusesMaterial(dodgerBlue)),
				new Sphere(Vector.point(0.5, -0.34, -5), 0.15, new DiffusesMaterial(darkviolet)),
				new Sphere(Vector.point(-0.5, -0.34, -5), 0.15, new DiffusesMaterial(dodgerBlue)),
				new Sphere(Vector.point(0.0, -0.34, -6), 0.15, new DiffusesMaterial(dodgerBlue))
		);

		Image image1 = new Image(width, height);
		Image image2 = new Image(width, height);
		Raytracer raytracer1 = new Raytracer(camera, group1);
		Raytracer raytracer2 = new Raytracer(camera, group2);
		image1.sample(raytracer1, 10);
		image1.write(filename1);
		image2.sample(raytracer2, 10);
		image2.write(filename2);
		System.out.println("Wrote image: " + filename1);
		System.out.println("Wrote image: " + filename2);
	}

}
