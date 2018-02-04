package alpha2;

import java.awt.Point;
import java.util.Stack;

public class GrowImageForARegion 
{
	public int[][] Region(int storePixelRed[][],int storePixelGreen[][],int storePixelBlue[][],int x,int y,int height,int width,int thresholdRed,int thresholdGreen,int thresholdBlue)
	{
		System.out.println("Pls");
		
		System.out.println(x);
		System.out.println(y);
		
		int seedRed=storePixelRed[y][x];
		int seedGreen=storePixelGreen[y][x];
		int seedBlue=storePixelBlue[y][x];

		System.out.println("Red "+seedRed);
		System.out.println("Green "+seedGreen);
		System.out.println("Blue "+seedBlue);

		int [][]seedPointsRed  = new int[height][width];
		int [][]seedPointsGreen  = new int[height][width];
		int [][]seedPointsBlue  = new int[height][width];
		int [][]seedPoints = new int[height][width];

		int [][]labelsRed  = new int[height][width];
		int [][]labelsGreen  = new int[height][width];
		int [][]labelsBlue  = new int[height][width];
		
		int [][]result  = new int[height][width];
		
		

/*---------------------------------Selecting pixels with seed values----------------------*/
		for(int h=0;h<height;h++)
		{
			for(int w=0;w<width;w++)
			{
				if(((storePixelRed[h][w]<=seedRed+5)&&(storePixelRed[h][w]>=seedRed-5))&&((storePixelGreen[h][w]<=seedGreen+5)&&(storePixelGreen[h][w]>=seedGreen-5))&&((storePixelBlue[h][w]<=seedBlue+5)&&storePixelBlue[h][w]>=seedBlue-5))
				{
					seedPointsRed[h][w]=seedRed;
					seedPointsGreen[h][w]=seedGreen;
					seedPointsBlue[h][w]=seedBlue;
				}

				else
				{
					seedPointsRed[h][w]=0;
					seedPointsGreen[h][w]=0;
					seedPointsBlue[h][w]=0;
				}


				labelsRed[h][w] = -1;
				labelsGreen[h][w] = -1;
				labelsBlue[h][w] = -1;
			}

		}



/*--------------------------Stacks------------------------------------------------------*/


		Stack<Point> storeConnectedRed = new Stack<Point>();
		Stack<Point> storeConnectedGreen = new Stack<Point>();
		Stack<Point> storeConnectedBlue = new Stack<Point>();
		Stack<Point> storeConnected = new Stack<Point>();



/*--------------------------------ENTER THE SEEDS IN QUEUE------------------------------*/

		for(int h=0;h<height;h++)
		{
			for(int w=0;w<width;w++)
			{
				
				if((seedPointsRed[h][w]==seedRed) &&(seedPointsGreen[h][w]==seedGreen)&&(seedPointsBlue[h][w]==seedBlue))
				{
					storeConnected.add(new Point(w,h));
				}
			}
		}

/*--------------------------------NEXT OPERATION----------------------------------------*/


		
		while(storeConnected.size() > 0)
		{



			Point thisPoint = storeConnected.get(0); 
			storeConnected.remove(0);


			for(int th=-1;th<=1;th++)
			{
				for(int tw=-1;tw<=1;tw++)
				{
					int rx = thisPoint.x+tw;
					int ry = thisPoint.y+th;// Skip pixels outside of the image.


					if ((rx < 0) || (ry < 0) || (ry>=height) || (rx>=width)) continue;
					if ((labelsRed[ry][rx] < 0)&&(labelsGreen[ry][rx] < 0)&&(labelsBlue[ry][rx] < 0)) 
					{
						if ((Math.abs(storePixelRed[ry][rx]-seedRed)<=thresholdRed)&&(Math.abs(storePixelGreen[ry][rx]-seedGreen)<=thresholdGreen)&&(Math.abs(storePixelBlue[ry][rx]-seedBlue)<=thresholdBlue))
						{ 
							storeConnected.add(new Point(rx,ry));
							seedPointsRed[ry][rx]=seedRed;
							seedPointsGreen[ry][rx]=seedGreen;
							seedPointsBlue[ry][rx]=seedBlue;
							
							labelsBlue[ry][rx]=1;
							labelsGreen[ry][rx]=1;
							labelsRed[ry][rx]=1;
							
						}
						else 
							seedPointsBlue[ry][rx]=0;
					}
				} 
			}		
		}// End of while 
		
		
		
/*----------------------------------Entering results in an array-----------------------*/
	
		for(int h = 0;h<height;h++)
		{
			for(int w = 0;w<width;w++)
			{
				
				result[h][w]= ((seedPointsRed[h][w] <<16 & 0xff0000)+
						(seedPointsGreen[h][w]<<8 & 0x00ff00 ) +
						(seedPointsBlue[h][w] & 0x0000ff));

			}
		}
		
		
		return result;

	}
}
