package a11;

import cgtools.*;

public class Constant implements Sampler{
	Color color;
	
	public Constant(Color color) {
		this.color = color;
	}
	
	@Override
	public Color getColor (double u, double v) {
		return color;
	}

}
