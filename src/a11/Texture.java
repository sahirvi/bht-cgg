package a11;

import cgtools.*;

import java.io.IOException;

public class Texture implements Sampler {
	ImageTexture texture;

	public Texture(String filename) {
		try {
			texture = new ImageTexture(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Color getColor(double u, double v) {
		return revertGamma(texture.getColor(u, v));
	}

	private Color revertGamma(Color color) {
		
		double ir = Math.pow(color.r, 2.2);
		double ig = Math.pow(color.g, 2.2);
		double ib = Math.pow(color.b, 2.2);

		return new Color(ir, ig, ib);
	}

}