import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException; 
import javax.imageio.ImageIO;
import javax.swing.JFrame;



public class LaplacianChk  extends Panel

{

	/**
	 * Enter the full path of the image
	 * Output image displaying the edges of the input image 
	 */
	private static final long serialVersionUID = 1L;

	public LaplacianChk()
	{
		displayImage();
	}	



	BufferedImage  imageForDisplay; 
	static String extensionOfImage="";
	public static void main(String args[]) throws IOException

	{ 
		BufferedImage image;
		String imageName="C:/Documents and Settings/Administrator/Desktop/test/lena.bmp";
		File input = new File(imageName);
		image = ImageIO.read(input);

		

		String delims = "[.]";
		String[] tokens = imageName.split(delims);
		extensionOfImage = tokens[1];
		


		int w = image.getWidth(null);                 										/*Calculating the height and width of image */
		int h = image.getHeight(null);
		int maxRed=-100,minRed=100;
		int maxGreen=-100,minGreen=100;
		int maxBlue=-100,minBlue=100;
		

			/*For storing pixel values */
		int storePixelRed[][]=new int [h][w];
		int storePixelGreen[][]=new int [h][w];
		int storePixelBlue[][]=new int [h][w];
		
		
		
		int storeMaskResultRed[][]=new int [h][w];
		int storeMaskResultGreen[][]=new int [h][w];
		int storeMaskResultBlue[][]=new int [h][w];
		
													/*For storing result after masking  */
		
		
		int storeNormalizedResultRed[][]=new int [h][w];
		int storeNormalizedResultGreen[][]=new int [h][w];
		int storeNormalizedResultBlue[][]=new int [h][w];
		
		
		
		
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
		
		
		
		int  laplace[][]= {{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};										/*Initializing laplace mask*/
		int pixel=0;

		for(int height = 1;height<h-1;height++)
		{
			for(int width = 1;width<w-1;width++)
			{
				pixel= 
						(laplace[0][0]*storePixelRed[height-1][width-1])+
						(laplace[0][1]*storePixelRed[height-1][width])+
						(laplace[0][2]*storePixelRed[height-1][width+1])+
						(laplace[1][0]*storePixelRed[height][width-1])+						/*Masking operation*/
						(laplace[1][1]*storePixelRed[height][width])+
						(laplace[1][2]*storePixelRed[height][width+1])+
						(laplace[2][0]*storePixelRed[height+1][width-1])+
						(laplace[2][1]*storePixelRed[height+1][width])+
						(laplace[2][2]*storePixelRed[height+1][width+1]);


				storeMaskResultRed[height][width]=(int)(((pixel)));
				
				/*if(storeMaskResultRed[height][width]>225)
					storeMaskResultRed[height][width]=225;
				else if(storeMaskResultRed[height][width]<0)
					storeMaskResultRed[height][width]=0;*/
				
				
				if(pixel>maxRed)
					maxRed=pixel;
				
				if(pixel<minRed)
					minRed=pixel;
				
			}

		}
		
		
		
		for(int height = 1;height<h-1;height++)
		{
			for(int width = 1;width<w-1;width++)
			{
				pixel= 
						(laplace[0][0]*storePixelGreen[height-1][width-1])+
						(laplace[0][1]*storePixelGreen[height-1][width])+
						(laplace[0][2]*storePixelGreen[height-1][width+1])+
						(laplace[1][0]*storePixelGreen[height][width-1])+						/*Masking operation*/
						(laplace[1][1]*storePixelGreen[height][width])+
						(laplace[1][2]*storePixelGreen[height][width+1])+
						(laplace[2][0]*storePixelGreen[height+1][width-1])+
						(laplace[2][1]*storePixelGreen[height+1][width])+
						(laplace[2][2]*storePixelGreen[height+1][width+1]);

				
				storeMaskResultGreen[height][width]=(int) ((pixel));
				
				/*if(storeMaskResultGreen[height][width]>225)
					storeMaskResultGreen[height][width]=225;
				else if (storeMaskResultGreen[height][width]<0)
					storeMaskResultGreen[height][width]=0;
				*/
				if(pixel>maxGreen)
					maxGreen=pixel;
				
				if(pixel<minGreen)
					minGreen=pixel;
				
				
				
			}

		}
				
		
		
		for(int height = 1;height<h-1;height++)
		{
			for(int width = 1;width<w-1;width++)
			{
				pixel= 
						(laplace[0][0]*storePixelBlue[height-1][width-1])+
						(laplace[0][1]*storePixelBlue[height-1][width])+
						(laplace[0][2]*storePixelBlue[height-1][width+1])+
						(laplace[1][0]*storePixelBlue[height][width-1])+						/*Masking operation*/
						(laplace[1][1]*storePixelBlue[height][width])+
						(laplace[1][2]*storePixelBlue[height][width+1])+
						(laplace[2][0]*storePixelBlue[height+1][width-1])+
						(laplace[2][1]*storePixelBlue[height+1][width])+
						(laplace[2][2]*storePixelBlue[height+1][width+1]);

				storeMaskResultBlue[height][width]=(int)((pixel));
				
				/*if(storeMaskResultBlue[height][width]>225)
					storeMaskResultBlue[height][width]=225;
				else if(storeMaskResultBlue[height][width]<0)
					storeMaskResultBlue[height][width]=0;
				*/
				
				if(pixel>maxBlue)
					maxBlue=pixel;
				
				if(pixel<minBlue)
					minBlue=pixel;
				
				
				
				
			}

		}
		

		double resultRed=0,resultGreen=0,resultBlue=0;
		
		System.out.println("Max red: "+maxRed+"Min red: "+minRed);
		System.out.println("Max green: "+maxGreen+"Min green: "+minGreen);
		System.out.println("Max blue: "+maxBlue+"Min blue: "+minBlue);
		
		for(int height = 1;height<h-1;height++)
		{
			for(int width = 1;width<w-1;width++)
			{
				resultRed = (storeMaskResultRed[height][width]-minRed)*(255/(maxRed-minRed));
				storeNormalizedResultRed[height][width]=(int)resultRed;
				
				resultGreen = (storeMaskResultGreen[height][width]-minGreen)*(255/(maxGreen-minGreen));
				storeNormalizedResultGreen[height][width]=(int)resultGreen;
				
				resultBlue = (storeMaskResultBlue[height][width]-minBlue)*(255/(maxBlue-minBlue));
				storeNormalizedResultBlue[height][width]=(int)resultBlue;
			}
		}
		
		
		
		
	
		
		for(int height = 1;height<h-1;height++)
		{
			for(int width = 1;width<w-1;width++)
			{
				storeBinary[height][width]=(int) ((storeNormalizedResultRed[height][width]<<16 & 0xff0000)+
												  (storeNormalizedResultGreen[height][width]<<8 & 0x00ff00 ) +
												  (storeNormalizedResultBlue[height][width] & 0x0000ff));
				
			}
		}
		

		
		String x= "out.";
		String y= x.concat(extensionOfImage);

		File outputFile = new File(y);     /*Initializing the output image named as "out.bmp"*/

		BufferedImage img = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);

		for(int height = 1;height<h-1;height++)
		
		{
			for(int width = 1;width<w-1;width++)
			{
					img.setRGB(width,height,(storeBinary[height][width]));
			}
		}

		ImageIO.write(img, extensionOfImage, outputFile); 
		JFrame frame =new JFrame("Display image");
		Panel panel =new LaplacianChk();																/*Calling display method*/
		frame.getContentPane().add(panel);
		frame.setSize(520, 520);
		frame.setVisible(true);

	}

	/*------------------------Paint method------------------------------*/

	public void paint(Graphics g)

	{
		g.drawImage(imageForDisplay, 0, 0, null);
	}


	/*----------------------------Display method ------------------------*/

	public void displayImage() 
	{
		try
		{
			String imageName ="out."+extensionOfImage;
			File input =new File(imageName);
			imageForDisplay = ImageIO.read(input);
		}

		catch (IOException ie)
		{
			System.out.println("Error:"+ie.getMessage());
		}
	}	
}


