package a05;

import cgtools.*;

public class PinholeCamera {
	
	public double winkel; // Kameraöffnungswinkel Alpha
	public double width; // Breite
	public double height; // Höhe
	public Point x0; // Ursprung x0
	
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
		
		Ray ray = new Ray(x0, d);
		return ray;
	}
	
}