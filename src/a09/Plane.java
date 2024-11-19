package a09;

import cgtools.*;

public class Plane implements Shape {

	public Material material;
	public Color color;
	public Point p;
	public Direction n;
	public double d = Double.POSITIVE_INFINITY;

	public Plane(Point p, Direction n, Material material) {
		this.n = n;
		this.p = p;
		this.material = material;
	}
	
	public Plane(Point p, Direction n, double d, Material material) {
		this.n = n;
		this.p = p;
		this.material = material;
		this.d = d;
	}

	public Hit intersect(Ray ray) {

		if (Vector.dotProduct(ray.d, n) == 0) { // man kann nicht durch 0 teilen
			return null;
		}
		else {
			double t = ((Vector.dotProduct(p, n) - Vector.dotProduct(ray.x0, n)) / Vector.dotProduct(ray.d, n)); // t = ((p - x0) * n) / (d * n)
			if (t==0) {
				return null;
			}

			else {			
					Point x = ray.pointAt(t);
					
					if (x != null) {

					if (Vector.length(Vector.subtract(x, p)) > d) {
						return null;
					}
					else {
						return new Hit(t,x,n, material);
					}
				}
				else {
					return null;
				}			
			}
		}
	}
}