package modules;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import config.Constants;
import pageFactory.Objects.DetailsPage_POM;
import pageFactory.Objects.HomePage_POM;
import pageFactory.Objects.ListingPage_POM;
import wait_util.Wait_Utils;

public class NavigateTo_DetailsPage {

	public static void Execute(WebDriver driver) throws Exception {

		// POM File Constructors
		HomePage_POM landingpage = new HomePage_POM(driver);
		ListingPage_POM listingpage = new ListingPage_POM(driver);
		DetailsPage_POM detailspage = new DetailsPage_POM(driver);

		// search iproperty Test listing
		landingpage.search_Box.sendKeys("Iproperty");
		landingpage.search_Btn.click();
		Wait_Utils.elementtobeVisible(driver, listingpage.development_name);

		Assert.assertTrue(listingpage.development_name.isDisplayed());
		List<WebElement> total_listings = listingpage.total_listingnames;

		for (WebElement element : total_listings) {
			String listingname = element.getText();
			System.out.println("listing name found : " + listingname);
			if (listingname.contains("iProperty Test Listing") || listingname.contains("Test Listing")
					|| listingname.contains("iProperty")) {
				// click view details
				wait_util.Wait_Utils.elementtobeClickable(driver, listingpage.view_details_btn);
				listingpage.view_details_btn.click();
				Wait_Utils.implicitwait_byTime(driver, 5);
				break;

			} else {
				Reporter.log(("Iproperty listing Not Found: Looping All Listings "));
			}

		}

	}

}
