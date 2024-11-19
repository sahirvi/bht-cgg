package a03;

import cgtools.*;


public class Hit {
	public final double t; // Strahlparameter t
	public final Point x; // Position des Treffpunkts x
	public final Direction n; // Normalenvektor n
	public final Color c; // Farbe c

	public Hit(double t, Point x, Direction n, Color c) {
		this.t = t;
		this.x = x;
		this.n = Vector.normalize(n); // Richtung wird zu Normalenvektor
		this.c = c;
	}
}
