package pageFactory.Objects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.DD_Util;

public class HomePage_POM {

	public HomePage_POM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Home page Search Filter properties.......

	@FindBy(xpath = "//*[contains(text(), 'NEW LAUNCHES')]")
	public WebElement newlaunch_link;

	@FindBy(id = "ddlProType")
	public WebElement property_Type;

	@FindBy(id = "ddlRegionLv1")
	public WebElement all_state;

	@FindBy(id = "ddlRegionLv2")
	public WebElement area_select;

	@FindBy(id = "chk1")
	public WebElement check_area1;

	@FindBy(id = "chk2")
	public WebElement check_area2;

	@FindBy(id = "chk3")
	public WebElement check_area3;

	@FindBy(id = "chk26")
	public WebElement check_random1;

	@FindBy(id = "txtKeyword")
	public WebElement search_Box;

	@FindBy(id = "btnSearchBoxSearch")
	public WebElement search_Btn;

	@FindBy(id = "btnSearchMapSearch")
	public WebElement map_Btn;

	@FindBy(className = "autocomplete-suggestion")
	public List<WebElement> auto_completion;

	// more option properties........

	@FindBy(id = "moreOption")
	public WebElement moreoption_arrow;

	@FindBy(id = "txtPriceMin")
	public WebElement price_min;

	@FindBy(id = "txtPriceMax")
	public WebElement price_max;

	@FindBy(xpath = "//*[@id='content']/div[3]/div[2]/div/span/a")
	public WebElement price_validation;

	@FindBy(id = "txtSizeMin")
	public WebElement size_min;

	@FindBy(id = "txtSizeMax")
	public WebElement size_max;

	@FindBy(xpath = "//*[@id='content']/div[3]/div[3]/div[2]/div[3]/span[1]/text()[1]")
	public WebElement size_validation;

	@FindBy(id = "txtLandMin")
	public WebElement land_min;

	@FindBy(id = "txtLandMax")
	public WebElement land_max;

	@FindBy(id = "txtBedMin")
	public WebElement bed_min;

	@FindBy(id = "txtBedMax")
	public WebElement bed_max;

	@FindBy(xpath = "//*[@id='content']/div[3]/div[3]/div[2]/div[1]/span[2]")
	public WebElement bed_validation;

	@FindBy(id = "txtBathMin")
	public WebElement bath_min;

	@FindBy(id = "txtBathMax")
	public WebElement bath_max;

	@FindBy(id = "ddlTenure")
	public WebElement tenure_all;

	@FindBy(id = "ddlCompletionDt")
	public WebElement completion_date;

	@FindBy(id = "ddlListedWt")
	public WebElement listed_within;

	@FindBy(id = "chkVideo")
	public WebElement video_check;

	@FindBy(id = "chkPhoto")
	public WebElement photo_check;

	@FindBy(xpath = "//*[@id='searchBoxMore']/div[2]/div[2]/a")
	public WebElement reset_btn;

	/********* Methods **********/

	public void clickNewlaunch() {

		newlaunch_link.click();
	}

	public void selectPropType(String strng) throws IOException, InterruptedException {

		DD_Util.selectByVisibleText(property_Type, strng);
	}

	public void selectState(String arg1) throws IOException, InterruptedException {

		DD_Util.selectByVisibleText(all_state, arg1);
	}

	public void clickArea() throws IOException, InterruptedException {

		area_select.click();
	}

	public void selectArea() throws IOException, InterruptedException {

		check_area1.click();
		check_area2.click();
		check_area3.click();
	}

	public void clickSearchbtn() throws IOException, InterruptedException {

		search_Btn.click();
	}

	public void enterKeyword(String arg1) throws IOException, InterruptedException {

		search_Box.clear();
		search_Box.sendKeys(arg1);
	}

	public void searchKeyword(String arg1) {

		search_Box.clear();
		search_Box.sendKeys(arg1);
	}
}
