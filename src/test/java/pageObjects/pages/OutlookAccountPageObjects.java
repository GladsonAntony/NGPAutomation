/**
 * @Author Gladson Antony
 * @Date 04-Oct-2018 
 * @Time 9:38:27 PM
 */
package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class OutlookAccountPageObjects extends PageFactoryInitializer
{
	@FindBy(xpath="//h2[contains(text(),'Naruto Uzumaki')]")
	private WebElement field_UserName;
	
	@FindBy(xpath="//a[contains(text(),'Sign out')]")
	private WebElement button_Logout;
	
	@Step("To verify the page after login")
	public OutlookAccountPageObjects verifyLogin(String userName)
	{
		Assert.assertTrue(field_UserName.isDisplayed());
		return this;
	}
	
	@Step("To Logout from Account")
	public OutlookAccountPageObjects logOut()
	{
		JSclick(button_Logout);
		return this;
	}

}
