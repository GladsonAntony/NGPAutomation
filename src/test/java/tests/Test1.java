/**
 * @Author Gladson Antony
 * @Date 04-Oct-2018 
 * @Time 8:34:32 PM
 */
package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import pageObjects.initializePageObjects.PageFactoryInitializer;


public class Test1 extends PageFactoryInitializer
{	
	
	@Description("To verify the working of OutlookPage")
	@Feature("Outlook Log-in Page")
	@Test
	public void testOutlook() throws Exception
	{
		outlookSignInPage()
		.enterUserEmailID("TestUzumaki@outlook.com")
		.clickOnNextButton()
		.enterPassword("TestNaruto123")
		.clickOnSignIn()
		.outlookAccountPage()
		.verifyLogin("Naruto Uzumaki")
		.logOut();
	}
}
