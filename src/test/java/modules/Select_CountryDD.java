package modules;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility.DD_Util;

public class Select_CountryDD {

	public static void Execute(WebDriver driver, WebElement element, String value)
			throws IOException, InterruptedException, Exception {

		String URL = driver.getCurrentUrl();
		if (URL.contains(".my")) {
			Select select = new Select(element);
			String country = select.getFirstSelectedOption().getText();

			Assert.assertEquals(country, "Malaysia", "Country DD  Value Mis-matched:plz check UI>>>");

			// Select Country
			DD_Util.selectByVisibleText(element, value);
		} else {

			Select select = new Select(element);
			String country = select.getFirstSelectedOption().getText();
			
			Assert.assertEquals(country, "Singapore", "Country DD  Value Mis-matched: plz check UI");

			// Select Country
			DD_Util.selectByVisibleText(element, value);

		}
	}

}
