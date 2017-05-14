package modules;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageFactory.Objects.DetailsPage_POM;
import utility.Assertion;
import wait_util.Wait_Utils;


public class Lead_Thankyou_Message {

	public static void Execute(WebDriver driver) throws IOException {
		
		DetailsPage_POM detailspage = new DetailsPage_POM(driver);
		
		String url = driver.getCurrentUrl();
		if (url.contains(".my")) {
			String[] TempArray = detailspage.thankyou_page_text.getText().split("for");
			TempArray[0] = TempArray[0].trim();
			TempArray[1] = TempArray[1].trim();
			String Thankyou_text = TempArray[0];

			// Assertion - TY Message
			Assertion.AssertEquals(driver, Thankyou_text, "Thank you! Your enquiry have been successfully sent",
					"Thankyou Message: ");
		} else {
			// wait cmd
			Wait_Utils.elementtobeVisible(driver, detailspage.thankyou_top_message);

			String Actual;
			WebElement element1 = detailspage.thankyou_top_message;
			Actual = element1.getText();

			// Assertion - TY Message
			Assert.assertEquals(Actual, "Thank you, your enquiry has been successfully sent out",
					"Top LeadSubmission Thankyou Message Broken: ");
		}

	}

}
