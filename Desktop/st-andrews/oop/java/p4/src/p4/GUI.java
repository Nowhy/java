package p4;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI {
	
	
    private static int width = 1920;
    private static int height = 1080;
    
	public static void main(String args[]) {
        
		 int point;
		MandelbrotCalculator mandelCalc = new MandelbrotCalculator();
		int[][] madelbrotData = mandelCalc.calcMandelbrotSet(width, height, mandelCalc.INITIAL_MIN_REAL, mandelCalc.INITIAL_MAX_REAL, 
				mandelCalc.INITIAL_MIN_IMAGINARY, mandelCalc.INITIAL_MAX_IMAGINARY, 
				mandelCalc.INITIAL_MAX_ITERATIONS, mandelCalc.DEFAULT_RADIUS_SQUARED);
		
        BufferedImage img = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				//System.out.print(madelbrotData[i][j]);
				if(madelbrotData[i][j] >= 50) {
					 point = 0;
				} else {
					point =  getColor(255,255,255);
				}
				 img.setRGB(j, i, point);
			}
			System.out.println("");
		}
		

		
		try {
            JFrame frame = new JFrame();
            frame.getContentPane().setLayout(new FlowLayout());
            frame.getContentPane().add(new JLabel(new ImageIcon(img)));
            frame.pack();
            frame.setVisible(true);
        }
        catch (Exception e) {
            System.out.println("Oops.");
        }
    }
	
	
	 public static int getColor(int r, int g, int b) {
	        return  65536 * r + 256 * g + b;
	    }


}
