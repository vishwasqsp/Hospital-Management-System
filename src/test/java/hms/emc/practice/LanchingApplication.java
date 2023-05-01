package hms.emc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LanchingApplication {

	public static void main(String[] args) throws SQLException {
		Driver dbDriver = new Driver();
		DriverManager.registerDriver(dbDriver);

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46", "root", "root");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from employee");
		while(result.next())
		{
			String empName = result.getString("emp_name");
			int empId = result.getInt(1);
			System.out.println(empName+"-->"+empId);
		}
		connection.close();
		}

}
