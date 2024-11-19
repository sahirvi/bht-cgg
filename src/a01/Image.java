package a01;

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
	  int m = (int) (width * height * c * Math.ceil((bit/8)));
	  data = new double [m];
  }

  public void setPixel(int x, int y, Color color) {
	  data[c*(y * width + x) + 0] = color.r;
	  data[c*(y * width + x) + 1] = color.g;
	  data[c*(y * width + x) + 2] = color.b;
	  
	  
  }
  public void write(String filename) {
    ImageWriter.write(filename, data, width, height);
  }

}