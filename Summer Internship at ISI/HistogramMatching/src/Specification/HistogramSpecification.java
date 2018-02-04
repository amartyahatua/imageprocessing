package Specification;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HistogramSpecification 
{
	public static void main(String args[]) throws IOException
	{

		BufferedImage imageInit,imageSp;
		String imageNameInit="C:/Documents and Settings/Administrator/Desktop/test/image5.JPG";				//  Source image 
		File inputInit = new File(imageNameInit);
		imageInit = ImageIO.read(inputInit);
		
		String imageNameSp = "C:/Documents and Settings/Administrator/Desktop/test/image4.JPG";			//  Desired image
		File inputSp = new File(imageNameSp);
		imageSp = ImageIO.read(inputSp);


		int heightInit = imageInit.getHeight(null);
		int widthInit = imageInit.getWidth(null);
		int sizeInit = widthInit * heightInit;
		
		
		int heightSp = imageSp.getHeight(null);
		int widthSp = imageSp.getWidth(null);
		
		int storePixelRedInit[][]=new int [heightInit][widthInit];
		int storePixelGreenInit[][]=new int [heightInit][widthInit];
		int storePixelBlueInit[][]=new int [heightInit][widthInit];
		
		
		
		int storePixelRedSp[][] = new int [heightSp][widthSp];
		int storePixelGreenSp[][] = new int [heightSp][widthSp];
		int storePixelBlueSp[][] = new int [heightSp][widthSp];
	
		
		double cdfRedInit[]=new double [256];
		double cdfGreenInit[]=new double [256];
		double cdfBlueInit[]=new double [256];
		
		double cdfRedSp[]=new double [256];
		double cdfGreenSp[]=new double [256];
		double cdfBlueSp[]=new double [256];
		
		
		int result [][] = new int[heightInit][widthInit];
	
		int [] lookUpRed = new int[sizeInit];
		int [] lookUpGreen = new int[sizeInit];
		int [] lookUpBlue = new int[sizeInit];

		for(int h = 0;h<heightInit;h++)
		{
			for(int w = 0;w<widthInit;w++)
			{
				int clr=  imageInit.getRGB(w,h); 	/*Pixel values finding*/
				int  red   = (clr & 0x00ff0000) >> 16;
				int  green = (clr & 0x0000ff00) >> 8;
				int  blue  = (clr & 0x000000ff);	  
	
				storePixelRedInit[h][w]=red;		
				storePixelGreenInit[h][w]=green;
				storePixelBlueInit[h][w]=blue;	
				
				
			}
		}
		
		for(int h = 0;h<heightInit;h++)
		{
			for(int w = 0;w<widthInit;w++)
			{
				int clr=  imageSp.getRGB(w,h); 	/*Pixel values finding*/
				int  red   = (clr & 0x00ff0000) >> 16;
				int  green = (clr & 0x0000ff00) >> 8;
				int  blue  = (clr & 0x000000ff);	  
	
				storePixelRedSp[h][w]=red;		
				storePixelGreenSp[h][w]=green;
				storePixelBlueSp[h][w]=blue;	
			}
		}
		
	/*---------------------------  CALCULATE THE CDF OF BOTH THE IMAGES ---------------------------------*/	
		
		FindCDF cdf = new FindCDF();		
		
		cdfRedInit=cdf.input(storePixelRedInit,heightInit,widthInit);
		cdfGreenInit=cdf.input(storePixelGreenInit,heightInit,widthInit);
		cdfBlueInit=cdf.input(storePixelBlueInit,heightInit,widthInit);
		
		cdfRedSp = cdf.input(storePixelRedSp,heightSp,widthSp);
		cdfGreenSp = cdf.input(storePixelGreenSp,heightSp,widthSp);
		cdfBlueSp = cdf.input(storePixelBlueSp,heightSp,widthSp);
		

		
		
/*------------------------------CREATING THE MAPING TABLE ------------------------------------------*/	
		
		LookUpTable lkup =new LookUpTable();
		
		lookUpRed=lkup.createLookUpTable(cdfRedSp, cdfRedInit, heightInit, widthInit);
		
		lookUpGreen=lkup.createLookUpTable(cdfGreenSp, cdfGreenInit, heightInit, widthInit);
		
		lookUpBlue=lkup.createLookUpTable(cdfBlueSp, cdfBlueInit, heightInit, widthInit);
		
		
		
		for(int h = 0;h<heightInit;h++)
		{
			for(int w = 0;w<widthInit;w++)
			{
				for(int i=0;i<256;i++)
				{
					if(storePixelRedInit[h][w]==i)
					{	
						storePixelRedInit[h][w]=lookUpRed[i];
					}
				}
			}
		}

		
		
		
		for(int h = 0;h<heightInit;h++)
		{
			for(int w = 0;w<widthInit;w++)
			{
				for(int i=0;i<256;i++)
				{
					
					if(storePixelGreenInit[h][w]==i)
					{
						storePixelGreenInit[h][w]=lookUpGreen[i];
					}
					
				}
			}
		}
		
		
		
		for(int h = 0;h<heightInit;h++)
		{
			for(int w = 0;w<widthInit;w++)
			{
				for(int i=0;i<256;i++)
				{
					if(storePixelBlueInit[h][w]==i)
					{
						storePixelBlueInit[h][w]=lookUpBlue[i];
					}
				}
			}
		}
	
		for(int h = 0;h<heightInit;h++)
		{
			for(int w = 0;w<widthInit;w++)
			{
				result[h][w]= ((storePixelRedInit[h][w] <<16 & 0xff0000)+
						(storePixelRedInit[h][w]<<8 & 0x00ff00 ) +
						(storePixelRedInit[h][w] & 0x0000ff));
				
				

			}
		}

		File outputFile = new File("out.bmp");     /*Initializing the output image named as "out.bmp"*/
		BufferedImage img = new BufferedImage(widthInit,heightInit,BufferedImage.TYPE_INT_RGB);


		for(int h = 1;h<heightInit-1;h++)

		{
			for(int w = 1;w<widthInit-1;w++)
			{
				img.setRGB(w,h,(result[h][w]));
			}
		}
		ImageIO.write(img, "bmp", outputFile);


	}

}
