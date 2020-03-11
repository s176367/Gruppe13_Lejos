import com.github.sarxos.webcam.Webcam;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Test {
    static double alpha = 1;
    static double beta = 50;

    int i;
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Test test = new Test();
        test.tagBillede(2);

        Mat source = Imgcodecs.imread("/Users/madsg/Desktop/backend ret opgaver/Galgeleg (1)/Gruppe13_Lejos/testpicture2.jpg", Imgcodecs.IMREAD_COLOR);
        Mat destination = new Mat(source.rows(), source.cols(), source.type());
        source.convertTo(destination, -50,alpha, beta );
        Imgproc.applyColorMap(source,destination,1);
        Imgcodecs.imwrite("Users/madsg/Desktop/backend ret opgaver/Galgeleg (1)/Gruppe13_Lejos/testpicture2.jpg",destination);

    }

    public void tagBillede(int antalBilleder){
        antalBilleder = 2;
        try {
            Webcam logitech = Webcam.getWebcamByName("Logitech Webcam C930e 1");
            logitech.open();
            ImageIO.write(logitech.getImage(), "jpg", new File("testpicture"+antalBilleder+".jpg"));
            logitech.close();
        } catch (IOException e) {
            System.out.println("Fejl " + e);
        }
    }
}
