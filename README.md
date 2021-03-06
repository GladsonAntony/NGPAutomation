# WebApp Automation Framework with Webdriver Manager Support

[![N|Solid](http://www.seleniumhq.org/images/selenium-logo.png)](http://www.seleniumhq.org/) 

This is a Selenium Hybrid Framework.
 - Written in **JAVA**
 - Implemented using **TestNG**
 - Build Toold - Maven
 - Implemented Page Object Model Design Pattern
 - Excel TestNG @DataProvider
 - Video Recording - Monte Repack
 - WebDriver Manager - Auto Download of required drivers. 
 - AShot - Captures Entire Webpage Screenshot

### Browsers Supported
 - Mozilla Firefox
 - Google Chrome
 - Internet Explorer
 - Microsoft Edge

### Platform Support
 - Windows
 - Linux
 - Macintosh

---
### Reporting
 - [Allure Reporting](https://docs.qameta.io/allure/)
 
---
### Usage

#### Download Scoop

>Make sure Powershell 3 (or later) and .NET Framework 4.5 (or later) are installed. Then run
```sh
Set-ExecutionPolicy RemoteSigned -scope CurrentUser
```
> It asks for Yes or No. Select 'Y'
```sh
iex (new-object net.webclient).downloadstring('https://get.scoop.sh')
```
> Clone Project
```sh
$ git clone https://github.com/GladsonAntony/NGPAutomation.git
```
> Run Test using Maven
```sh
$ mvn clean test
```
---
### Browser Setup
 - Navigate to *WebAutomation\src\main\resources* change *BrowserType* in the ApplicationConfig.properties
 or use Maven to invoke different browsers

```sh
$ mvn clean test -DBrowserType=Chrome			#Chrome
$ mvn clean test -DBrowserType=Chrome_Headless		#Chrome Headless
$ mvn clean test -DBrowserType=Firefox			#Mozilla Firefox
$ mvn clean test -DBrowserType=IE			#Internet Explorer
$ mvn clean test -DBrowserType=Edge			#Microsoft Edge
```
---
### Report Generation
```sh
$ allure serve
```
> It will generate the report and open the report in the default Browser
---

### @DataProviders

**__Method 1:__** 
 - Use **TestData.xlsx** file as your dataproviders. The Sheet Name should be the name of your Method Name.
 - To use different xlsx file, Create a new `@DataProvider` method and change the workbook name.
```java
@DataProvider(name="multiSheetExcelRead", parallel=true)
public static Object[][] multiSheetExcelRead(Method method) throws Exception
{
	File file = new File("./src/test/resources/Excel Files/TestData.xlsx");
	String SheetName = method.getName();
	System.out.println(SheetName);
	Object testObjArray[][] = ExcelUtils.getTableArray(file.getAbsolutePath(), SheetName);
	return testObjArray;
}
```

**__Method 2:__**
 - Create Excel Workbook with the same name as your method Name.
```java
@DataProvider(name="excelSheetNameAsMethodName",parallel=true)
public static Object[][] excelSheetNameAsMethodName(Method method) throws Exception
{
	File file = new File("./src/test/resources/Excel Files/"+method.getName()+".xlsx");
	Object testObjArray[][] = ExcelUtils.getTableArray(file.getAbsolutePath());
	return testObjArray;
}
 ```
 ---
 
 ### @DataProvider Usuage
 
__To Use Method Name as Excel Workbook Name, Use the following:__
```java
@Test(dataProvider="excelSheetNameAsMethodName", dataProviderClass=ExcelDataProvider.class)
```

__To use a Single Workbook with multiple `@DataProvider`sheets, Use:__

~~NOTE~~:SheetName should be same name as Method Name
```java
@Test(dataProvider="multiSheetExcelRead", dataProviderClass=ExcelDataProvider.class)
```
