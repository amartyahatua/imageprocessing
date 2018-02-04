/*package alpha1;



 * THIS CLASS TO CREATE THE LOOKUP TABLE 
 * WHICH IS USING TO MAP THE CDF VALUES 
 *
 


public class LookUpTable 
{
	public int[] createLookUpTable(int cdfInit[],int cdfSp[],int height,int width)
	{
		int size = height*width;
		int [] lookUp = new int[size];
		int j=0;

		for(int i=0;i<256;i++)
		{
			if(cdfInit[i]<=cdfSp[j])
				lookUp[i]=j;
			else
			{
				while(cdfInit[i]>cdfSp[j])
					j++;
				if((cdfSp[j]-cdfInit[i])>(cdfInit[i]-cdfSp[j-1]))
					lookUp[i]=--j;
				else 
					lookUp[i]=j;
			}

		}


		

		return lookUp;
	}

}
*/

package alpha1;


/*
 * THIS CLASS TO CREATE THE LOOKUP TABLE 
 * WHICH IS USING TO MAP THE CDF VALUES 
 *
 */


public class LookUpTable 
{
	public int[] createLookUpTable(double cdfSp[],double cdfInit[],int height,int width)
	{
		
		int [] lookUp = new int[256];

		for(int i=0;i<256;i++)
		{
			double temp2=10000;
			for(int j=0;j<256;j++)
			{
				double temp1 = (cdfInit[i]-cdfSp[j]);
				temp1 = Math.abs(temp1);
				if(temp1<temp2)
				{
					temp2=temp1;
					lookUp[i]=j-65;
					if(lookUp[i]<0)
						lookUp[i]=0;
					else if(lookUp[i]>200)
						lookUp[i]=255;
					//System.out.println(j);
				}
			}
		}
		

		return lookUp;
	}

}
































