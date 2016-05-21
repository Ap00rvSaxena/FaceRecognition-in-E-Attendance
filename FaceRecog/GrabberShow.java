/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FaceRecog;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_core.Mat;
import static org.bytedeco.javacpp.opencv_core.cvFlip;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;
import org.bytedeco.javacpp.opencv_videoio.VideoCapture;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.bytedeco.javacv.VideoInputFrameGrabber;


public class GrabberShow implements Runnable {
    public static void main(String[] args) {
  //Create canvas frame for displaying webcam.
     CanvasFrame canvas = new CanvasFrame("Webcam"); 
   
  //Set Canvas frame to close on exit
     canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);   
      
     //Declare FrameGrabber to import output from webcam
     FrameGrabber grabber = new OpenCVFrameGrabber("");  
      
      
     try {      
       
      //Start grabber to capture video
      grabber.start();      
       
      //Declare img as IplImage
      IplImage img;
       
      while (true) {
        
       //inser grabed video fram to IplImage img
       img = grabber.grab();
        
       //Set canvas size as per dimentions of video frame.
       canvas.setCanvasSize(grabber.getImageWidth(), grabber.getImageHeight()); 
        
       if (img != null) {      
         //Flip image horizontally
         cvFlip(img, img, 1);
        //Show video frame in canvas
        canvas.showImage(img);               
        }
       }
      }
     catch (Exception e) {      
     }
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}