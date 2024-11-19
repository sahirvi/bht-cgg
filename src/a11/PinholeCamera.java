package a11;

import cgtools.*;

public class PinholeCamera {
	
	public double winkel; // Kameraöffnungswinkel Alpha
	public double width; // Breite
	public double height; // Höhe
	public Point x0; // Ursprung x0
	public Matrix v;
	
	public PinholeCamera (double winkel, double width, double height, Matrix v) {
		this.winkel = winkel;
		this.width = width;
		this.height = height;
		this.x0 = Vector.point(0, 0, 0); // Ursprung bei x = 0, y = 0, z = 0
		this.v = v;
	}
	
	public PinholeCamera (double winkel, double width, double height) {
		this.winkel = winkel;
		this.width = width;
		this.height = height;
		this.x0 = Vector.point(0, 0, 0); // Ursprung bei x = 0, y = 0, z = 0
	}
	
	public Ray genRay (double xP, double yP) { // Strahlerzeugung
		
		double x = xP-(width/2);
		double y = -(yP - (height/2));
		double z = -(width/2) / Math.tan(winkel/2);
		
		Direction d = Vector.direction(x, y, z);
		
		Point vX0 = Matrix.multiply(v, x0);
		Direction td = Matrix.multiply(v, d);
		
		Ray ray = new Ray(vX0, td);
		return ray;
	}
	
}
