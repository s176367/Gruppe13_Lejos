
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GetSetPixels {

    static double alpha = 1;
    static double beta = 50;
    public static void main(String[] args) {

        try{
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            Mat source = Imgcodecs.imread("/Users/madsg/Desktop/tableTennis/pingpong.jpg",Imgcodecs.IMREAD_COLOR);
            Mat source2 = Imgcodecs.imread("/Users/madsg/Desktop/tableTennis/pingpong_sorthvid.jpg");
            Mat destination = new Mat(source.rows(), source.cols(), source.type());
            Mat destination2 = new Mat(source2.rows(), source2.cols(), source2.type());
            source.convertTo(destination, -50,alpha, beta );
            source2.convertTo(destination2,-50,alpha,beta);


           // CascadeClassifier cas = new CascadeClassifier();
            //cas.load("haarcscade_frontalface_alt.xml");


           Imgproc.GaussianBlur(source, destination,new Size(0,0), 3, 2);
          Imgproc.applyColorMap(source2,destination2, 1);

            Imgcodecs.imwrite("/Users/madsg/Desktop/tableTennis/pingpong_sorthvid.jpg", destination);
            Imgcodecs.imwrite("/Users/madsg/Desktop/tableTennis/pingpong_sorthvidmedBlur.jpg", destination2);
            System.out.println("Image changed");


        }catch (Exception e){
            System.out.println("Error "+ e);
        }





    }
}
