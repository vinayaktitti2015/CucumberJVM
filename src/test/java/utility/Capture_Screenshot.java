package utility;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class Capture_Screenshot {

	public static String getName(WebDriver driver, String string) throws IOException {

		String dest = System.getProperty("user.dir") + "\\target\\Reports\\ErrorScreenshots\\" + string + ".png";
		try {
			// For taking screenshots Selenium has provided TakesScreenShot
			// interface in this interface you can use getScreenshotAs method

			// Take screenshot and store as a file format
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destination = new File(dest);

			FileUtils.copyFile(srcFile, destination);

		} catch (Exception e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
		return dest;

	}
	
	
	public static String getVideo(WebDriver driver, String screenshotName) throws IOException {

		String dest = System.getProperty("user.dir") + "\\Reports\\ErrorScreenshots\\" + screenshotName + ".mp4";
		try {
			// For taking screenshots Selenium has provided TakesScreenShot
			// interface in this interface you can use getScreenshotAs method

			// Take screenshot and store as a file format
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destination = new File(dest);

			FileUtils.copyFile(srcFile, destination);

		} catch (Exception e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
		return dest;

	}

	public static void getScreenshotWithTime(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,
					new File("./Execution_Screenshots/Custom_Screenshots/" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}

	}

	public static void getScreenshotWithPath(WebDriver driver, String path) throws IOException {

		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}

	}

	// Read: take screenshot using Robot class
	// with help of Rectangle class and other packages of AWT package.

	// import java.awt.Rectangle;
	// import java.awt.Robot;
	// import java.awt.Toolkit;
	// import java.awt.image.BufferedImage;

	public static void withRobotClass(WebDriver driver, String screenshotName)
			throws HeadlessException, AWTException, IOException {

		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

		ImageIO.write(image, "png", new File("./Execution_Screenshots/Screenshots/" + screenshotName + ".png"));
	}

}
