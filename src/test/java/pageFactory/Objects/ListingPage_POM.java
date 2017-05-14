package pageFactory.Objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListingPage_POM {
	
	
	public  ListingPage_POM (WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	// Listing / SERP  properties.................

		@FindBy(xpath= "//div[contains(@class,'breadcrumb')][1]/h6")
		public WebElement breadcrumb;
		
		@FindBy(css = ".span8.custom8>h1")
		public WebElement header;
		
		@FindBy(xpath= "//a[@class='dev-id']")
		public WebElement development_assertionx;
		
		@FindBy(className= "text-content3")
		public List<WebElement> propertytype_assertion;
		
		@FindBy(xpath= "//*[@id='content']/div[3]/div[3]/div[2]/div[1]/div[2]/span[1]/text()[1]")
		public WebElement location_assertion;
		
		@FindBy(className= "dev-id")
		public WebElement development_name;
		
		@FindBy(className = "dev-id")
		public List<WebElement> total_listingnames;
		
		@FindBy(className = "text-resultpage")
		public WebElement location;
		
		@FindBy(className = "text-resultpage")
		public List<WebElement> location_all;
		
		@FindBy(className= "dev-id")
		public List<WebElement> development_name_all_listings;
		
		@FindBy(xpath= "//*[@id='content']/div[3]/div[6]/div[2]/div[1]/span[2]")
		public char bedcount_listingpage;
		
		@FindBy(id= "ddlSortBy")
		public WebElement sort_by;
		
		@FindBy(id= "ddlResultPerPage")
		public WebElement listing_perpage;
		
		@FindBy(xpath= "//a[@href='/listing/?pg=1&rmp=100']")
		public WebElement pagination1_listingpage;
		
		@FindBy(xpath= "//a[@href='/listing/?pg=2']")
		public WebElement pagination2_listingpage;
		
		@FindBy(xpath= "//a[contains(@class,'internal_link')]")
		public WebElement map_search;
		
		@FindBy(xpath= "//a[contains(@class,'internal_link')]")
		public WebElement listing_search;
		
		@FindBy(xpath= "(//div[starts-with(@id, 'divShortlist')])[1]")
		public WebElement shortlistIcon_listingpage;

		
	   //  veiw details btn properties....
		
		@FindBy(xpath= "//div[contains(@class,'details-btn-new')]")
		public WebElement view_details_btn;

}
