package a02;

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
	  data[c*(y * width + x) + 0] = Math.pow(color.r, 1/2.2);
	  data[c*(y * width + x) + 1] = Math.pow(color.g, 1/2.2);
	  data[c*(y * width + x) + 2] = Math.pow(color.b, 1/2.2);
	  
	  
  }
  public void write(String filename) {
    ImageWriter.write(filename, data, width, height);
  }

}