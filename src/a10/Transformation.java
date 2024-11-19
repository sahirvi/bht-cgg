package a10;

import cgtools.*;

public class Transformation {

	public Matrix toWorld;
	public Matrix fromWorld;
	public Matrix toWorldN;

	public Transformation(Matrix transformation) {
		toWorld = transformation;
		fromWorld = Matrix.invert(transformation);
		this.toWorldN = Matrix.transpose(fromWorld);
	}

	public Ray transformRay(Ray ray) {
		Point tX0 = Matrix.multiply(fromWorld, ray.x0);
		Direction tD = Vector.normalize(Matrix.multiply(fromWorld, ray.d));
		Ray tRay = new Ray(tX0, tD, ray.tMin, ray.tMax);
		return tRay;
	}

	public Hit transformHit(Hit hit) {
		if (hit == null) {
			return null;
		}
		Point tX0 = Matrix.multiply(toWorld, hit.x);
		Direction tD = Vector.normalize(Matrix.multiply(toWorldN, hit.normal));
		Hit tHit = new Hit(hit.t, tX0, tD, hit.u, hit.v, hit.material);
		return tHit;
	}

}
