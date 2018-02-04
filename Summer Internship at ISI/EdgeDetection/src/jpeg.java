import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
 

import javax.imageio.ImageIO;


public class jpeg
{
	public static void main(String args[]) throws Exception 
	{

		/*File inputFile = new File("C:/Documents and Settings/Administrator/Desktop/ah/chk.bmp");
		BufferedImage bufferedImage = ImageIO.read(inputFile);*/
		//int w = bufferedImage.getWidth(null);
		//int h = bufferedImage.getHeight(null);
		int w =255 ,h=255;
		


		FileWriter fstream = new FileWriter("C:/Documents and Settings/Administrator/Desktop/ah/a.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		File outputFile = new File("C:/Documents and Settings/Administrator/Desktop/ah/b.bmp");

		BufferedImage img = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);



		for(int i=0;i<h;i++)
		{
			for (int j=0;j<w;j++)
			{
				//int rgbValue=bufferedImage.getRGB(i,j)+0xFFFFFF+1;
				
				double rand = Math.random();
				if(rand>0.5)
				{
					img.setRGB(i, j,255);
					/*red = ((rgbValue >> 16) & 0xFF)-256;
					green = ((rgbValue >> 8) & 0xFF)-256;
					blue = (rgbValue & 0xFF)-256;

					

					pixel_red[i][j]=red;
					pixel_green[i][j]=green;
					pixel_blue[i][j]=blue;*/
				}
				else 
				{
					img.setRGB(i, j,0);
					/*red = ((rgbValue >> 16) & 0xFF);
					green = ((rgbValue >> 8) & 0xFF);
					blue = (rgbValue & 0xFF);



					pixel_red[i][j]=red;
					pixel_green[i][j]=green;
					pixel_blue[i][j]=blue;*/
				}
				       //set pixel values

				//pp[index++]=rgbValue;


			}
			out.newLine();

		}
		ImageIO.write(img, "bmp", outputFile);  
		out.close();
		 



		
	}
	
}


