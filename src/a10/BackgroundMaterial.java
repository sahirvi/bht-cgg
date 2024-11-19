package a10;

import cgtools.*;

public class BackgroundMaterial implements Material {
	
	public Sampler texture;
	
	public BackgroundMaterial(Sampler texture) {
		this.texture = texture;
	}

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
		return texture.getColor(hit.u, hit.v); // Farbe des Himmels in Strahlrichtung
	}

}
