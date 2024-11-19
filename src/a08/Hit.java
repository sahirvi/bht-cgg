package a08;

import cgtools.*;

public class Hit {
	public final double t; // Strahlparameter t
	public final Point x; // Position des Treffpunkts x
	public final Direction normal; // Normalenvektor n
	public Material material; // Material material
	public Color color;

	public Hit(double t, Point x, Direction normal, Material material) {
		this.t = t;
		this.x = x;
		this.normal = normal; // Richtung wird zu Normalenvektor
		this.material = material;
	}
}
