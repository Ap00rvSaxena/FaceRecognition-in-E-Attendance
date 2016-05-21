package FaceRecog;

//import com.googlecode.javacv.cpp.opencv_contrib.FaceRecognizer;
//import com.googlecode.javacv.cpp.opencv_core.IplImage;
//import com.googlecode.javacv.cpp.opencv_core.MatVector;
import java.awt.image.BufferedImage;
import static org.bytedeco.javacpp.opencv_core.IPL_DEPTH_8U;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_core.MatVector;
import org.bytedeco.javacpp.opencv_face.FaceRecognizer;
import static org.bytedeco.javacpp.opencv_face.createEigenFaceRecognizer;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;
import static org.bytedeco.javacpp.opencv_imgproc.CV_BGR2GRAY;
import static org.bytedeco.javacpp.opencv_imgproc.cvCvtColor;


public class FaceRecognition {

    public void checkFace(String imagePath, BufferedImage frame) {
        // Video Camera Frame       
        IplImage getVCFrame = new IplImage();
        getVCFrame = IplImage.createFrom(frame);

        // Frame from Storage
        IplImage img;
        IplImage grayImg;
        int numberOfImages = 1;
        int label;

        MatVector images = new MatVector(numberOfImages);
        int[] labels = new int[numberOfImages];

        img = cvLoadImage(imagePath);
        label = 1;
        grayImg = IplImage.create(img.width(), img.height(), IPL_DEPTH_8U, 1);
        cvCvtColor(img, grayImg, CV_BGR2GRAY);

        images.put(0, img);
        labels[0] = label;

        IplImage GrayVCFrame = IplImage.create(getVCFrame.width(), getVCFrame.height(), IPL_DEPTH_8U, 1);


//        FaceRecognizer fr = createFisherFaceRecognizer();
        FaceRecognizer fr = createEigenFaceRecognizer();
        // FaceRecognizer faceRecognizer = createLBPHFaceRecognizer();

        fr.train(images, labels);
        cvCvtColor(getVCFrame, GrayVCFrame, CV_BGR2GRAY);
    }
}