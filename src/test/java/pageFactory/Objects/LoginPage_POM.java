package pageFactory.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage_POM {

	// MY REGION - Properties
	@FindBy(xpath = "//a[@id='th-login']")
	public WebElement login_btn_homepage;

	@FindBy(xpath = "//input[@id='lgname']")
	public WebElement username_field;

	@FindBy(xpath = "//input[@id='lgpassword']")
	public WebElement password_field;

	@FindBy(xpath = "//a[@id='lgsubmit']")
	public WebElement submit_btn;

	@FindBy(className = "account")
	public WebElement account_name;

	@FindBy(id = "shortlistID")
	public WebElement shortlist_icon_preceding_acctname;

	@FindBy(xpath = "title-container")
	public WebElement title_shortlist;

	@FindBy(xpath = "//div[@class='signstate-account-dropdown']")
	public WebElement arrow_down;

	@FindBy(xpath = "(//a[contains(text(), 'My Property Ads')])[1]/following::li[1]/a")
	public WebElement logout;

	// SG REGION - Properties
	@FindBy(xpath = "//li[contains(@class,'uti-text2')]/following::a[2]")
	public WebElement loginbtn_homepage_SG;

	@FindBy(xpath = "//h1[contains(.,'Member Login')]")
	public WebElement memeberlogin_text_SG;

	@FindBy(xpath = "//input[@id='txtEmail']")
	public WebElement username_field_SG;

	@FindBy(xpath = "//input[@id='txtPassword']")
	public WebElement password_field_SG;

	@FindBy(xpath = "//a[@id='imgbtnLogin']")
	public WebElement submit_btn_SG;

	@FindBy(xpath = "//div[@class='text']")
	public WebElement acctount_name_SG;

	@FindBy(xpath = "//span[contains(.,'My iProperty Dashboard')]")
	public WebElement iproperty_dashboard_text;

	// constructor
	public LoginPage_POM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickLogin() {
		login_btn_homepage.click();
	}

	public void enterusername(String arg1) {
		username_field.clear();
		username_field.sendKeys(arg1);

	}

	public void enterpassword(String arg1) {
		password_field.clear();
		password_field.sendKeys(arg1);
	}

	public void clickSubmit() {
		submit_btn.click();
	}

	public void checkAccountname(String expected) {

		String actual = account_name.getText();
		Assert.assertEquals(actual, expected);

	}

	public void clickArrowdown() {

		arrow_down.click();
	}

	public void clickLogout() {

		logout.click();
	}

}
