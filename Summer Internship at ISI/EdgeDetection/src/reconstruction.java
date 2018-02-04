import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;


public class reconstruction
{
    public static void main(String args[]) throws Exception 
    {
   
        File inputFile = new File("C:/Documents and Settings/Administrator/Desktop/ah/lena.bmp");
        BufferedImage bufferedImage = ImageIO.read(inputFile);
        int w = bufferedImage.getWidth(null);
        int h = bufferedImage.getHeight(null);
        double u=0;
        double v=0;

        
        
        //FileWriter fstream = new FileWriter("C:/Users/Aparna/Desktop/a.txt");
       // BufferedWriter out = new BufferedWriter(fstream);
        double A_mtrix[][]=new double [h][w];
        int[][] pixel=new int [h][w];
        int[][] storePixel1=new int[h][w];
        int[][] storePixel2=new int[8][8];
        int[][] quantization_matrix=new int[][]{{16,11,10,16,24,40,51,61},
        {12,12,14,19,26,58,60,55},
        {14,13,16,24,40,57,69,56},
        {14,17,22,29,51,87,80,62},
        {18,22,37,56,68,109,103,77},
        {24,35,55,64,81,104,113,92},
        {49,64,78,87,103,121,120,101},
        {72,92,95,98,112,100,103,99}};
        int loc=0;
        int index=0;
        int [] pp= new int[h*w];

        int pixel_red[][]=new int [h][w];
        int pixel_green[][]=new int [h][w];
        int pixel_blue[][]=new int [h][w];
     
        
       /* FileWriter fstream1 = new FileWriter("C:/Users/Aparna/Desktop/b.txt");
        BufferedWriter out1 = new BufferedWriter(fstream1);


        FileWriter fstream2 = new FileWriter("C:/Users/Aparna/Desktop/c.txt");
        BufferedWriter out2 = new BufferedWriter(fstream2);*/

        
        System.out.print(h);
        System.out.print(w);
       // File outputFile = new File("C:/Users/Aparna/Desktop/b.bmp");

        BufferedImage img = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
       
        
        
        for(int i=0;i<h;i++)
        {
            for (int j=0;j<w;j++)
            {
               
               
                int rgbValue=bufferedImage.getRGB(i,j);
                int red = ((rgbValue >> 16) & 0xFF)-128;
                int green = ((rgbValue >> 8) & 0xFF)-128;
                int blue = (rgbValue & 0xFF)-128;
                
            //int rgbValue=bufferedImage.
            String x1=String.valueOf(rgbValue);
                //out.write(red+"  "+" "+ " ");
                u=0;
                v=0;
                pixel_red[i][j]=red;
                pixel_green[i][j]=green;
                pixel_blue[i][j]=blue;
             //   img.setRGB(i, j, rgbValue);   //set pixel values
               
                pp[index++]=rgbValue;
               
                         
            }
            //out.newLine();
           
        }
        //out.close();

        
       
        //Reconstruction of image

  
        double transPixel[][] = new double[h][w];
        double multiOut[][] = new double[8][8];
        double interDCT[][] = new double[h][w];
        double interDCT1[][] = new double[8][8];
        double finalDCT[][] = new double[8][8];
        double tempDCT[][] = new double[8][8];
        double temp=0;
        double[][] transPixel1 =new double[8][8];
                
for (int i=0;i<h;i++)
       { 
           for (int j =0;j<w;j++)
           { 

     	
     	if(i==0)
{
temp=Math.sqrt(0.5);
}
else 
               temp=1;

             interDCT[i][j]=0.5*temp*Math.cos(((2*j+1)*Math.PI*i)/(2*8));
            // System.out.println(interDCT[i][j]);
           }
       }
     	
     	for (int i=0;i<8;i++)
     	       { 
     	           for (int j =0;j<8;j++)
     	           { 
     	               double temp1= interDCT[i][j];
     	               transPixel[j][i] = temp1;
     	               
     	           }
     	       }        
        int temp_array[][]=new int[8][8];
     	 
        for(int k=0;k<=(h-8);k=k+8)	
        {
         
        for(int l=0;l<=(w-8);l=l+8)
        {
        for(int n=k;n<(k+8);n++)
        {
        for(int m=l;m<(l+8);m++)
        {
        temp_array[n%8][m%8]=pixel_red[n][m];
        interDCT1[n%8][m%8]=interDCT[n][m];
       
transPixel1[n%8][m%8]=transPixel[n][m];
           }
        }
       
              
         for(int i = 0; i < 8; i++) 
               {
                     for(int j = 0; j < 8; j++) 
                     {
                         for(int p = 0; p <8; p++)
                         {                  
                             tempDCT[i][j] += interDCT1[i][p]*temp_array[p][j];
                         }
                     }  
               }
               
               
               
               
               for(int i = 0; i <8; i++) 
               {
                     for(int j = 0; j < 8; j++) 
                     {
                         for(int p = 0; p < 8; p++)
                         {                  
                             finalDCT[i][j] += tempDCT[i][p]*transPixel1[p][j];
                             
                          }
                         storePixel2[i][j]=(int) (finalDCT[i][j]/quantization_matrix[i][j]);
                         //System.out.print(storePixel2[i][j]+" "+" ");
                         
                         img.setRGB((i+k), (j+l), storePixel2[i][j]);
                     }  
                   //  System.out.println();
               }
             //  System.out.println();	
       
       
       
       

                //String x3=String.valueOf(storePixel2[n][m]+" "+" "+" ");
                //out2.write(x3);
               
        //out2.write(storePixel2[n][m]+"  "+" "+ " ");
        //System.out.println(count++);
        }
        }
       
        
        //ImageIO.write(img, "bmp", outputFile);   
        
    }

        
        
       /* for (int i=0;i<8;i++)
        { 
            for (int j =0;j<8;j++)
            { 
                
                System.out.print(finalDCT[i][j]+"  ");
                
            }
            System.out.println();
        }*/
    
        
    }