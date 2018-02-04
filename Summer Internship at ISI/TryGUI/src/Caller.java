
public class Caller 
{
	public void getPerformed(int x , int y, String inputImagePath,int threshold)
	{
		System.out.println("In caller");
		System.out.println(x +"           "+y);
		
		
		RegionGrow regnGrw = new RegionGrow();
		regnGrw.getRegion( x ,y,inputImagePath,threshold);
	}
}
