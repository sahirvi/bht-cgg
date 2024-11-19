package a08;

import cgtools.*;

public class BackgroundMaterial implements Material {

	public Boolean absorb() {
		return true;
	}

	public Ray scatteredRay(Ray ray, Hit hit) {
		return null; // keine Streuung
	}

	public Color albedo(Ray ray, Hit hit) {
		return null; // keine Albedo
	}

	public Color emission(Ray ray, Hit hit) {
		return Color.white; // Farbe des Himmels in Strahlrichtung
	}

}
