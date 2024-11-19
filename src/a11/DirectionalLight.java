package a11;

import cgtools.*;

public class DirectionalLight implements Light {
	Direction d;
	Color intensity;

	public DirectionalLight(Direction d, Color intensity) {
		this.d = d;
		this.intensity = intensity;
	}

	@Override
	public Color radiance(Point point) {
		return intensity;
	}

	@Override
	public Direction direction(Point point) {
		return d;
	}

	@Override
	public boolean isVisible(Point point, Shape scene) {
		Ray ray = new Ray(point, d, Util.EPSILON, Double.MAX_VALUE);
		if (scene.intersect(ray) == null) {
			return true;
		} else {
			return false;
		}
	}

}
