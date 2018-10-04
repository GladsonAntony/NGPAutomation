/**
 * @Author Gladson Antony
 * @Date 04-Oct-2018 
 * @Time 8:22:32 PM
 */
package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.qameta.allure.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class OutlookSigninPageObjects extends PageFactoryInitializer
{
	
	@FindBy(xpath="//div[contains(text(),'Sign in')]/following::input[@type='email']")
	private WebElement field_Email;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement button_Next;
	
//	@FindBy(xpath="//input[@type='password']")
	@FindBy(css="#i0118")
	private WebElement field_Password;
	
	@FindBy(xpath="(//input[@type='checkbox'])[1]")	
	private WebElement checkbox_KeepMeSignedIn;
	
	@Step("To Enter User Email-ID {0}")
	public OutlookSigninPageObjects enterUserEmailID(String emailId)
	{
		Assert.assertTrue(field_Email.isDisplayed());
		field_Email.clear();
		field_Email.sendKeys(emailId);
		return this;
	}
	
	@Step("To Click on Next/Signin Button")
	public OutlookSigninPageObjects clickOnNextButton()
	{
		//Assert.assertTrue(button_Next.isDisplayed());
		JSclick(button_Next);
//		button_Next.click();
		return this;
	}
	
	@Step("To Enter the Password {0} ")
	public OutlookSigninPageObjects enterPassword(String password)
	{
		//Assert.assertTrue(field_Password.isDisplayed());
		field_Password.clear();
		field_Password.sendKeys(password);
		return this;
	}
	
	

}
