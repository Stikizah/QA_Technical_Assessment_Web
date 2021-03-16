package seleniumTests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UntitledTestCase {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	//scroll down
		JavascriptExecutor js;
		
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Kurtosys\\QA_Technical_Assessment\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		baseUrl = "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testUntitledTestCase() throws Exception {
		driver.get("https://www.kurtosys.com/");
		driver.findElement(By.xpath("//li[@id='kurtosys-menu-item-59810']/a/div/div/span")).click();
		js = (JavascriptExecutor) driver;
		// This  will scroll down the page by  1000 pixel vertical		
        js.executeScript("window.scrollBy(0,500)");
        
		driver.findElement(By.xpath("//main[@id='main']/div/div/div/div/section[2]/div/div/div/div/div/section[2]/div/div/div/div/div/div[2]/div/h4")).click();
		try {
			assertEquals(driver.findElement(By.linkText("White papers")).getText(), "White papers");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.linkText("White papers")).click();
//		js = (JavascriptExecutor) driver;
//		// This  will scroll down the page by  1000 pixel vertical		
//        js.executeScript("window.scrollBy(0,500)");
//		driver.findElement(By.xpath("//main[@id='main']/div/div/div/div/section[2]/div/div/div/div/div/section/div/div/div/div/div/div/div/div/p")).click();
//		driver.findElement(By.xpath("//main[@id='main']/div/div/div/div/section/div[2]/div/div/div/div/div/div/div/p")).click();
		try {
			assertEquals(driver.getTitle(), "Kurtosys White Papers For The Asset Management Industry | Kurtosys");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		js = (JavascriptExecutor) driver;
//		// This  will scroll down the page by  1000 pixel vertical		
        js.executeScript("window.scrollBy(0,500)");
        
		driver.findElement(By.linkText("UCITS White Paper")).click();
		
		driver.findElement(By.id("18882_231669pi_18882_231669")).click();
		driver.findElement(By.id("18882_231669pi_18882_231669")).clear();
		driver.findElement(By.id("18882_231669pi_18882_231669")).sendKeys("Sticks");
		driver.findElement(By.id("18882_231671pi_18882_231671")).clear();
		driver.findElement(By.id("18882_231671pi_18882_231671")).sendKeys("Weza");
		driver.findElement(By.id("18882_231673pi_18882_231673")).clear();
		driver.findElement(By.id("18882_231673pi_18882_231673")).sendKeys("N@gmail.com");
		driver.findElement(By.id("18882_231675pi_18882_231675")).clear();
		driver.findElement(By.id("18882_231675pi_18882_231675")).sendKeys("Testing company");
		driver.findElement(By.id("18882_231677pi_18882_231677")).click();
		driver.findElement(By.id("18882_231677pi_18882_231677")).clear();
		driver.findElement(By.id("18882_231677pi_18882_231677")).sendKeys("Testing industry");
		driver.findElement(By.xpath("//input[@value='Send me a copy']")).click();
		driver.findElement(By.xpath("//form[@id='pardot-form']/p/span")).click();
		try {
			assertEquals(driver.findElement(By.xpath("//form[@id='pardot-form']/p")).getText(), "Thank you. Your white paper is on its way to the provided email address.");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}

