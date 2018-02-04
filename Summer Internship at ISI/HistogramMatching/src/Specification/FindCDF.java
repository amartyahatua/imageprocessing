package Specification;

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
