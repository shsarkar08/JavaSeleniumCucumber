package reusableFunctions;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import cucumber.api.Scenario;
/*import report.CaptureScreen;
import report.LogAs;
import report.Reports;
import report.CaptureScreen.ScreenshotOf;*/
//import reusableFunctions.ReadFiles;
//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

import cucumber.api.Scenario;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class CommonUtils {

	static WebDriver driver= null;
	static String parentwinHandle="";
	static Alert alert;
	public static WebDriver fnLaunchBrowser(String url_prop,String sBrowser)
	{
		//Instantiating Browser
		//WebDriver driver= null;
		//CookieBroadcastPage objCookieBroadcastPage;

		try 
		{
			switch (sBrowser)
			{
			case "Chrome":
				//File fileChrome=new File("src\\test\\resources\\Drivers\\chromedriver.exe");
				File fBrwsr = new File("src\\test\\resources\\Drivers\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", fBrwsr.getAbsolutePath());
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("disable-infobars");
				options.setExperimentalOption("useAutomationExtension", false);
				
				driver=new ChromeDriver(options);
				//driver.get("http://10.31.101.16/qa");
				String url= ReadFiles.readPropFile(url_prop);
				driver.get(url);
				driver.manage().window().maximize();
				System.out.println("The Chrome browser Launched with URL");
				break;
			case "IE":
				File fBrwsr2 = new File("src\\test\\resources\\Drivers\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", fBrwsr2.getAbsolutePath());
				driver=new InternetExplorerDriver();
				//driver.get("http://10.31.101.16/qa");
				String url1= ReadFiles.readPropFile("url_workday");
				driver.get(url1);
				driver.manage().window().maximize();
				System.out.println("The IE browser is opened");
				break;
			case "Mozilla":
				FirefoxProfile  firefoxProfile = new FirefoxProfile();	
				firefoxProfile.setPreference("network.proxy.type", 0);
				firefoxProfile.setPreference("network.proxy.http", "10.31.8.34");
				firefoxProfile.setPreference("network.proxy.http_port", 8080);
				firefoxProfile.setPreference("network.proxy.ssl", "10.31.8.34");
				firefoxProfile.setPreference("network.proxy.ssl_port", 8080);
				driver=new FirefoxDriver(firefoxProfile);
				String url2= ReadFiles.readPropFile("url_workday");
				driver.get(url2);
				driver.manage().window().maximize();
				System.out.println("The Mozilla browser is opened");
				break;
			default:
				System.out.println("The Expected broswer values are Chrome, IE or Mozilla");
			}
			Thread.sleep(5000);
			//		objCookieBroadcastPage= new CookieBroadcastPage(driver);
			//objCookieBroadcastPage.btn_Cross_BroadcastMessage.click();
			// objCookieBroadcastPage.btn_Cross_Cookie.click();


		} 
		catch (Exception e)
		{
			System.out.println("Exception thrown for the driver");
		}
		return driver;	

	}




	public static void clickButton(WebElement element)
	{
		try
		{
			Thread.sleep(2000);
			element.click();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}

	}

	public static void switchToPopup()
	{
		parentwinHandle= driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
            driver = driver.switchTo().window(windowHandle);
        }
	}

	public static void switchToParent()
	{
		driver.switchTo().window(parentwinHandle);
	}
	
	public static String getAlertText()
	{
		alert = driver.switchTo().alert();
		String alertmessage = alert.getText();
		System.out.println("Alert Text==> "+alertmessage);
		return alertmessage;
		
	}
	
	public static void refresh() {
		
		driver.navigate().refresh();
	}
	
	public static void acceptAlert()
	{
		alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public static void setTextboxValue(WebElement element, String inputValue)
	{
		try
		{
			element.sendKeys(inputValue);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}


	public static boolean isElementDisplayed(WebElement element)
	{

		try
		{
			return element.isDisplayed();

		}
		catch(Exception e)
		{
			System.out.println(element + " ~ Element Not Available to display");
			return false;

		}

	}

	public static boolean isElementEnabled(WebElement element)
	{

		try
		{
			return element.isEnabled();

		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			return false;

		}

	}

	public static void highlightElement(WebElement element, String colour, WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		for (int i = 0; i <2; i++) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: "+colour+"; border: 2px solid "+colour+";");
			Thread.sleep(1000);
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}			
	}

	public static void clickButtonUsingJavaScript(WebElement element, WebDriver driver)
	{
		try
		{

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}

	}

	public static void killBrowser()
	{
		try
		{
			driver.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}

	public static void waitForElement(int iSeconds, WebElement we)
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, iSeconds);
			wait.until(ExpectedConditions.visibilityOf(we));
		} 
		catch (Exception e) 
		{
			System.out.println("TIMEOUT:The element did not appear in "+iSeconds+" seconds");
		}

	}
	
//	public static void waitForElementFluent(int iseconds , WebElement el) {
//		
//		try {
//			
//			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//			wait.withTimeout(iseconds, TimeUnit.SECONDS);
//			wait.pollingEvery(5, TimeUnit.SECONDS);
//			wait.ignoring(NoSuchElementException.class);
//			
//			el = wait.until(new Function<Webdriver, WebElement>() {
//				
//				public WebElement apply(WebDriver driver) {
//					
//					return el;
//				}
//
//			});
//			el.click();
//		}
//		catch(Exception e) {
//			
//		}
//	}
	
	public static boolean verifyPageTitle(String expectedVal)
	{
		String actualPageTitle=driver.getTitle();
		if(actualPageTitle.equalsIgnoreCase(expectedVal))
		{
		Assert.assertEquals(actualPageTitle, expectedVal);
		return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean verifyPageHeader(WebElement element, String expectedVal)
	{
		
		if(element.isDisplayed())
		{
		Assert.assertEquals(element.getText(), expectedVal);
		return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean verifyText(WebElement element, String expectedVal)
	{
		try{
			//		element = driver.findElement(By.xpath(xpath));
			String actualVal = element.getText();

			String actualString = actualVal.trim();
			String expectedString = expectedVal.trim();

			System.out.println("The actual value is "+ actualString);
			System.out.println("The expected value is " + expectedString);
			if(actualString.equalsIgnoreCase(expectedString)){
				/*Reports.add("Verify user name", "Script should verify user name "+expectedString, 
						"Actual value "+actualString+" matches with expected value "+expectedString, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));*/
				System.out.println("Value Matched");
				return true;
				
			}
			else {
				/*Reports.add("Verify user name", "Script should verify user name "+expectedVal, 
						"Actual value "+actualVal+" does not match with expected value "+expectedVal, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));*/
				System.out.println("Value did not Matched");
				return false;
			}
		}

		catch (Exception e){
			System.out.println(e.toString());
			return false;
		}
	}
	
	public static boolean verifyTextAttr(WebElement element, String expectedVal)
	{
		try{
			
			String actualVal = element.getAttribute("value");

			String actualString = actualVal.trim();
			String expectedString = expectedVal.trim();

			System.out.println("The actual value is "+ actualString);
			System.out.println("The expected value is " + expectedString);
			
			if(actualString.equalsIgnoreCase(expectedString)){
				
				System.out.println("Value Matched");
				return true;
				
			}
			else {
				System.out.println("Value didn't Match");
				return false;
			}
		}

		catch (Exception e){
			System.out.println(e.toString());
			return false;
		}
	}
	
	
	public static String getText(WebElement element)
	{
		String getValue = element.getText();
		//System.out.println("Value ~ " + getValue);
		return getValue.trim();
	}

	public static String getAttr(WebElement element)
	{
		try {
		String getAttrValue = element.getAttribute("value");
		System.out.println("Value ~ " + getAttrValue);
		return getAttrValue.trim();
		}
		
		catch (Exception e) {
			
			System.out.println(e.toString());
			return e.toString();
		}
	}
	
	public static void scrollToElement(WebElement element, WebDriver driver)
	{
		try
		{
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);",element);
		
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	public static void scrollToElement_and_click(WebElement element, WebDriver driver)
	{
		try
		{
			JavascriptExecutor je = (JavascriptExecutor) driver;
//			element = driver.findElement(By.xpath(xpath));
			je.executeScript("arguments[0].scrollIntoView(true);",element);
			element.click();
			Thread.sleep(10000);
//			Reports.add("Scroll to element and click on it", "Script should scroll to the user provided element and click on it", 
//					"Script scroll to element "+xpath+" and click", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
//			Reports.add("Scroll to element and click on it", "Script should scroll to the user provided element and click on it", 
//					e.getMessage(), LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

	public static void Horizontal_scroll(WebElement element, WebDriver driver)
	{
		try
		{
			JavascriptExecutor je = (JavascriptExecutor) driver;

			je.executeScript("window.scrollBy(2000,0)");
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());

		}
	}
	/*
	 * For normal cucumber html report
	 */
//	public static void takeSnapshot(Scenario scenario)
//	{
//		scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES),"image/png");
//	}
//	
	/*
	 * for extent report
	 */
			
	public static String takeScreenshot() throws IOException
	{
		String screenShotName="";
		String screenShotPath="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    	Date date = new Date();
    	screenShotName= "Screenshot_"+dateFormat.format(date);
		//Convert web driver object to TakeScreenshot
    	TakesScreenshot scrShot =((TakesScreenshot)driver);
    	//Call getScreenshotAs method to create image file
    	File SrcFile= scrShot.getScreenshotAs(OutputType.FILE);
    	//Copy file at destination
    	screenShotPath=System.getProperty("user.dir")+"\\Screenshots\\"+screenShotName+".png";
    	FileUtils.copyFile(SrcFile, new File(screenShotPath));
    	System.out.println(screenShotPath);
		return screenShotPath;
	}
	
	public static void takeFullPageSnapshot(Scenario scenario)
	{
		//scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES),"image/png");			//this takes screenshot for the visible section of page
		scenario.embed(shoot(), "image/png");
	}
	
	public static byte[] shoot()
	{
		byte[] screen;
		try 
		{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		BufferedImage image = screenshot.getImage();
		//ImageIO.write(image, "PNG", new File("write here path of location to save image"+ "AShot_BBC_Entire.png"));			//to be used to save screenshot in definite path
		ImageIO.write(image, "png", stream);
		screen=stream.toByteArray();
		} 
		catch(IOException e) 
		 {
	       throw new RuntimeException(e);
		 }
		return screen;
	}
}
