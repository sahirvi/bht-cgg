package a04;

import cgtools.*;

public class Ray {

	public final Point x0; // Ursprung x0
	public final Direction d; // Richtung d
	public final double tMin; // Strahlbegrenzung
	public final double tMax; // Strahlbegrenzung

	public Ray(Point x0, Direction d, double tMin, double tMax) {
		this.x0 = x0;
		this.d = Vector.normalize(d); // d muss normalisiert sein, um Länge 1 zu haben
		this.tMin = tMin; 
		this.tMax = tMax; 
	}

	public Point pointAt(double t) {
		if (t > tMin && t <= tMax) { // innerhalb von tMax und tMin
			Point xT = Vector.add(x0, Vector.multiply(t, d)); // x0 + t * d
			return xT;
		} else {
			return null;
		}
	}

}
