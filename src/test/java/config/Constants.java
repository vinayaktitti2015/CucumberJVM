package config;

import helpers.Read_Excel;

public class Constants {

	// Driver path
	public static final String driverpath = "./src/test/resources/webdrivers/";

	// Drivers
	public static final String chromedriver = driverpath + "chromedriver.exe";
	public static final String phantomjsdriver = driverpath + "phantomjs.exe";
	public static final String geckodriver = driverpath + "geckodriver.exe";
	public static final String iedriver = driverpath + "IEDriverServer.exe";

	// initiate Excel_Data_Config Library MY
	public static final Read_Excel TestData_my = new Read_Excel(
			"./src/test/resources/testData/Newlaunch_TestData.xlsx");

	// initiate Excel_Data_Config Library SG
	public static final Read_Excel TestData_sg = new Read_Excel(
			"./src/test/resources/testData/Singapore_TestData.xlsx");

	// Database Connection
	public static String sqlUrl = "xxxxx"; 
																								
	public static String sqlUsername = "test"; // beta database
	public static String sqlPassword = "test123"; // beta database
}
