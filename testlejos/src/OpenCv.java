import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class OpenCv {

    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

    static int width = 270;
    static int height = 249;

    public static void main(String []args) throws IOException{

        BufferedImage image = null;
        try {
            File input_file = new File("/Users/madsg/Desktop/tableTennis/ping_pong_PNG10377.png");
            image = new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB );

            image = ImageIO.read(input_file);


        }catch (IOException e){
            System.out.println("Error" + e);
        }

        try{
            File output_file = new File("C:/Users/madsg/Desktop/out.jpg");
            ImageIO.write(image,"jpg", output_file);
            System.out.println("Writing Complete");
        }catch (IOException e){
            System.out.println("Error" +e);

        }


    }
}
