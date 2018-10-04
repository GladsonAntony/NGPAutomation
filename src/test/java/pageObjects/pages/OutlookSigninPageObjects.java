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
	
	@FindBy(css="input[type='password']")
	private WebElement field_Password;
	
	@FindBy(css="input[type='submit']")
	private WebElement button_SignIn;
	
	@FindBy(xpath="(//input[@type='checkbox'])[1]")	
	private WebElement checkbox_KeepMeSignedIn;
	
	@Step("To Enter User Email-ID {0}")
	public OutlookSigninPageObjects enterUserEmailID(String emailId) throws Exception
	{
		Assert.assertTrue(field_Email.isDisplayed());
/*		field_Email.clear();
		field_Email.sendKeys(emailId);*/
		actionSendkeys(field_Email, emailId);
		//JS_SendKeys(emailId, field_Email);
		return this;
	}
	
	@Step("To Click on Next/Signin Button")
	public OutlookSigninPageObjects clickOnNextButton()
	{
		Assert.assertTrue(button_Next.isDisplayed());
		button_Next.click();
		return this;
	}
	
	@Step("To Enter the Password {0} ")
	public OutlookSigninPageObjects enterPassword(String password) throws Exception
	{
		field_Password.clear();
		field_Password.sendKeys(password);
		return this;
	}
	
	@Step("To Click on SignIn Button")
	public OutlookSigninPageObjects clickOnSignIn() throws Exception
	{
		Thread.sleep(2000);
		closeAllTabsExceptFirst();
		hitTab();
		hitTab();
		hitTab();
		hitEnter();
		return this;
	}
}
