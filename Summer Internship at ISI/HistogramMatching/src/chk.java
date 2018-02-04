
public class chk 
{
	public static void main(String args[])
	{
		double [] x ={0.19,0.44,0.65,0.89,0.89,1,1,1};
		double []z ={0,0,0,0.15,0.35,0.65,0.85,1};
		int []lookup = new int [8];
		
		int j=0;
		
		for(int i=0;i<8;i++)
		{
			if(x[i]<=z[j])
				lookup[i]=j;
			else
			{
				while(x[i]>z[j])
					j++;
				if((z[j]-x[i])>(x[i]-z[j-1]))
				{
					
					//System.out.println(i+"   "+j);
					System.out.println((z[j]-x[i])+"        "+(x[i]-z[j-1]));
					lookup[i]=--j;
				}
				else 
					lookup[i]=j;
			}
			
		}

	}

}
