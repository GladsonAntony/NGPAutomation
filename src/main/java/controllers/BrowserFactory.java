/**
 * @Author Gladson Antony
 * @Date 04 OCT 2018
 */

package controllers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BrowserFactory extends InitMethod
{
	static WebDriver driver;		
	static DesiredCapabilities capabilities;


	@SuppressWarnings("deprecation")
	static WebDriver createDriver() throws Exception
	{

		switch(Browser.toLowerCase())
		{
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "chrome_headless":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");  
			chromeOptions.addArguments("--disable-gpu");  
			driver = new ChromeDriver(chromeOptions);
			break;

		case  "firefox":
			driver = new FirefoxDriver();
			break;

		case  "ie":
		case "internet explorer":
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer(); 
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			driver=new InternetExplorerDriver(ieCapabilities);
			break;	

		case  "edge":
			driver = new EdgeDriver();
			break;
		
		default:
			throw new NotFoundException("Browser Not Found. Please Provide a Valid Browser");
		}
		
		if(ImplicitlyWait > 0)
		{
			implicitlywait(ImplicitlyWait);
		}		

		if(MaxPageLoadTime > 0)
		{
			setMaxPageLoadTime(MaxPageLoadTime);
		}
		driver.get(WebsiteURL);
		return driver;		
	}
	
	public static void implicitlywait(int timeInSeconds) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
	}

	public static void setMaxPageLoadTime(int timeInSeconds) throws Exception
	{
		driver.manage().timeouts().pageLoadTimeout(timeInSeconds, TimeUnit.SECONDS);
	}
}
