package main.env;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import BrowserFactory.BrowserFactory;
import config.ReadProperty;

import java.io.IOException;
import java.util.HashMap;

public class SharedDriver extends EventFiringWebDriver {

	// A new instance of SharedDriver is created for each scenario and passed to
	// stepDefs using Dependency Injection
	private static WebDriver driver;
	private static final Thread CLOSE_THREAD = new Thread() {
		@Override
		public void run() {
			driver.quit();
		}
	};

	/*public static final ThreadLocal session = new ThreadLocal();

	public static Object getScenarioProperty(String key) {
		return ((HashMap<String, Object>) session.get()).get(key);
	}

	public static Object setScenarioProperty(String key, Object value) {
		return ((HashMap<String, Object>) session.get()).put(key, value);
	}*/

	static {
		ReadProperty prop = new ReadProperty();
		String browserName = System.getenv("browser");

		if (browserName == null) {
			try {
				driver = BrowserFactory.openBrowser(prop.getKey("browser"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
	}

	public SharedDriver() {
		super(driver);
	}

	@Override
	public void close() {
		if (Thread.currentThread() != CLOSE_THREAD) {
			throw new UnsupportedOperationException("Driver will close when the JVM exits.");
		}
		super.close();
	}

	@Before
	public void deleteAllCookies() {
		HashMap<String, Object> context = new HashMap<String, Object>();
		//session.set(context);
		manage().deleteAllCookies();
	}

	@After
	public void teardown() {
		System.out.println("Execute Teardown");
		//session.remove();

	}

}
