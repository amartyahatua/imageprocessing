package Specification;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;




/*
 * THIS CLASS IS DOING THE SAME 
 * AS HISTOGRAM EQUALIZATION AND RECONSTRUCTING THE 
 * FINAL IMAGE.
 * METHOD "reconstruction" IS TAKING CDF AS INPUT
 * 
 */


public class ImageReconstruction 
{
	
	
	public int getMinCDF(int [] cdf)
	{
		int minCDF = 257;
		for(int i = 0; i<256; i++)
		{
			if(cdf[i]<minCDF && cdf[i]!=0) minCDF = cdf[i];
		}
		return minCDF;
	}

	
	public float[] equalization(int [] cdf, int pictSize)
	{
		int min = getMinCDF(cdf);
		float e [] = new float[256];

		for(int i = 0; i<256; i++)
		{
			e[i] = (float)((((float)cdf[i]-min)/(float)pictSize)*255);


		}
		for(int i = 0; i<256; i++)
		{
			if(e[i]<0) e[i]=0;
			if(e[i]>255) e[i]=255;	
		}
		return e;
	}
	
	
	public float [][] picEqualized(int [][]storePixel, float []equalization,int w, int h)
	{

		float [][] newGS = new float[h][w];

		for(int i = 0; i<h; i++)
		{
			for(int j = 0; j<w; j++)
			{

				newGS [i][j]=  equalization[storePixel[i][j]]; //convert

			}
		}
		return newGS;
	}

	
	public int[] reconstruction(int storePixel[][],int cdf[],int height,int width) throws IOException
	{
		
		float equalized [] = new float[256];
		float[][] picEqualized = new float[height][width];
		int [][] picEqualizedTemp = new int[height][width];
		int result [] = new int[height*width];
		int counter=0;
		int size = height*width;
		ImageReconstruction recons = new ImageReconstruction();
		equalized=recons.equalization(cdf, size);
		picEqualized = recons.picEqualized(storePixel,equalized,width, height);
		
		for(int h = 0;h<height;h++)
		{
			for(int w = 0;w<width;w++)
			{
				picEqualizedTemp[h][w]=(int)picEqualized[h][w];
				result[counter] = picEqualizedTemp[h][w];
				counter++;
			}
		}
		return result;
		
	}

}
