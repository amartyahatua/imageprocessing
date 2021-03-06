import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException; 
import javax.imageio.ImageIO;



public class Laplacian  extends Panel

{

	/**
	 * Enter the full path of the image
	 * Output image displaying the edges of the input image 
	 */
	private static final long serialVersionUID = 1L;

	

	BufferedImage  imageForDisplay; 
	static String extensionOfImage="";
	public static void main(String args[]) throws IOException

	{ 
		BufferedImage image;
		String imageName="C:/Documents and Settings/Administrator/Desktop/test/girl.png";
		File input = new File(imageName);
		image = ImageIO.read(input);

		

		String delims = "[.]";
		String[] tokens = imageName.split(delims);
		extensionOfImage = tokens[1];
		


		int w = image.getWidth(null);                 										/*Calculating the height and width of image */
		int h = image.getHeight(null);
		

			/*For storing pixel values */
		int storePixelRed[][]=new int [h][w];
		int storePixelGreen[][]=new int [h][w];
		int storePixelBlue[][]=new int [h][w];
		
		
		
		int storeMaskResultRed[][]=new int [h][w];
		int storeMaskResultGreen[][]=new int [h][w];
		int storeMaskResultBlue[][]=new int [h][w];/*For storing result after masking  */
		int  storeBinary[][]=new int [h][w];						    					/*For storing pixel values after comparing with threshold*/
	
		for(int height = 0;height<h;height++)
		{
			for(int width = 0;width<w;width++)
			{
				int clr=  image.getRGB(width,height); 	/*Pixel values finding*/
				int  red   = (clr & 0x00ff0000) >> 16;
				int  green = (clr & 0x0000ff00) >> 8;
				int  blue  = (clr & 0x000000ff);	  
				
				storePixelRed[height][width]=red;		
				storePixelGreen[height][width]=green;
				storePixelBlue[height][width]=blue;		
				
			}
		}
		
		
		
		int  sobelInX[][]= {{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};										/*Initializing Sobel mask*/
		int pixelInX=0, pixelInY=0;

		for(int height = 1;height<h-1;height++)
		{
			for(int width = 1;width<w-1;width++)
			{
				pixelInX= 
						(sobelInX[0][0]*storePixelRed[height-1][width-1])+
						(sobelInX[0][1]*storePixelRed[height-1][width])+
						(sobelInX[0][2]*storePixelRed[height-1][width+1])+
						(sobelInX[1][0]*storePixelRed[height][width-1])+						/*Masking operation*/
						(sobelInX[1][1]*storePixelRed[height][width])+
						(sobelInX[1][2]*storePixelRed[height][width+1])+
						(sobelInX[2][0]*storePixelRed[height+1][width-1])+
						(sobelInX[2][1]*storePixelRed[height+1][width])+
						(sobelInX[2][2]*storePixelRed[height+1][width+1]);


				storeMaskResultRed[height][width]=(int)(((pixelInX)));
				//String.valueOf(storeMaskResultRed[height][width]);
				if(storeMaskResultRed[height][width]>255)
					storeMaskResultRed[height][width]=255;
				else if(storeMaskResultRed[height][width]<0)
					storeMaskResultRed[height][width]=0;
				
			}

		}
		
		
		
		for(int height = 1;height<h-1;height++)
		{
			for(int width = 1;width<w-1;width++)
			{
				pixelInX= (sobelInX[0][0]*storePixelGreen[height-1][width-1])+
						(sobelInX[0][1]*storePixelGreen[height-1][width])+
						(sobelInX[0][2]*storePixelGreen[height-1][width+1])+
						(sobelInX[1][0]*storePixelGreen[height][width-1])+						/*Masking operation*/
						(sobelInX[1][1]*storePixelGreen[height][width])+
						(sobelInX[1][2]*storePixelGreen[height][width+1])+
						(sobelInX[2][0]*storePixelGreen[height+1][width-1])+
						(sobelInX[2][1]*storePixelGreen[height+1][width])+
						(sobelInX[2][2]*storePixelGreen[height+1][width+1]);

				/*pixelInY= (sobelInY[0][0]*storePixelGreen[height-1][width-1])+
						(sobelInY[0][1]*storePixelGreen[height-1][width])+
						(sobelInY[0][2]*storePixelGreen[height-1][width+1])+
						(sobelInY[1][0]*storePixelGreen[height][width-1])+
						(sobelInY[1][1]*storePixelGreen[height][width])+
						(sobelInY[1][2]*storePixelGreen[height][width+1])+
						(sobelInY[2][0]*storePixelGreen[height+1][width-1])+
						(sobelInY[2][1]*storePixelGreen[height+1][width])+
						(sobelInY[2][2]*storePixelGreen[height+1][width+1]);
*/
				storeMaskResultGreen[height][width]=(int) ((pixelInX));
				//String x=String.valueOf(storeMaskResultGreen[height][width]);
				
				if(storeMaskResultGreen[height][width]>255)
					storeMaskResultGreen[height][width]=255;
				else if (storeMaskResultGreen[height][width]<0)
					storeMaskResultGreen[height][width]=0;
			}

		}
				
		
		
		for(int height = 1;height<h-1;height++)
		{
			for(int width = 1;width<w-1;width++)
			{
				pixelInX= 
						(sobelInX[0][0]*storePixelBlue[height-1][width-1])+
						(sobelInX[0][1]*storePixelBlue[height-1][width])+
						(sobelInX[0][2]*storePixelBlue[height-1][width+1])+
						(sobelInX[1][0]*storePixelBlue[height][width-1])+						/*Masking operation*/
						(sobelInX[1][1]*storePixelBlue[height][width])+
						(sobelInX[1][2]*storePixelBlue[height][width+1])+
						(sobelInX[2][0]*storePixelBlue[height+1][width-1])+
						(sobelInX[2][1]*storePixelBlue[height+1][width])+
						(sobelInX[2][2]*storePixelBlue[height+1][width+1]);

				/*pixelInY= 
						(sobelInY[0][0]*storePixelBlue[height-1][width-1])+
						(sobelInY[0][1]*storePixelBlue[height-1][width])+
						(sobelInY[0][2]*storePixelBlue[height-1][width+1])+
						(sobelInY[1][0]*storePixelBlue[height][width-1])+
						(sobelInY[1][1]*storePixelBlue[height][width])+
						(sobelInY[1][2]*storePixelBlue[height][width+1])+
						(sobelInY[2][0]*storePixelBlue[height+1][width-1])+
						(sobelInY[2][1]*storePixelBlue[height+1][width])+
						(sobelInY[2][2]*storePixelBlue[height+1][width+1]);*/

				storeMaskResultBlue[height][width]=(int)((pixelInX));
				//String x=String.valueOf(storeMaskResultRed[height][width]);
				if(storeMaskResultBlue[height][width]>255)
					storeMaskResultBlue[height][width]=255;
				else if(storeMaskResultBlue[height][width]<0)
					storeMaskResultBlue[height][width]=0;
			}

		}
		
		
		
		
		for(int height = 1;height<h-1;height++)
		{
			for(int width = 1;width<w-1;width++)
			{
				storeBinary[height][width]=(int) ((storeMaskResultRed[height][width]<<16 & 0xff0000)+
												  (storeMaskResultGreen[height][width]<<8 & 0x00ff00 ) +
												  (storeMaskResultBlue[height][width] & 0x0000ff));
				
			}
		}
		

		
		File outputFile = new File("c:/out.bmp");     /*Initializing the output image named as "out.bmp"*/
		BufferedImage img = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);


		for(int x = 1;x<h-1;x++)

		{
			for(int y = 1;y<w -1;y++)
			{
				img.setRGB(y,x,(storeBinary[x][y]));
			}
		}
		ImageIO.write(img, "bmp", outputFile);

		}
}


