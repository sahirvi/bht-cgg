package a07;

import cgtools.*;

public class A07 {

	public static void main(String[] args) {
		final int width = 1500;
		final int height = 900;
		final String filename1 = "doc/a07-1.png";
		final String filename2 = "doc/a07-2.png";

		Matrix matrix1 = Matrix.multiply(Matrix.rotation(1, 1, 0, -10), Matrix.translation(0, 0, 100));
		PinholeCamera camera1 = new PinholeCamera(Math.PI / 3, width, height, matrix1);
		Matrix matrix2 = Matrix.multiply(Matrix.rotation(1, 0, 0, -90), Matrix.translation(0, 1, 100));
		PinholeCamera camera2 = new PinholeCamera(Math.PI / 3, width, height, matrix2);

		Color gold = new Color(1, 0.5, 0);
		Color silver = new Color(0.8, 0.8, 0.8);
		Color darksilver = new Color(0.9, 0.9, 0.9);
		Color fireBrick = new Color(1, 0.19, 0.19);

		// habe versucht, das hier nachzustellen: https://www.istockphoto.com/de/foto/revolver-zylinder-mit-kugeln-gm490273500-75114131
		final Group group = new Group(new Background(new BackgroundMaterial()),
				new Plane(Vector.point(0.0, 0, 0.0), Vector.direction(0, 1, 0), new DiffusesMaterial(silver)),
				new CappedCylinder(Vector.point(0, 0, 0), 20, 10, new ReflectiveMaterial(silver, 0.2)),
				new CappedCylinder(Vector.point(0, 0, 0), 20.5, 2.5, new DiffusesMaterial(Color.black)),
				new CappedCylinder(Vector.point(0, 0, 0), 21.5, 1.5, new DiffusesMaterial(Color.black)),

				new CappedCylinder(Vector.point(15, 2, 0), 11, 2.5, new ReflectiveMaterial(gold, 0.2)),
				new CappedCylinder(Vector.point(15, 1, 0), 1, 1.5, new ReflectiveMaterial(gold, 0.2)),
				new CappedCylinder(Vector.point(15, 0, 0), 1, 2.5, new ReflectiveMaterial(gold, 0.2)),
				new Sphere(Vector.point(15, 14, 0), 2.5, new ReflectiveMaterial(silver, 0.2)),

				new CappedCylinder(Vector.point(-15, 2, 0), 11, 2.5, new ReflectiveMaterial(gold, 0.2)),
				new CappedCylinder(Vector.point(-15, 1, 0), 1, 1.5, new ReflectiveMaterial(gold, 0.2)),
				new CappedCylinder(Vector.point(-15, 0, 0), 1, 2.5, new ReflectiveMaterial(gold, 0.2)),
				new Sphere(Vector.point(-15, 14, 0), 2.5, new ReflectiveMaterial(silver, 0.2)),

				new CappedCylinder(Vector.point(0, 2, -15), 11, 2.5, new ReflectiveMaterial(gold, 0.2)),
				new CappedCylinder(Vector.point(0, 1, -15), 1, 1.5, new ReflectiveMaterial(gold, 0.2)),
				new CappedCylinder(Vector.point(0, 0, -15), 1, 2.5, new ReflectiveMaterial(gold, 0.2)),
				new Sphere(Vector.point(0, 14, -15), 2.5, new ReflectiveMaterial(silver, 0.2)),

				new CappedCylinder(Vector.point(0, 2, 15), 11, 2.5, new ReflectiveMaterial(gold, 0.2)),
				new CappedCylinder(Vector.point(0, 1, 15), 1, 1.5, new ReflectiveMaterial(gold, 0.2)),
				new CappedCylinder(Vector.point(0, 0, 15), 1, 2.5, new ReflectiveMaterial(gold, 0.2)),
				new Sphere(Vector.point(0, 14, 15), 2.5, new ReflectiveMaterial(silver, 0.2)));

		int amount = 6;
		int radius = 6;
		for (int i = 0; i < amount; i++) {
			double x = radius * Math.cos(i * (2 * Math.PI) / amount);
			double z = radius * Math.sin(i * (2 * Math.PI) / amount);

			group.addShape(new CappedCylinder(Vector.point(x, 10.1, z), 10, 2.5, new ReflectiveMaterial(gold, 0.2)));
			group.addShape(
					new CappedCylinder(Vector.point(x, 10.1, z), 10.1, 1.5, new ReflectiveMaterial(fireBrick, 0.2)));
			group.addShape(
					new CappedCylinder(Vector.point(x, 10.1, z), 10.2, 1.3, new ReflectiveMaterial(silver, 0.2)));
		}

		int amount1 = 6;
		double radius1 = 8.4;
		for (int i = 0; i < amount; i++) {
			double x = radius1 * Math.cos(i * (2 * Math.PI) / amount1);
			double z = radius1 * Math.sin(i * (2 * Math.PI) / amount1);

			group.addShape(new CappedCylinder(Vector.point(x, 0, z), 15, 2.2, new TransparentMaterial(darksilver, 0)));
		}

		Image image1 = new Image(width, height);
		Image image2 = new Image(width, height);
		Raytracer raytracer1 = new Raytracer(camera1, group);
		Raytracer raytracer2 = new Raytracer(camera2, group);
		image1.sample(raytracer1, 10);
		image1.write(filename1);
		image2.sample(raytracer2, 10);
		image2.write(filename2);
		System.out.println("Wrote image: " + filename1);
		System.out.println("Wrote image: " + filename2);
	}
}
