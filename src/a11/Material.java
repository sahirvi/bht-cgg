package a11;

import cgtools.*;

public interface Material {
	
	public Boolean absorb(); // Strahlabsorbtion
	
	public Ray scatteredRay(Ray ray, Hit hit); // Streuung
	
	public Color albedo(Ray ray, Hit hit); // Strahldichte entlang des gestreuten Strahls
	
	public Color emission(Ray ray, Hit hit); // emittierter Strahl
}
