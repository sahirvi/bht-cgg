package a10;

import cgtools.*;

import java.io.IOException;

public class A10 {

	public static void main(String[] args) throws IOException {
		final int width = 750;
		final int height = 450;
		final String filename1 = "doc/a10-1.png";
		final String filename2 = "doc/a10-2.png";

		Matrix matrix1 = Matrix.multiply(Matrix.rotation(1, 0, 0, -1), Matrix.translation(0, 0, 100));
		PinholeCamera camera1 = new PinholeCamera(Math.PI / 3, width, height, matrix1);
		Matrix matrix2 = Matrix.multiply(Matrix.rotation(1, 0, 0, -90), Matrix.translation(0, 1, 75));
		PinholeCamera camera2 = new PinholeCamera(Math.PI / 3, width, height, matrix2);

		Constant silver = new Constant(new Color(0.8, 0.8, 0.8));
		Constant fireBrick = new Constant(new Color(1, 0.19, 0.19));
		Constant white = new Constant(Color.white);

		Texture background = new Texture("doc/background.jpg");
		BackgroundMaterial backgroundMaterial = new BackgroundMaterial(background);

		Texture earth = new Texture("doc/earth.png");
		DiffusesMaterial diffusesMaterial = new DiffusesMaterial(earth);

		CheckerBoard checkerBoard = new CheckerBoard(100000);
		DiffusesMaterial diffusesMaterial2 = new DiffusesMaterial(checkerBoard);

		Matrix matrix = Matrix.scaling(16, 8, 0);
		PolkaDots polkaDots = new PolkaDots(silver, fireBrick, 0.5);
		TextureTransform transform = new TextureTransform(polkaDots, matrix);

		Group group = new Group(new Background(backgroundMaterial),
				new Plane(Vector.point(0.0, 0, 0.0), Vector.direction(0, 1, 0), 100000, diffusesMaterial2),
				new Sphere(Vector.point(10, 7, 0), 5, diffusesMaterial),
				new Sphere(Vector.point(-5, 7, 0), 5, new DiffusesMaterial(transform)),
				new Sphere(Vector.point(-20, 7, 0), 5, new ReflectiveMaterial(white, 0.2)),
				new Sphere(Vector.point(25, 7, 0), 5, new TransparentMaterial(white, 1.5))
				
						);
				

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
