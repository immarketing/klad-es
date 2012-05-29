package es.klad.tmp;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

public class ScreenCapture {

	private static final int SLEEPPERIOD = 30 * 1000;

	private static String getFormattedFileName(String ext) {
		String result = "";

		Date dt = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");

		result = sdf.format(dt);

		result = result + "." + ext;
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String args[]) throws AWTException, IOException {
		Properties props = System.getProperties();
		
		//props.l
		while (true) {
			// capture the whole screen
			BufferedImage screencapture = new Robot()
					.createScreenCapture(new Rectangle(Toolkit
							.getDefaultToolkit().getScreenSize()));

			// Save as JPEG
			File file = new File("m:\\1\\" + getFormattedFileName("jpg"));
			ImageIO.write(screencapture, "jpg", file);
			
			try {
				Thread.sleep(SLEEPPERIOD);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// File filePNG = new File("m:\\screencapture.png");
		// ImageIO.write(screencapture, "PNG", filePNG);
		// Save as PNG
		// File file = new File("screencapture.png");
		// ImageIO.write(screencapture, "png", file);
	}
}
