package a03;

import cgtools.*;

public class Sphere {
	
	public Point sphereCenter; // Mittelpunkt der Kugel
	public double radius; // Abstand zwischen Mittelpunkt und Punkt auf der Oberfläche der Kugel
	public Color color;
	
	public Sphere(Point center, double radius, Color color){
		this.sphereCenter = center;
		this.radius = radius;
		this.color = color;
		
	}
	
	public Hit intersect(Ray r) {
		
		Vector x01 = Vector.subtract(r.x0, sphereCenter); // Verschiebung des Strahls um -c
		
		double a = Vector.dotProduct(r.d, r.d); // d²
		double b = 2 * Vector.dotProduct(x01, r.d); // 2x0d
		double c = Vector.dotProduct(x01, x01) - Math.pow(radius, 2); // x0² - r²
		
		
		double diskriminante = Math.pow(b, 2) - 4 * a * c; // b² -  4 * a * c
	
		if(diskriminante < 0) { // b² -  4ac < 0 ; N = 0
			return null; // gib nichts zurück
		}
		
		
		else if(diskriminante == 0) { // b² -  4ac = 0 ; N = 1
			double abc = -b / (2 * a); // (- b +/- √0) / 2a
			Point x = r.pointAt(abc); // Punkt x an der Kugel 
			
			if(x == null) { // Absicherung, falls es leer ist
				return null;
			}
			
			else {
				Direction n = Vector.divide(Vector.subtract(x, sphereCenter), radius); // n = Normalenvektor, n = x-c /r
				return new Hit(abc, x, n, color);
			}
			
		}
		
		else { // b² -  4ac > 0 ; N = 2
			double x1 = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c))/ (2*a); // (- b + √b² -  4ac) / 2a
			double x2 = (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c))/ (2*a); // (- b - √b² -  4ac) / 2a
			
			double min = Math.min(x1, x2); // wählt den kleineren Punkt
			
			Point x = r.pointAt(min); // Punkt x an der Kugel 
			
			if(x == null) { // Absicherung, falls es leer ist
				return null;
			}
			
			else {
				Direction n = Vector.divide(Vector.subtract(x, sphereCenter), radius); // n = Normalenvektor, n = x-c /r
				return new Hit(min, x, n, color);				
			}
		}
	}

}