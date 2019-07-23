package url;

import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
import java.awt.Robot; // robot class
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class TestURL extends Child_Locaters {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver","D:\\New folder\\chromedriver.exe");

		WebDriver  webDriver= new ChromeDriver();
		//System.out.println("");
		
		webDriver.manage().window().maximize();
		
		FileInputStream file = new FileInputStream(new File("D:\\Selenium Programs\\DataDriverFrameWork\\URL\\ReadURL.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		for(int i=0; i<=sheet.getLastRowNum(); i++)
		{
		String url = sheet.getRow(i).getCell(0).getStringCellValue();
		
		webDriver.get(url);
		System.out.println("page title is :"+ webDriver.getTitle());
		
		webDriver.findElement(By.xpath(search)).sendKeys("laptop");
		webDriver.findElement(By.xpath(clickonSaerchButton)).click();

		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriver.findElement(By.xpath(SelectProducts)).click();
	Thread.sleep(2000);
		webDriver.navigate().refresh();
		WebElement element1 = (new WebDriverWait(webDriver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(AddToCart)));
		  element1.click();	
	
		  
		  
		  String Parent_Window = webDriver.getWindowHandle();
			for (String Child_Window : webDriver.getWindowHandles())
			{		
				webDriver.switchTo().window(Child_Window); 
			
				webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
			
			WebElement element = webDriver.findElement(By.xpath(PopUp));
			JavascriptExecutor executor = (JavascriptExecutor)webDriver;
			executor.executeScript("arguments[0].click();",element);
			
			
			}
			webDriver.switchTo().window(Parent_Window);
		
		  webDriver.findElement(By.xpath(ProceedToCheckOut)).click();
		  
		  webDriver.findElement(By.xpath(UserName)).sendKeys("shailendra.singh@ubuy.co.in");
		webDriver.findElement(By.xpath(Password)).sendKeys("testing123");
		webDriver.findElement(By.xpath(LoginButton)).click();
		
		Thread.sleep(4000);
		webDriver.findElement(By.xpath(NewAdress)).click();
		webDriver.findElement(By.xpath(FirstNAme)).sendKeys("shailendra");
		webDriver.findElement(By.xpath(LAstName)).sendKeys("sing");
		webDriver.findElement(By.xpath(TelephoneNumber)).sendKeys("12345678");
		Select Region = new Select(webDriver.findElement(By.xpath(State)));
		Region.selectByIndex(3);
		webDriver.findElement(By.xpath(City)).sendKeys("Jaipur");
		webDriver.findElement(By.xpath(House)).sendKeys("ElecTronicMarket");
		webDriver.findElement(By.xpath(Street)).sendKeys("Ridhi Sidhi");
		webDriver.findElement(By.xpath(Zip)).sendKeys("12365465898");
		webDriver.findElement(By.xpath(ContinueButton)).click();
		
		Thread.sleep(4000);
		webDriver.findElement(By.xpath(ShippingSelect)).click();
		webDriver.findElement(By.xpath(ContinueFromShipping)).click();
		
		
		Thread.sleep(4000);
		
		
		
		webDriver.findElement(By.xpath(VisaMAsterCard)).click();
		
		Select Card =new Select(webDriver.findElement(By.xpath(CardType)));
		Card.selectByIndex(2);
		webDriver.findElement(By.xpath(CardNumber)).sendKeys("5105105105105100");
		Select ExpiryDate = new Select(webDriver.findElement(By.xpath(ExpiryMonth)));
		ExpiryDate.selectByVisibleText("03 - March");
		Select ExpiryDateYear = new Select(webDriver.findElement(By.xpath(ExpiryYear)));
		ExpiryDateYear.selectByVisibleText("2023");
		webDriver.findElement(By.xpath(CardVerificationNumber)).sendKeys("123");
		
	
		
		
		

		webDriver.findElement(By.xpath(ContinueFromPaymentOption)).click();
		
		webDriver.findElement(By.xpath(PlaceOrderFinal)).click();
		
		Thread.sleep(2000);
		/*WebDriverWait wait = new WebDriverWait(webDriver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Cancel')]"))).click();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);*/
	
		
	}

	}	
}
	