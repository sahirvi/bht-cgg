package a11;

import cgtools.*;

public class Hit {
	public final double t; // Strahlparameter t
	public final Point x; // Position des Treffpunkts x
	public final Direction normal; // Normalenvektor n
	public Material material; // Material material
	public Color color;
	public Point uv; // texel Koordinate
	public double u;
	public double v;
	
	 public Hit(double t, Point x, Direction normal, double u, double v, Material material) {
	        this.t = t;
	        this.x = x;
	        this.normal = Vector.normalize(normal);
	        this.material = material;
	        this.u = u;
	        this.v = v;
	    }
}
