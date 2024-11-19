package a03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cgtools.*;


class RaytracingTest {
	
	PinholeCamera pinhole = new PinholeCamera((Math.PI / 2), 10, 10);
	
	@Test
	void test1() {
		Ray ray = pinhole.genRay(cgtools.Random.random(), cgtools.Random.random());
		Point x0 = ray.x0;
		Point resultX0 = Vector.point(0, 0, 0); // Erwartung: (0,0,0)
		assertEquals(x0, resultX0); 
	}
	
	@Test
	void test2() {
		Ray ray = pinhole.genRay(0, 0);
		Direction d = ray.d;
		Direction resultD = Vector.direction((-1/Math.sqrt(3)), 1/Math.sqrt(3), -1/Math.sqrt(3)); // Erwartung: ((-1/√3), (1/√3), (-1/√3))
		assertEquals(d, resultD);
	}
	
	@Test
	void test3() {
		Ray ray = pinhole.genRay(5, 5);
		Direction d = ray.d;
		Direction resultD = Vector.direction(0, 0, -1); // Erwartung:  (0,0,-1)
		assertEquals(d, resultD);
	}
	
	@Test
	void test4() {
		Ray ray = pinhole.genRay(10, 10);
		Direction d = ray.d;
		Direction resultD = Vector.direction((1/Math.sqrt(3)), -1/Math.sqrt(3), -1/Math.sqrt(3)); // Erwartung: ((1/√3), (-1/√3), (-1/√3))
		assertEquals(d, resultD);
	}

	@Test
	void test5() {
		Point c = Vector.point(0, 0, -2);
		Color randomColor = new Color(cgtools.Random.random(), cgtools.Random.random(),
				cgtools.Random.random());
		Direction d = Vector.direction(0, 0, -1);
		Point x0 = Vector.point(0, 0, 0);
		Ray ray = new Ray (x0, d, 0, Double.POSITIVE_INFINITY);
		Sphere sphere = new Sphere(c, 1, randomColor);
		Hit hit = sphere.intersect(ray);
		Direction n = hit.n;
		
		Point resultX = Vector.point(0, 0, -1);
		Direction resultN = Vector.direction(0, 0, 1);
		assertEquals(hit.x, resultX);
		assertEquals(n, resultN);
	}
	
	@Test
	void test6() {
		Point c = Vector.point(0, 0, -2);
		Color randomColor = new Color(cgtools.Random.random(), cgtools.Random.random(),
				cgtools.Random.random());
		Direction d = Vector.direction(0, 1, -1);
		Point x0 = Vector.point(0, 0, 0);
		Ray ray = new Ray (x0, d, 0, Double.POSITIVE_INFINITY);
		Sphere sphere = new Sphere(c, 1, randomColor);
		Hit hit = sphere.intersect(ray);
//		Direction n = hit.n;
		assertNull(hit);
	}
	
	@Test
	void test7() {
		Point c = Vector.point(0, -1, -2);
		Color randomColor = new Color(cgtools.Random.random(), cgtools.Random.random(),
				cgtools.Random.random());
		Direction d = Vector.direction(0, 0, -1);
		Point x0 = Vector.point(0, 0, 0);
		Ray ray = new Ray (x0, d, 0, Double.POSITIVE_INFINITY);
		Sphere sphere = new Sphere(c, 1, randomColor);
		Hit hit = sphere.intersect(ray);
		Direction n = hit.n;
		
		Point resultX = Vector.point(0, 0, -2);
		Direction resultN = Vector.direction(0, 1, 0);
		assertEquals(hit.x, resultX);
		assertEquals(n, resultN);
	}
	
	@Test
	void test8() {
		Point c = Vector.point(0, 0, -2);
		Color randomColor = new Color(cgtools.Random.random(), cgtools.Random.random(),
				cgtools.Random.random());
		Direction d = Vector.direction(0, 0, -1);
		Point x0 = Vector.point(0, 0, -4);
		Ray ray = new Ray (x0, d, 0, Double.POSITIVE_INFINITY);
		Sphere sphere = new Sphere(c, 1, randomColor);
		Hit hit = sphere.intersect(ray);

//		Direction n = hit.n;
		assertNull(hit);
	}
	
	@Test
	void test9() {
		Point c = Vector.point(0, 0, -4);
		Color randomColor = new Color(cgtools.Random.random(), cgtools.Random.random(),
				cgtools.Random.random());
		Direction d = Vector.direction(0, 0, -1);
		Point x0 = Vector.point(0, 0, 0);
		Ray ray = new Ray (x0, d, 0, 2);
		Sphere sphere = new Sphere(c, 1, randomColor);
		Hit hit = sphere.intersect(ray);

//		Direction n = hit.n;
		assertNull(hit);
	}

}
