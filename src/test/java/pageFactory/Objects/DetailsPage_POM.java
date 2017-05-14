package pageFactory.Objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailsPage_POM {

	public DetailsPage_POM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	// Register /Tell me more Title

	@FindBy(xpath = "//h3[contains(text(),'Tell Me More')]")
	public List<WebElement> tellmemore_title_detailspage;

	// Form field error message Validation properties ,,,,,,,,,,,,,,

	@FindBy(xpath = "//label[contains(@for,'name')]")
	public WebElement name_error;

	@FindBy(xpath = "//label[contains(@for,'email')]")
	public WebElement email_error;

	@FindBy(xpath = "//label[contains(@for,'phone')]")
	public WebElement phone_error;

	@FindBy(xpath = "//label[contains(@for,'remark')]")
	public WebElement remark_error;

	@FindBy(xpath = "//label[contains(@for,'agreeTerm')]")
	public WebElement terms_conditions_error;

	@FindBy(xpath = "//div[@class='ng-binding']")
	public WebElement continue_alert_error;

	
	
	/***************   Form field properties -- BOTTOM SUBMISSION [lead]  **************/
	
	@FindBy(xpath = "(//input[@name='name'])[1]")
	public WebElement name_field_bottom;

	@FindBy(xpath = "(//input[@name='email'])[1]")
	public WebElement email_field_bottom;

	@FindBy(xpath = "(//input[@name='phone'])[1]")
	public WebElement phone_field_bottom;

	@FindBy(xpath = "(//select[@name='country'])[1]")
	public WebElement country_dropdown_bottom;

	@FindBy(xpath = "(//textarea[@name='remark'])[1]")
	public WebElement remark_field;

	@FindBy(xpath = "(//input[@data-ng-model='form.receiveUpdate'])[1]")
	public WebElement recieve_updates_check_bottom;

	@FindBy(xpath = "(//*[@name='agreeTerm'])[1]")
	public WebElement terms_conditions_check_bottom;
	

	// submit Btn BOTTOM
	@FindBy(xpath = "(//button[@id='btnSend'])[1]")
	public WebElement submit_btn_bottom;

	// TY Message BOTTOM
	@FindBy(xpath = "//div[contains(@class,'alert')]")
	public WebElement thankyou_message_bottom;

	@FindBy(className = "thxText")
	public WebElement thankyou_page_text;

	
	
	/**********         Form field properties -- TOP SUBMISSION [lead] ***********/
	
	
	@FindBy(xpath = "(//input[@name='name'])[5]")
	public WebElement name_field_top;

	@FindBy(xpath = "(//input[@name='email'])[3]")
	public WebElement email_field_top;

	@FindBy(xpath = "(//input[@name='phone'])[3]")
	public WebElement phone_field_top;

	@FindBy(xpath = "(//select[@name='country'])[3]")
	public WebElement country_dropdown_top;

	@FindBy(xpath = "(//input[@data-ng-model='form.receiveUpdate'])[3]")
	public WebElement recieve_updates_check_top; 

	@FindBy(xpath = "(//input[@name ='agreeTerm'])[4]")
	public WebElement terms_conditions_check_top;

	// Register Btn TOP
	@FindBy(id = "btnContactDeveloper")
	public WebElement submit_btn_top;

	// TY Message TOP
	@FindBy(xpath = "//div[contains(@class,  'alert-success')]")
	public WebElement thankyou_top_message;

	
   
	
	/*************  CUSTOM ENQUIRY PROPERTIES  - DOWNLOAD Section ****************/
	
	@FindBy(xpath = "(//input[@name='NRIC'])[1]")
	public WebElement NRIC_download;
	
	@FindBy(xpath ="//select[@ng-model='modalCustomEnquirySelect']")
	public WebElement aboutme_download;
	
	@FindBy(xpath ="(//input[@name='checkboxCustom'])[1]")
	public WebElement iwouldliketo_checkbox1_download;
	
	@FindBy(xpath ="(//input[@name='checkboxCustom'])[2]")
	public WebElement iwouldliketo_checkbox2_download;
	
	
	

}
