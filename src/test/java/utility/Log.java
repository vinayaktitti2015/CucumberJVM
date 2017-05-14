package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import org.apache.log4j.Logger;

public class Log {

	// Initialize Log4j2 logs
	private static Logger Log = LogManager.getLogger(Log.class.getName());

	// This is to print log for the beginning of the test case, as we usually
	// run so many test cases as a test suite
	public static void startTestCase(String sTestCaseName) {
		Log.info("****************************************************************************************");
		Log.info("$$$$$$$$$$$$$$$$ \t \t \t   " + sTestCaseName + "   \t \t \t $$$$$$$$$$$$$$$$");
		Log.info("****************************************************************************************");
	}

	// This is to print log for the ending of the test case
	public static void endTestCase() {
		Log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXXXXXXX");
		Log.info("X");
		Log.info("X");
		Log.info("X");
		Log.info("X");
	}

	// Need to create these methods, so that they can be called
	public static void info(String message) {
		Log.info(message);
	}

	public static void warn(String message) {
		Log.warn(message);
	}

	public static void error(String message) {
		Log.error(message);
	}

	public static void fatal(String message) {
		Log.fatal(message);
	}

	public static void debug(String message) {
		Log.debug(message);
	}

}
