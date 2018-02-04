import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Administrator
 *
 */
public class PowerLaw
{
	public static void main(String args[])
	{
		BufferedImage image=null;
		String imageName="C:/Documents and Settings/Administrator/Desktop/test/bone.png";
		File input = new File(imageName);
		try {
			image = ImageIO.read(input);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int width  = image.getWidth(null);                 										/*Calculating the height and width of image */
		int height = image.getHeight(null);


		float grayScale[][]= new float [height][width];;
		double transformed[][] = new double[height][width];	
		int [][] picTransTemp = new int[height][width];
		int result [][] = new int[height][width];



		for(int h = 0;h<height;h++)
		{
			for(int w = 0;w<width;w++)
			{
				int clr=  image.getRGB(w,h); 	
				int  red   = (clr & 0x00ff0000) >> 16;
				int  green = (clr & 0x0000ff00) >> 8;
				int  blue  = (clr & 0x000000ff);	  


				grayScale[h][w]=((red+green+blue)/3);
			}
		}

		double temp=-100;
		for(int h = 0;h<height;h++)
		{
			for(int w = 0;w<width;w++)
			{
				transformed[h][w]= Math.pow(grayScale[h][w],1);			
				if(transformed[h][w]>temp)
					temp=transformed[h][w];
			}
		}
		
		
		for(int h = 0;h<height;h++)
		{
			for(int w = 0;w<width;w++)
			{
				picTransTemp[h][w]=(int)Math.ceil((255*transformed[h][w])/temp);
			}
		}
		
		
		
		



		for(int h = 0;h<height;h++)
		{
			for(int w = 0;w<width;w++)
			{
				result[h][w]= ((picTransTemp[h][w] <<16 & 0xff0000)+
						(picTransTemp[h][w]<<8 & 0x00ff00 ) +
						(picTransTemp[h][w] & 0x0000ff));

			}
		}

		File outputFile = new File("out.bmp");     
		BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_BYTE_GRAY);

		for(int h = 1;h<height-1;h++)

		{
			for(int w = 1;w<width-1;w++)
			{
				img.setRGB(w,h,(result[h][w]));
			}
		}


		try 
		{
			ImageIO.write(img, "bmp", outputFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}
}