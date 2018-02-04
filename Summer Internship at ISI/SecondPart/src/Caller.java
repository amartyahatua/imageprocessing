
import java.awt.Point;
import java.util.Stack;

import javax.swing.plaf.synth.Region;


public class Caller 
{
	public String   getPerformed(String path,Stack<Point> storeCoordinates,int select,int threshold[])
	{	String outPut="";
		if(select==1)
		{
			Thresholding thrdlng = new Thresholding();
			thrdlng.getThreshold(path);
			outPut="out_threshold.bmp";
		}
		
		else if(select==2)
		{
			System.out.println("Region growing ");
			RegionGrow regnGrw = new  RegionGrow();
			regnGrw.getRegion(storeCoordinates, path,threshold);
			outPut="out_initial1.bmp";
		
		}
		
		return outPut;

		
	}
}
