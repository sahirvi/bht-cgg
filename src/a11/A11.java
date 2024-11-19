package a11;

import cgtools.*;

import java.io.IOException;
import java.util.ArrayList;

public class A11 {

	public static void main(String[] args) throws IOException {
		final int width = 750;
		final int height = 450;
		final String filename1 = "doc/a11-1.png";
		final String filename2 = "doc/a11-2.png";

		Matrix matrix1 = Matrix.multiply(Matrix.rotation(1, 0, 0, -1), Matrix.translation(0, 0, 100));
		PinholeCamera camera1 = new PinholeCamera(Math.PI / 3, width, height, matrix1);

		Constant silver = new Constant(new Color(0.8, 0.8, 0.8));
		Constant fireBrick = new Constant(new Color(1, 0.19, 0.19));

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
				new Sphere(Vector.point(-5, 7, 0), 5, new DiffusesMaterial(transform))

		);

		Color sunlow = new Color(2.43, 1.9, 0.24);
		Color sun = new Color(243, 159, 24);
		Light pl = new PointLight(Vector.point(10, 12, 5), sun);
		Light dl = new DirectionalLight(Vector.direction(10, 5, 3), sunlow);
		ArrayList<Light> lightspl = new ArrayList<>();
		ArrayList<Light> lightsdl = new ArrayList<>();
		lightspl.add(pl);
		lightsdl.add(dl);

		Image image1 = new Image(width, height);
		Image image2 = new Image(width, height);
		Raytracer raytracer1 = new Raytracer(camera1, group, lightspl);
		Raytracer raytracer2 = new Raytracer(camera1, group, lightsdl);
		image1.sample(raytracer1, 10);
		image1.write(filename1);
		image2.sample(raytracer2, 10);
		image2.write(filename2);
		System.out.println("Wrote image: " + filename1);
		System.out.println("Wrote image: " + filename2);

	}
}
