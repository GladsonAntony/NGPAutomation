/**
 * @Author Gladson Antony
 * @Date 04-Oct-2018 
 * @Time 8:32:32 PM
 */
package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;
import pageObjects.pages.OutlookAccountPageObjects;
import pageObjects.pages.OutlookSigninPageObjects;

public class PageFactoryInitializer extends BaseMethod
{
	
	public OutlookSigninPageObjects outlookSignInPage()
	{
		return PageFactory.initElements(getWebDriver(), OutlookSigninPageObjects.class);
	}
	
	public OutlookAccountPageObjects outlookAccountPage()
	{
		return PageFactory.initElements(getWebDriver(), OutlookAccountPageObjects.class);
	}
}
