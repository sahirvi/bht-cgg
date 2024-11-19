package a11;

import cgtools.*;

public interface Light {
	
	public Color radiance(Point point);
	public Direction direction(Point point);
	public boolean isVisible(Point point, Shape scene);
}
