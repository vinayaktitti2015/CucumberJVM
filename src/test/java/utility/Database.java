package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import config.Constants;


public class Database {

	public static Connection conn;
	public static Statement sql;

	public static Connection msSQL() throws Exception {
		try {
			// Import the JDBC class for MS SQL
			// for JDBC Driver
			// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Class.forName("net.sourceforge.jtds.jdbc.Driver");

			// Established connection
			conn = DriverManager.getConnection(Constants.sqlUrl, Constants.sqlUsername, Constants.sqlPassword);
			conn.setAutoCommit(true);
		} catch (Exception e) {
			Log.error(e.toString());
		}
		return conn;
	}

	public static ResultSet mssqlSelect(Connection connection, String sqlstr) throws Exception {
		Log.info("Running SQL query --- " + sqlstr);
		ResultSet result = null;
		try {
			// Establish the query
			sql = connection.createStatement();

			// Query Result
			result = sql.executeQuery(sqlstr);
		} catch (Exception e) {
			Log.error(e.toString());
		}
		return result;
	}
	
	public static int mssqlUpdateInsert(Connection connection, String sqlstr) throws Exception {
		Log.info("Running SQL query --- " + sqlstr);
		//ResultSet result = null;
		int result = 0;
		try {
			// Establish the query
			sql = connection.createStatement();

			// Query Result
			result = sql.executeUpdate(sqlstr);
		} catch (Exception e) {
			Log.error(e.toString());
		}
		return result;
	}

	public static void executeMSSQLStatement(Connection connection, String sqlstr) {
		Log.info("Running SQL query --- " + sqlstr);
		try {
			sql = connection.createStatement();
			sql.executeQuery(sqlstr);
		} catch (Exception e) {
			Log.error(e.toString());
		}
	}

}
