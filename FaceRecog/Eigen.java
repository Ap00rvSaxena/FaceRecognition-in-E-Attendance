/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FaceRecog;


import java.io.File;
import java.io.FilenameFilter;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_face.*;
import static org.bytedeco.javacpp.opencv_highgui.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_objdetect.*;

/**
 *
 * @author user
 */
public class Eigen {
    public static void main(String[] args)  {
        
                File root = new File("testing\\");

		FilenameFilter pngFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".png");
			}
		};

		File[] imageFiles = root.listFiles(pngFilter);
                int[] labels = new int[imageFiles.length];
                MatVector images = new MatVector(imageFiles.length);
                                
                IplImage img=null;
                int counter = 0;
                int label;
       
   for (File image : imageFiles) {
        img = cvLoadImage(image.getAbsolutePath());
        String temp= image.getName();
        label = Integer.parseInt(temp.charAt(0)+"");
        labels[counter] = label;
        counter++;
    }
    FaceRecognizer fr = createEigenFaceRecognizer();    
    fr.train(images, AbstractMat.EMPTY);
    
}
}