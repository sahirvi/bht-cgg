package a02;

import static cgtools.Color.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import cgtools.Color;

public class A02 {

	public static void main(String[] args) {
		final int width = 1280;
		final int height = 720;
		final String filename = "doc/a02-discs.png";
		final String filename1 = "doc/a02-discs-supersampling.png";

		class Disc {
			double positionX;
			double positionY;
			Color color;
			double radius;

			Disc(double positionX, double positionY, double radius, Color color) {
				this.positionX = positionX;
				this.positionY = positionY;
				this.radius = radius;
				this.color = color;
			}

			boolean isPointinDisc(double x, double y) {
				x = positionX - x;
				y = positionY - y;

				int maxRadius = 6;

				return (Math.abs(Math.sqrt(x * x + y * y)) <= radius / maxRadius);
			}
		}

		class ColoredDisc implements Comparator<Disc> {

			List<Disc> ListeMitKreisen = new ArrayList<Disc>();

			public void createDisc(int anzahlKreise) {

				for (int i = 0; i < anzahlKreise; i++) {
					Color randomColor = new Color(cgtools.Random.random(), cgtools.Random.random(),
							cgtools.Random.random());
					Disc disc = new Disc(cgtools.Random.random(), cgtools.Random.random(), cgtools.Random.random(),
							randomColor);
					ListeMitKreisen.add(disc);
				}
				
				ListeMitKreisen.sort(this::compare);
				
			}

			public Color getColor(double x, double y) {
				x = x / width;
				y = y / width;
				for (Disc discs : ListeMitKreisen) {
					if (discs.isPointinDisc(x, y)) {
						return discs.color;
					}
				}
				return black;
			}

			@Override
			public int compare(Disc disc1, Disc disc2) {
				double radius1 = Double.valueOf(disc1.radius);
				double radius2 = Double.valueOf(disc2.radius);
				return Double.compare(radius1, radius2);
			}
		}

		Image image = new Image(width, height);
		Image imageSuper = new Image(width, height);

		ColoredDisc coloredDisc = new ColoredDisc();
		coloredDisc.createDisc(200);
		
		int n = 10;
		for (int x = 0; x != width; x++) {
			for (int y = 0; y != height; y++) {
				Color color = new Color(0, 0, 0);
				for (int xi = 0; xi != n; xi++) {
					for (int yi = 0; yi != n; yi++) {
						double rx = cgtools.Random.random();
						double ry = cgtools.Random.random();
						double xs = x + (xi + rx) / n;
						double ys = y + (yi + ry) / n;
						color = Color.add(color, coloredDisc.getColor(xs, ys));
					}
				}
				image.setPixel(x, y, coloredDisc.getColor(x, y));
				imageSuper.setPixel(x, y, Color.divide(color, n * n));
			}
		}
		image.write(filename);
		System.out.println("Wrote image: " + filename);
		imageSuper.write(filename1);
		System.out.println("Wrote image: " + filename1);

	}

}
