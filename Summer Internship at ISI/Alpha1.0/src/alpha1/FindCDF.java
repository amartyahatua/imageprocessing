/*package alpha1;


 * THIS CLASS TO FIND THE CDF 
 * OF BOTH THE IMAGES 
 



public class FindCDF
{
	public int [] histogram(int[][] colorScale,int height, int width )
	{
		int [] pixNum = new int [256];

		for(int c = 0; c<256; c++)
		{
			int sum = 0;
			for(int h=0;h<height;h++) 
			{
				for(int w=0;w<width;w++)
					if(colorScale[h][w]==c) sum++;
			}
			pixNum[c] = sum;

		}

		return pixNum;
	}


	public int [] getCDF(int [] histogram)
	{

		int [] cdf = new int [256];
		int cum = 0;
		for(int i = 0; i<256; i++)
		{
			cum += histogram[i];
			cdf[i] = cum;
		}
		return cdf;
	}

	public int getMinCDF(int [] cdf)
	{
		int minCDF = 257;
		for(int i = 0; i<256; i++)
		{
			if(cdf[i]<minCDF && cdf[i]!=0) minCDF = cdf[i];
		}
		return minCDF;
	}

	public int getMaxCDF(int [] cdf)
	{
		int maxCDF = 0;
		for(int i = 0; i<256; i++)
		{
			if(cdf[i]>maxCDF) maxCDF = cdf[i];
		}
		return maxCDF;
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




	public int[] input(int [][] pixelValues, int height, int width)
	{
		int histogramValue [] = new int[256];
		int cdf [] = new int[256];
		histogramValue = histogram(pixelValues, height, width);
		cdf = getCDF(histogramValue);

		return cdf;
	}
}
*/

package alpha1;

/*
 * THIS CLASS TO FIND THE CDF 
 * OF BOTH THE IMAGES 
 */



public class FindCDF
{
	public int [] histogram(int[][] colorScale,int height, int width )
	{
		int [] pixNum = new int [256];

		for(int c = 0; c<256; c++)
		{
			int sum = 0;
			for(int h=0;h<height;h++) 
			{
				for(int w=0;w<width;w++)
					if(colorScale[h][w]==c) sum++;
			}
			pixNum[c] = sum;

		}

		return pixNum;
	}


	public double [] getCDF(int [] histogram)
	{
		
		int [] cdfTemp = new int [256];
		double [] cdf = new double [256];
		int cum = 0;
		for(int i = 0; i<256; i++)
		{
			cum += histogram[i];
			cdfTemp[i] = cum;
			//System.out.println(cum);
		}
		
		for(int i = 0; i<256; i++)
		
			cdf[i]=(double)(cdfTemp[i]/(double)cdfTemp[255]);
	
		return cdf;
	}

	public double[] input(int [][] pixelValues, int height, int width)
	{
		int histogramValue [] = new int[256];
		double cdf [] = new double[256];
		histogramValue = histogram(pixelValues, height, width);
		cdf = getCDF(histogramValue);

		return cdf;
	}
}
































