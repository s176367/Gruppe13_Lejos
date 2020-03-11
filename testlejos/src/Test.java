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


    public static void main(String[] args) {
        int i=0;
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Test test = new Test();
            test.tagBillede(i);
            test.sortHvid(i);
            i++;
            test.tagBillede(i);
            test.sortHvid(i);
            i++;
            test.tagBillede(i);
            test.sortHvid(i);


        Mat source = Imgcodecs.imread("testpicture2.jpg", Imgcodecs.IMREAD_COLOR);
        Mat destination = new Mat(source.rows(), source.cols(), source.type());
        Imgproc.applyColorMap(source,destination,1);
        Imgcodecs.imwrite("testpicture2.jpg",destination);

    }

    public void tagBillede(int antalBilleder){
        try {
            Webcam logitech = Webcam.getWebcamByName("Logitech Webcam C930e 1");
            logitech.open();
            ImageIO.write(logitech.getImage(), "jpg", new File("testpicture"+antalBilleder+".jpg"));
            logitech.close();
        } catch (IOException e) {
            System.out.println("Fejl " + e);
        }
    }
    public void sortHvid(int billede){
        Mat source = Imgcodecs.imread("testpicture"+billede+".jpg", Imgcodecs.IMREAD_COLOR);
        Mat destination = new Mat(source.rows(), source.cols(), source.type());
        Imgproc.applyColorMap(source,destination,1);
        Imgcodecs.imwrite("testpicture"+billede+".jpg",destination);
    }
}
