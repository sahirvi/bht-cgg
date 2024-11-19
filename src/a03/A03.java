package a03;

import cgtools.*;

public class A03 {
	
	public static void main(String[] args) {
		final int width = 1280;
		final int height = 720;
		final String filename = "doc/a03-three-spheres.png";

		Image image = new Image(width, height);
		PinholeCamera camera = new PinholeCamera((Math.PI/4), width, height);
		RaytraceSpheres spheres = new RaytraceSpheres(camera, Color.black);
		
		spheres.add(new Sphere(Vector.point(-2, 0, -12), 2.5, Color.gray));
		spheres.add(new Sphere(Vector.point( 0, 0, -13), 2.2, Color.white));
		spheres.add(new Sphere(Vector.point( 2, 0, -14), 1.8, Color.red));
		
		int n = 10; // samples
		for (int x = 0; x != width; x++) {
			for (int y = 0; y != height; y++) {
				Color color = new Color(0, 0, 0);
				for(int xi = 0; xi != n; xi++) {
					for(int yi = 0; yi != n; yi++) {
						double rx = Random.random();
						double ry = Random.random();
						double xs = x + (xi + rx) / n;
						double ys = y + (yi + ry) / n;
						color = Color.add(color, spheres.getColor(xs, ys));
					}
				}	
				image.setPixel(x, y, Color.divide(color, n * n));
			}
		}
		image.write(filename);
		System.out.println("Wrote image: " + filename);
	}
}