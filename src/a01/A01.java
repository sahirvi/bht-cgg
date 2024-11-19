package a01;

import static cgtools.Color.*;

import a10.Image;
import cgtools.*;

public class A01 {

	public static void main(String[] args) {
		final int width = 1280;
		final int height = 720;
		final String filename = "doc/a01-image.png";
		final String filenameDisc = "doc/a01-disc.png";
		final String filenameCheckered = "doc/a01-disc-checkered.png";

		class ConstantColor {
			Color color;

			ConstantColor(Color color) {
				this.color = color;
			}

			Color getColor(double x, double y) {
				return color;
			}
		}

		class ColoredDisc {
			Color color;
			double size;

			ColoredDisc(double size, Color color) {
				this.size = size;
				this.color = color;
			}

			Color getColor(double x, double y) {
				double w2 = width / 2.0;
				double h2 = height / 2.0;
				double xc = x - w2;
				double yc = y - h2;
				double s2 = (size / 2);

				if (Math.abs(Math.sqrt(xc * xc + yc * yc)) < s2) {
					return color;
				}

				else {
					return black;
				}
			}
		}

		class DiscCheckered {
			Color color;
			double size;
			int patternSize;

			DiscCheckered(double size, Color color, int patternSize) {
				this.size = size;
				this.color = color;
				this.patternSize = patternSize;
			}

			Color getColor(double x, double y) {
				double w2 = width / 2.0;
				double h2 = height / 2.0;
				double xc = x - w2;
				double yc = y - h2;
				double s2 = (size / 2);
				

				if (Math.abs(Math.sqrt(xc * xc + yc * yc)) < s2) {
					return color;
				}

				else {
					if ((int) (x / patternSize) % 2 == 0 ^ (int) (y / patternSize) % 2 == 0) {
						return black;
					} else {
						return white;
					}
				}
			}
		}

		Image image = new Image(width, height);
		Image imageDisc = new Image(width, height);
		Image imageCheckered = new Image(width, height);

		ConstantColor allGray = new ConstantColor(gray);
		ColoredDisc redCircle = new ColoredDisc(width / 2, red);
		DiscCheckered DiscCheckered = new DiscCheckered(width / 2, red, 40);
		for (int x = 0; x != width; x++) {
			for (int y = 0; y != height; y++) {
				
				imageDisc.setPixel(x, y, redCircle.getColor(x, y));
				
				image.setPixel(x, y, allGray.getColor(x, y));
				
				imageCheckered.setPixel(x, y, DiscCheckered.getColor(x, y));
			}
		}
		
		image.write(filename);
		System.out.println("Wrote image: " + filename);
		imageDisc.write(filenameDisc);
		System.out.println("Wrote image: " + filenameDisc);
		imageCheckered.write(filenameCheckered);
		System.out.println("Wrote image: " + filenameCheckered);
	}
}
