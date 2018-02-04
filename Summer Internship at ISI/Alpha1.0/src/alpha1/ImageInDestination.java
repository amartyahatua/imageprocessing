package alpha1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageInDestination 
{
	public void drawImageInDestination(String asbolutePath,String imageLocation)
	{
		
		String delims ="[.]";
		String [] tokens = imageLocation.split(delims);
		String extension = tokens[1];
		delims = "/";
		tokens = imageLocation.split(delims);
		String imageFullName= tokens[tokens.length-1];
		
		File file= new File(imageLocation);
		BufferedImage inputImage = null;
		try {
			 inputImage = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int width = inputImage.getWidth(null);                 										
		int height = inputImage.getHeight(null);
		
		int storePixelRed[][]=new int [height][width];
		int storePixelGreen[][]=new int [height][width];
		int storePixelBlue[][]=new int [height][width];
		int  storeBinary[][]=new int [height][width];		
		
		for(int h = 0;h<height;h++)
		{
			for(int w = 0;w<width;w++)
			{
				int clr=  inputImage.getRGB(w,h); 	
				int  red   = (clr & 0x00ff0000) >> 16;
			int  green = (clr & 0x0000ff00) >> 8;
			int  blue  = (clr & 0x000000ff);	  

			storePixelRed[h][w]=red;		
			storePixelGreen[h][w]=green;
			storePixelBlue[h][w]=blue;		

			}
		}
		
		
		
		for(int h = 1;h<height-1;h++)
		{
			for(int w = 1;w<width-1;w++)
			{
				storeBinary[h][w]=(int) ((storePixelRed[h][w]<<16 & 0xff0000)+
						(storePixelGreen[h][w]<<8 & 0x00ff00 ) +
						(storePixelBlue[h][w] & 0x0000ff));

			}
		}
		
		
		String x= asbolutePath+"/";
		String y = x.concat(imageFullName);
		File outputFile = new File(y);     
		BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		
		
		System.out.println("Bhagoban :  "+y);

		for(int h = 1;h<height-1;h++)

		{
			for(int w = 1;w<width-1;w++)
			{
				img.setRGB(w,h,(storeBinary[h][w]));
			}
		}

		try 
		{
			ImageIO.write(img, extension, outputFile);
		} 
		catch (IOException e) 
		{
			
			System.out.println("Error :"+e.getMessage());
			e.printStackTrace();
		} 

		
		
		
		
		
	}
}
