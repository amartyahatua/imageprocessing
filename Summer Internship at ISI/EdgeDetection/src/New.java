import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException; 
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import javax.swing.JFrame;



public class New  extends Panel

{

	/**
	 * Enter the full path of the image
	 * Output image displaying the edges of the input image 
	 */
	private static final long serialVersionUID = 1L;

	public New()
	{
		displayImage();
	}	



	BufferedImage  imageForDisplay; 
	static String extensionOfImage="";
	public static void main(String args[]) throws IOException

	{ 
		BufferedImage image;
		//System.out.println("Enter image name\n");
		//BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));				/*Enter the image*/
		String imageName="C:/Documents and Settings/Administrator/Desktop/ah/lena1.jpg";
		File input = new File(imageName);
		image = ImageIO.read(input);



		String delims = "[.]";
		String[] tokens = imageName.split(delims);
		extensionOfImage = tokens[1];
		System.out.println(extensionOfImage);


		int w = 512;//image.getWidth(null);                 										/*Calculating the height and width of image */
		int h = 512;//image.getHeight(null);

			/*For storing pixel values */
		double storePixelRed[][]=new double [w][h];
		double storePixelGreen[][]=new double [w][h];
		double storePixelBlue[][]=new double [w][h];
		
		FileWriter fstream = new FileWriter("C:/Documents and Settings/Administrator/Desktop/ah/abc.text");
		BufferedWriter out = new BufferedWriter(fstream);
		
		int storeMaskResultRed[][]=new int [w][h];
		int storeMaskResultGreen[][]=new int [w][h];
		int storeMaskResultBlue[][]=new int [w][h];/*For storing result after masking  */
		int  storeBinary[][]=new int [w][h];						    					/*For storing pixel values after comparing with threshold*/
		for(int height = 0;height<h;height++)
		{
			for(int width = 0;width<w;width++)
			{
				int clr=  image.getRGB(height,width); 	/*Pixel values finding*/
				
			
				int  red   = (clr & 0x00ff0000) >> 16;
				int  green = (clr & 0x0000ff00) >> 8;
				int  blue  = (clr & 0x000000ff);	  
				
				
				storePixelRed[height][width]=red;
				storePixelGreen[height][width]=green;
				storePixelBlue[height][width]=blue;
				
			}
		}


		
		

		int  sobelInX[][]= {{-1,0,1},{-2,0,2},{-1,0,1}};
		int  sobelInY[][]= {{-1,-2,-1},{0,0,0},{1,2,1}};/*Initializing Sobel mask*/
		
		
		double pixelInX=0, pixelInY=0;
		
		for(int height = 1;height<h-1;height++)
		{
			for(int width = 1;width<w-1;width++)
			{
				pixelInX= (sobelInX[0][0]*storePixelRed[height-1][width-1])+
						(sobelInX[0][1]*storePixelRed[height-1][width])+
						(sobelInX[0][2]*storePixelRed[height-1][width+1])+
						(sobelInX[1][0]*storePixelRed[height][width-1])+						/*Masking operation*/
						(sobelInX[1][1]*storePixelRed[height][width])+
						(sobelInX[1][2]*storePixelRed[height][width+1])+
						(sobelInX[2][0]*storePixelRed[height+1][width-1])+
						(sobelInX[2][1]*storePixelRed[height+1][width])+
						(sobelInX[2][2]*storePixelRed[height+1][width+1]);

				pixelInY= (sobelInY[0][0]*storePixelRed[height-1][width-1])+
						(sobelInY[0][1]*storePixelRed[height-1][width])+
						(sobelInY[0][2]*storePixelRed[height-1][width+1])+
						(sobelInY[1][0]*storePixelRed[height][width-1])+
						(sobelInY[1][1]*storePixelRed[height][width])+
						(sobelInY[1][2]*storePixelRed[height][width+1])+
						(sobelInY[2][0]*storePixelRed[height+1][width-1])+
						(sobelInY[2][1]*storePixelRed[height+1][width])+
						(sobelInY[2][2]*storePixelRed[height+1][width+1]);

				storeMaskResultRed[height][width]=(int)Math.ceil((Math.sqrt((pixelInX*pixelInX)+(pixelInY*pixelInY))));
				String x=String.valueOf(storeMaskResultRed[width][height]);
				//out.write(x);
				//out.newLine();
			}

		}
		
		
		System.out.println(storeMaskResultRed[1][1]);
		
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

				pixelInY= (sobelInY[0][0]*storePixelGreen[height-1][width-1])+
						(sobelInY[0][1]*storePixelGreen[height-1][width])+
						(sobelInY[0][2]*storePixelGreen[height-1][width+1])+
						(sobelInY[1][0]*storePixelGreen[height][width-1])+
						(sobelInY[1][1]*storePixelGreen[height][width])+
						(sobelInY[1][2]*storePixelGreen[height][width+1])+
						(sobelInY[2][0]*storePixelGreen[height+1][width-1])+
						(sobelInY[2][1]*storePixelGreen[height+1][width])+
						(sobelInY[2][2]*storePixelGreen[height+1][width+1]);

				storeMaskResultGreen[height][width]=(int)Math.ceil((Math.sqrt((pixelInX*pixelInX)+(pixelInY*pixelInY))));
				String x=String.valueOf(storeMaskResultGreen[width][height]);
				//out.write(x);
				//out.newLine();
			}

		}
		for(int height = 1;height<h-1;height++)
		{
			for(int width = 1;width<w-1;width++)
			{
				pixelInX= (sobelInX[0][0]*storePixelBlue[height-1][width-1])+
						(sobelInX[0][1]*storePixelBlue[height-1][width])+
						(sobelInX[0][2]*storePixelBlue[height-1][width+1])+
						(sobelInX[1][0]*storePixelBlue[height][width-1])+						/*Masking operation*/
						(sobelInX[1][1]*storePixelBlue[height][width])+
						(sobelInX[1][2]*storePixelBlue[height][width+1])+
						(sobelInX[2][0]*storePixelBlue[height+1][width-1])+
						(sobelInX[2][1]*storePixelBlue[height+1][width])+
						(sobelInX[2][2]*storePixelBlue[height+1][width+1]);

				pixelInY= (sobelInY[0][0]*storePixelBlue[height-1][width-1])+
						(sobelInY[0][1]*storePixelBlue[height-1][width])+
						(sobelInY[0][2]*storePixelBlue[height-1][width+1])+
						(sobelInY[1][0]*storePixelBlue[height][width-1])+
						(sobelInY[1][1]*storePixelBlue[height][width])+
						(sobelInY[1][2]*storePixelBlue[height][width+1])+
						(sobelInY[2][0]*storePixelBlue[height+1][width-1])+
						(sobelInY[2][1]*storePixelBlue[height+1][width])+
						(sobelInY[2][2]*storePixelBlue[height+1][width+1]);

				storeMaskResultBlue[height][width]=(int)Math.ceil((Math.sqrt((pixelInX*pixelInX)+(pixelInY*pixelInY))));
				String x=String.valueOf(storeMaskResultRed[width][height]);
				//out.write(x);
				//out.newLine();
			}

		}
		
				
		
		
		for(int height = 1;height<h-1;height++)
		{
			for(int width = 1;width<w-1;width++)
			{
				pixelInX=0;pixelInY=0;
				for(int I=-1;I<=1;I++)
				{
					for(int J=-1;J<=1;J++)
					{
						pixelInX=pixelInX+storePixelRed[width+I][height+J]*sobelInX[I+1][J+1];
					}
				}
				
				for(int I=-1;I<=1;I++)
				{
					for(int J=-1;J<=1;J++)
					{
						pixelInY=pixelInY+storePixelRed[width+I][height+J]*sobelInY[I+1][J+1];
					}
				}

				storeMaskResultRed[width][height]=(int)Math.ceil((Math.sqrt((pixelInX*pixelInX)+(pixelInY*pixelInY))));

				
			}
			

		}	
		System.out.println(storeMaskResultRed[1][1]);
		
		FileWriter fstream1 = new FileWriter("C:/Documents and Settings/Administrator/Desktop/ah/abc.text");
		BufferedWriter out1 = new BufferedWriter(fstream);
		String x1="dd";
		
		
		for(int height = 0;height<h-1;height++)
		{
			for(int width = 0;width<w-1;width++)
			{
				int x=(storeMaskResultRed[height][width] );
				int y=(storeMaskResultGreen[width][height]);
				int z=storeMaskResultBlue[width][height];
				String x2 = String.valueOf(x);
				String x3 = String.valueOf(y);
				String x4 = String.valueOf(z);
				
				
				out.write(x2);
				out.newLine();
				
				
				
			}
			
		}
		
		
		
		for(int height = 1;height<h-1;height++)
		{
			for(int width = 1;width<w-1;width++)
			{
				storeBinary[width][height]=(int) ((storeMaskResultRed[width][height]<<16 & 0xff0000)+
												  (storeMaskResultGreen[width][height]<<8 & 0x00ff00 ) +
												  (storeMaskResultBlue[width][height] & 0x0000ff));
												    
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
					img.setRGB(width,height,(storeBinary[width][height]));
			}
		}

		ImageIO.write(img, extensionOfImage, outputFile); 
		JFrame frame =new JFrame("Display image");
		Panel panel =new EdgeDetection();																//Calling display method
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
			String imageName ="out.bmp";
			File input =new File(imageName);
			imageForDisplay = ImageIO.read(input);
		}

		catch (IOException ie)
		{
			System.out.println("Error:"+ie.getMessage());
		}
	}	
}


