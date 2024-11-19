package a11;

import cgtools.*;

public class PointLight implements Light {

	Point position;
	Color intensity;

	public PointLight(Point position, Color intensity) {
		this.position = position;
		this.intensity = intensity;
	}

	@Override
	public Color radiance(Point point) {
		return Color.divide(intensity, Vector.squaredLength(direction(point)));
	}

	@Override
	public Direction direction(Point point) {
		return Vector.subtract(position, point);
	}

	@Override
	public boolean isVisible(Point point, Shape scene) {
		Direction d = direction(point);
		Ray ray = new Ray(point, Vector.normalize(d), Util.EPSILON, Vector.length(d));
		Hit hit = scene.intersect(ray);
		if (hit == null) {
			return true;
		} else {
			return false;
		}
	}

}
