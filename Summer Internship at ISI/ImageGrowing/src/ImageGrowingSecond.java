import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImageGrowingSecond 
{
	
	public int[][] getRGB(File file,int index) throws IOException
	{
		BufferedImage buf = ImageIO.read(file);
		int width = buf.getWidth();
		int height = buf.getHeight();
		int c = 0;
		int [][] rgb = new int[height][width];
		for(int h = 0; h<height; h++)
		{
			for(int w = 0; w<width ; w++)
			{
				c = buf.getRGB(w,h);
				if (index==1)
				{
					int clr = (c&0x00ff0000)>>16;
			rgb[h][w]=clr;

				}
				else if (index==2)
				{
					int clr = (c&0x0000ff00)>>8;
					rgb[h][w]=clr;					
				}
				else
				{
					int clr = (c&0x000000ff);
					rgb[h][w]=clr;
				}					
			}
		}
		return rgb;
	}
	

	
	
	
	public static void main(String args[]) throws IOException
	{
		File file = new File("C:/Documents and Settings/Administrator/Desktop/test/out_initial.bmp");
		BufferedImage image=null;
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int width = image.getWidth(null);                 										/*Calculating the height and width of image */
		int height = image.getHeight(null);

		int storePixelRed[][]=new int [height][width];
		int storePixelGreen[][]=new int [height][width];
		int storePixelBlue[][]=new int [height][width];

		int [][]resultRed = new int [height][width];
		int [][]resultGreen = new int [height][width];
		int [][]resultBlue = new int [height][width];
		
		
		
		ImageGrowingSecond imgGrng = new ImageGrowingSecond();

		storePixelRed = imgGrng.getRGB(file,1);
		storePixelGreen= imgGrng.getRGB(file,2);
		storePixelBlue = imgGrng.getRGB(file,3);
		
		
		for(int h = 1; h<height-1; h++)
		{
			for(int w = 1; w<width-1; w++)
			{
				int flag=0;
				
					for(int i=-1;i<1;i++)
					{
						for(int j=-1;j<1;j++)
						{
							if(storePixelRed[h+i][w+j]==255)
								flag=1;
							 
								 
						}
					}
					
					if(flag==0)
						resultRed[h][w]=0;
					else
						resultRed[h][w]=255;
					flag=0;
						
				
					for(int i=-1;i<1;i++)
					{
						for(int j=-1;j<1;j++)
						{
							if(storePixelGreen[h+i][w+j]==255)
								flag=1;
								 
						}
					}
					
					if(flag==0)
						resultGreen[h][w]=0;
					else
						resultGreen[h][w]=255;
					flag=0;
					
			
					for(int i=-1;i<1;i++)
					{
						for(int j=-1;j<1;j++)
						{
							if(storePixelBlue[h+i][w+j]==255)
								flag=1;
								 
						}
					}
					
					if(flag==0)
						resultBlue[h][w]=0;
					else
						resultBlue[h][w]=255;
				
			}
		}
		
		
		int [][]result  = new int[height][width];

		
		for(int h = 0;h<height;h++)
		{
			for(int w = 0;w<width;w++)
			{
				result[h][w]= ((resultRed[h][w] <<16 & 0xff0000)+
						(resultGreen[h][w]<<8 & 0x00ff00 ) +
						(resultBlue[h][w] & 0x0000ff));

			}
		}
		

		File outputFile = new File("out.bmp");     /*Initializing the output image named as "out.bmp"*/
		BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);


		for(int h = 1;h<height-1;h++)

		{
			for(int w = 1;w<width-1;w++)
			{
				img.setRGB(w,h,(result[h][w]));
			}
		}
		ImageIO.write(img, "bmp", outputFile);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
