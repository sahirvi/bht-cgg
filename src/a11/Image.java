package a11;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import cgtools.*;

public class Image {
	public int c = 3;
	public int bit = 8;
	int width;
	int height;
	public double[] data;

	public Image(int width, int height) {
		this.width = width;
		this.height = height;
		int m = (int) (width * height * c * Math.ceil((bit / 8)));
		data = new double[m];
	}

	public void setPixel(int x, int y, Color color) {
		data[c * (y * width + x) + 0] = Math.pow(color.r, 1 / 2.2);
		data[c * (y * width + x) + 1] = Math.pow(color.g, 1 / 2.2);
		data[c * (y * width + x) + 2] = Math.pow(color.b, 1 / 2.2);
	}

	public void write(String filename) {
		ImageWriter.write(filename, data, width, height);
	}

	public void sample(Sampler sampler, int n) {

		ExecutorService pool = Executors.newFixedThreadPool(4);
		HashMap<Integer, Future<Color>> futures = new HashMap<Integer, Future<Color>>(width * height);

		for (int x = 0; x != width; x++) {
			for (int y = 0; y != height; y++) {
				futures.put(Integer.valueOf(y * width + x), pool.submit(new SuperSampling(sampler, n, x, y)));
			}
		}

		for (int x = 0; x != width; x++) {
			for (int y = 0; y != height; y++) {

				Future<Color> pixel = futures.get(y * width + x);
				while (!pixel.isDone()) {
				}
				Color color;
				try {
					color = pixel.get();
					setPixel(x, y, color);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
		pool.shutdown();
	}
}

class SuperSampling implements Callable<Color> {

	public final Sampler sampler;
	public final int n;
	public final int x;
	public final int y;

	public SuperSampling(Sampler sampler, int n, int x, int y) {
		this.sampler = sampler;
		this.n = n;
		this.x = x;
		this.y = y;
	}

	public Color call() {
		Color color = new Color(0, 0, 0);
		for (int xi = 0; xi != n; xi++) {
			for (int yi = 0; yi != n; yi++) {
				double rx = Random.random();
				double ry = Random.random();
				double xs = x + (xi + rx) / n;
				double ys = y + (yi + ry) / n;
				color = Color.add(color, sampler.getColor(xs, ys));
			}
		}
		color = Color.divide(color, n * n);
		return color;
	}
}