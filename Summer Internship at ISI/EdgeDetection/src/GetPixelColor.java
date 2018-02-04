
import java.awt.*;
import java.awt.image.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
public class GetPixelColor extends java.applet.Applet implements Runnable 
{
int pixels[];
	MemoryImageSource source;

	public void init() {
	    int width = 50;
	    int height = 50;
	    int size = width * height;
	    pixels = new int[size];

	    int value = getBackground().getRGB();
	    for (int i = 0; i < size; i++) {
		pixels[i] = value;
	    }

	    source = new MemoryImageSource(width, height, pixels, 0, width);
	    source.setAnimated(true);
	    Image image = createImage(source);
	}

	public void run() {
	    Thread me = Thread.currentThread( );
	    me.setPriority(Thread.MIN_PRIORITY);

	    while (true) {
		 

		// Modify the values in the pixels array at (x, y, w, h)

		// Send the new data to the interested ImageConsumers
		source.newPixels(18, 18, 18, 18);
	    }
	}}