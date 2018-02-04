package alpha1;

import java.io.IOException;

public class Caller 
{
	public  String getCaller(String imagePath,String specifiedImagePath,int flag, double gamaValue ) throws IOException 
	{


		//int flag =1;
		////String imagePath=null;
		//String specifiedImagePath = null;
		String delims=null;
		String[] tokens =null;
		String[] tokens2 =null;
		String imageName = null;
		String extension = null;
		String outPutName = null;


		//imagePath = "C:/Documents and Settings/Administrator/Desktop/ah/city.jpg";	
		//specifiedImagePath = "C:/Documents and Settings/Administrator/Desktop/ah/city1.jpg";
		delims = "/";
		tokens = imagePath.split(delims);
		String imageFullName= tokens[tokens.length-1];
		delims = "[.]";
		tokens2 = imageFullName.split(delims);
		imageName = tokens2[0];
		extension = tokens2[1];





		/*----------------------------------	For histogram specification ----------------*/


		switch(flag){
		
		case 0:
			ImageNegatives imgNeg = new ImageNegatives();
			outPutName=imgNeg.getNegativeImage(imagePath, imageName, extension);
			break;

		case 1:

			LogTransform lgTrans = new LogTransform();
			try {
				outPutName=lgTrans.getLogTransform(imagePath, imageName, extension);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
			
		case 2:
			PowerTransform pwrTrn = new PowerTransform();
			outPutName=pwrTrn.getPowertransform(imagePath, imageName, extension,gamaValue);
			break;
			
			

		case 3:

			HistogramEqualizaton histoEqui = new HistogramEqualizaton();
			outPutName=histoEqui.getEqualizedHistogram(imagePath, imageName, extension);
			break;
			
		case 4:

			HistogramSpecification  histoSpeci = new HistogramSpecification ();
			outPutName=histoSpeci.getSpecification(imagePath,specifiedImagePath,imageName,extension);
			break;

		case 5:	

			EdgeDetection edg = new EdgeDetection();
			outPutName = edg.detectEdge(imagePath,imageName,extension);
			break;

		case 6:
			
			Laplacian lpcn = new Laplacian();
			outPutName =lpcn.getLaplacian(imagePath,imageName,extension);
			break;
		
		case 7:
			
			ImageThresholding thrshld = new ImageThresholding();
			outPutName = thrshld.getThreshold(imagePath,imageName,extension);
			break;







		}	
		return outPutName;	


	}


}