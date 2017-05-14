package BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import config.Constants;
import config.ReadProperty;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;

public class BrowserFactory {

	static WebDriver driver;

	public static WebDriver openBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			ChromeDriverManager.getInstance().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-pop-up-blocking");
			options.addArguments("--disable-infobars");
			options.addArguments("--enable-automation");
			
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(caps);

		} else if (browser.equalsIgnoreCase("firefox")) {

			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("ie")) {

			InternetExplorerDriverManager.getInstance().setup();
			driver = new InternetExplorerDriver();

		} else if (browser.equalsIgnoreCase("phantomjs")) {

			DesiredCapabilities dcap = new DesiredCapabilities();
			String[] phantomArgs = new String[] { "--webdriver-loglevel=NONE" };

			dcap.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
			PhantomJsDriverManager.getInstance().setup();
			driver = new PhantomJSDriver(dcap);

		} else if (browser.equalsIgnoreCase("opera")){
			
			OperaDriverManager.getInstance().setup();
			driver = new OperaDriver();
		}
		return driver;

	}

}

// usage in class
// WebDriver driver = BrowserFactory.openBrowser("chrome");