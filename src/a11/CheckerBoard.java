package a11;

import cgtools.*;

public class CheckerBoard implements Sampler {
	public double n;

	public CheckerBoard(double n) {
		this.n = n;
	}

	@Override
	public Color getColor(double u, double v) {

		double ui = (int) ((u % 1) * n);
		double vi = (int) ((v % 1) * n);

		if ((ui + vi) % 2 == 0) {
			return new Color(1, 1, 1);
		} else {
			return new Color(0, 0, 0);
		}
	}

}
