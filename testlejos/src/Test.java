import com.github.sarxos.webcam.Webcam;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import javax.tools.Tool;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.List;

public class Test {
    static double alpha = 1;
    static double beta = 50;


    public static void main(String[] args) throws IOException, AWTException {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Rectangle screenRct = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = new Robot().createScreenCapture(screenRct);
        ImageIO.write(capture, "jpg",new File("testpicScreen.jpg"));


        //Mat source = Imgcodecs.imread("testpicture2.jpg", Imgcodecs.IMREAD_COLOR);
        //Mat destination = new Mat(source.rows(), source.cols(), source.type());
        /*Imgproc.applyColorMap(source,destination,1);
        Imgcodecs.imwrite("testpicture2.jpg",destination);*/

    }

    public void tagBillede(int antalBilleder) throws AWTException {
       /** try {
            Webcam logitech = Webcam.getWebcamByName("Logitech Webcam C930e 1");
            logitech.open();
            ImageIO.write(logitech.getImage(), "jpg", new File("testpicture"+antalBilleder+".jpg"));
            logitech.close();
        } catch (IOException e) {
            System.out.println("Fejl " + e);
        }**/

    }
    public void sortHvid(int billede){
        Mat source = Imgcodecs.imread("testpicture"+billede+".jpg", Imgcodecs.IMREAD_COLOR);
        Mat destination = new Mat(source.rows(), source.cols(), source.type());
        //Imgproc.applyColorMap(source,destination,1);
        Imgproc.cvtColor(source,destination,Imgproc.COLOR_BGR2GRAY);
        Imgcodecs.imwrite("testpicture"+billede+".jpg",destination);
    }
}
