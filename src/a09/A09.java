package a09;

import cgtools.*;

public class A09 {

	public static void main(String[] args) {
		final int width = 750;
		final int height = 450;
		final String filename1 = "doc/a09-benchmark-scene.png";

		Matrix matrix1 = Matrix.multiply(Matrix.rotation(1, 1, 0, -1), Matrix.translation(0, 0, 100));
		PinholeCamera camera1 = new PinholeCamera(Math.PI / 3, width, height, matrix1);

		Color silver = new Color(0.8, 0.8, 0.8);

		final Group stange = new Group(Matrix.rotation(0, 0, 1, 90),
				new CappedCylinder(Vector.point(0, 0, 0), 42, 1, new ReflectiveMaterial(silver, 0.0)));

		final Group stange1 = new Group(Matrix.translation(21, 25, 15), stange);

		final Group stange2 = new Group(Matrix.translation(0, 0, -30), stange1);

		final Group geruest = new Group(
				new CappedCylinder(Vector.point(20, 0, 15), 25, 1, new ReflectiveMaterial(silver, 0.0)),
				new CappedCylinder(Vector.point(-20, 0, 15), 25, 1, new ReflectiveMaterial(silver, 0.0)),
				new CappedCylinder(Vector.point(20, 0, -15), 25, 1, new ReflectiveMaterial(silver, 0.0)),
				new CappedCylinder(Vector.point(-20, 0, -15), 25, 1, new ReflectiveMaterial(silver, 0.0)), stange1,
				stange2);

		final Group seil1 = new Group(Matrix.rotation(1, 0, 0, 37),
				new CappedCylinder(Vector.point(0, 6, -4.5), 23, 0.1, new ReflectiveMaterial(silver, 0.0)));

		final Group seil6 = new Group(Matrix.rotation(1, 0, 0, -37),
				new CappedCylinder(Vector.point(0, 6, 4.5), 23, 0.1, new ReflectiveMaterial(silver, 0.0)));

		final Group seil2 = new Group(Matrix.translation(5, 0, 0), seil1, seil6);

		final Group seil3 = new Group(Matrix.translation(10, 0, 0), seil1, seil6);
		final Group seil4 = new Group(Matrix.translation(-5, 0, 0), seil1, seil6);
		final Group seil5 = new Group(Matrix.translation(-10, 0, 0), seil1, seil6);

		final Group seile = new Group(seil1, seil2, seil3, seil4, seil5, seil6);

		final Group kugeln = new Group(new Sphere(Vector.point(0.0, 5, 0.0), 2.5, new ReflectiveMaterial(silver, 0.0)),
				new Sphere(Vector.point(-5.1, 5, 0), 2.5, new ReflectiveMaterial(silver, 0.0)),
				new Sphere(Vector.point(5.1, 5, 0), 2.5, new ReflectiveMaterial(silver, 0.0)),
				new Sphere(Vector.point(-10.2, 5, 0), 2.5, new ReflectiveMaterial(silver, 0.0)),
				new Sphere(Vector.point(10.2, 5, 0), 2.5, new ReflectiveMaterial(silver, 0.0)));
		final Group zylinder = new Group(
				new CappedCylinder(Vector.point(0, 7.5, 0), 0.2, 0.4, new ReflectiveMaterial(silver, 0.0)),
				new CappedCylinder(Vector.point(5, 7.5, 0), 0.2, 0.4, new ReflectiveMaterial(silver, 0.0)),
				new CappedCylinder(Vector.point(-5, 7.5, 0), 0.2, 0.4, new ReflectiveMaterial(silver, 0.0)),
				new CappedCylinder(Vector.point(10, 7.5, 0), 0.2, 0.4, new ReflectiveMaterial(silver, 0.0)),
				new CappedCylinder(Vector.point(-10, 7.5, 0), 0.2, 0.4, new ReflectiveMaterial(silver, 0.0)));

		final Group kleineKugeln = new Group(
				new Sphere(Vector.point(0, 25, 16), 0.2, new ReflectiveMaterial(silver, 0.0)),
				new Sphere(Vector.point(5, 25, 16), 0.2, new ReflectiveMaterial(silver, 0.0)),
				new Sphere(Vector.point(-5, 25, 16), 0.2, new ReflectiveMaterial(silver, 0.0)),
				new Sphere(Vector.point(10, 25, 16), 0.2, new ReflectiveMaterial(silver, 0.0)),
				new Sphere(Vector.point(-10, 25, 16), 0.2, new ReflectiveMaterial(silver, 0.0)));

		final Group kleineKugeln2 = new Group(Matrix.translation(0, 0, -32), kleineKugeln);

		final Group newtonsWiege = new Group(geruest, seile, kugeln, kleineKugeln, kleineKugeln2, zylinder);

		final Group nW = new Group(Matrix.translation(50, 0, -50), newtonsWiege);

		final Group group = new Group(new Background(new BackgroundMaterial()),
				new Plane(Vector.point(0.0, 0, 0.0), Vector.direction(0, 1, 0), new DiffusesMaterial(silver)),
				newtonsWiege, nW);

		Image image1 = new Image(width, height);
		Raytracer raytracer1 = new Raytracer(camera1, group);
		image1.sample(raytracer1, 10);
		image1.write(filename1);
		System.out.println("Wrote image: " + filename1);
	}
}
