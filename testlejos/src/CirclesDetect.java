import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class CirclesDetect {

    public void run(String[] args){
        String defaultname = "testpicture0.jpg";
        String filename = ((args.length>0) ? args[0] : defaultname);

        //load image
        Mat src = Imgcodecs.imread(filename,Imgcodecs.IMREAD_COLOR);

        if (src.empty()){
            System.out.println("Error opening picture");
        }

        Mat gray = new Mat();
        Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);
        Imgproc.medianBlur(gray,gray,5);

        Mat circles = new Mat();
        Imgproc.HoughCircles(gray,circles,Imgproc.HOUGH_GRADIENT,1, gray.rows(),50,30.0,1,20);

        for (int i = 0; i <circles.cols() ; i++) {
            double[] c = circles.get(0,i);

            Point center = new Point(Math.round(c[0]),Math.round(c[1]));
            //Circle center
            Imgproc.circle(src,center,1, new Scalar(0,200,100), 3, 8,0);
            //Circle outline
            int radius = (int) Math.round(c[2]);
            Imgproc.circle(src,center,radius,new Scalar(255,100,255),3,8,0);
        }
        HighGui.imshow("detected circles", src);
        HighGui.waitKey();

        System.exit(0);
    }

}
