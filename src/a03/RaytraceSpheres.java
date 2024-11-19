package a03;

import java.util.ArrayList;

import cgtools.*;

public class RaytraceSpheres {

	public final PinholeCamera pinholecamera;
	public final Color background;
	private ArrayList<Sphere> spheres;

	public RaytraceSpheres(PinholeCamera camera, Color background) {
		this.pinholecamera = camera;
		this.background = background;
		this.spheres = new ArrayList<Sphere>();
	}

	public Color getColor(double x, double y) { // Raytracing Algorithmus
		Ray ray = pinholecamera.genRay(x, y); // generiert Ray durch die Pixel
		double t = Double.POSITIVE_INFINITY;
		Direction normal = null; // normal für shade-Methode
		Color color = null; // color für shade-Methode

		for (Sphere sphere : spheres) {
			Hit hit = sphere.intersect(ray); // Finde kleinste Überschneidung mit Kugel
			if (hit != null && hit.t < t) { // Absicherung damit hit nicht null ist und t nicht Unendlich
				t = hit.t;
				normal = hit.n; 
				color = hit.c; // shade (hit.n, hit.c)
			}
		}
		Color shade = null;
		if (t != Double.POSITIVE_INFINITY) {
			shade = Util.shade(normal, color); // Kalkuliere Lichtintensität
			return shade;
		} 
		else {
			return background;
		}
	}

	public boolean add(Sphere sphere) {
		return spheres.add(sphere);
	}
}
