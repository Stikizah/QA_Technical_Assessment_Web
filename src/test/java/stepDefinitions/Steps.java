package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;
import io.cucumber.java.en.*;
import managers.PageObjectManager;
import pageObjects.HomePage;
import pageObjects.ResourcePage;
import pageObjects.WhitePaperPage;

public class Steps {
	
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	//scroll down
	JavascriptExecutor js;
	
	HomePage homePage;
	ResourcePage resourcePage;
	WhitePaperPage whitePaperPage;
	PageObjectManager pageObjectManager;
	ConfigFileReader configFileReader;
	
	@Given("user is on Home Page")
	public void user_is_on_home_page() 
	{
		configFileReader = new ConfigFileReader();
		
		System.setProperty("webdriver.chrome.driver",
				configFileReader.getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicityWait(), TimeUnit.SECONDS);
		
		pageObjectManager = new PageObjectManager(driver);
		homePage = pageObjectManager.getHomePage();
		homePage.navigateToHomePage();
//		driver.get("https://www.kurtosys.com/");
		
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("document.body.style.zoom = '1.5'");
	}
	
	@Then("Navigate to RESOURCES")
	public void navigate_to_resources() 
	{
		resourcePage = pageObjectManager.getResourcePage();
		resourcePage.clickResources();
	}
	
	@Then("From the drop down, click on White Papers & eBooks")
	public void from_the_drop_down_click_on_white_papers_e_books() 
	{

		js = (JavascriptExecutor) driver;
		// This  will scroll down the page by  1000 pixel vertical		
        js.executeScript("window.scrollBy(0,500)");
        
        resourcePage.clickWhitePaper();
	}
	
	@Then("Verify Title reads White Papers")
	public void verify_title_reads_white_papers() 
	{
		resourcePage.veriyfTitle();
	}
	
	@Then("Click on any white paper tile \\(eg. Click on UCITS Whitepaper)")
	public void click_on_any_white_paper_tile_eg_click_on_ucits_whitepaper() 
	{
		// This  will scroll down the page by 500 pixel vertical		
        js.executeScript("window.scrollBy(0,500)");
        resourcePage.clickUCIT();
		
	}
	
	@Then("Enter person's details")
	public void enter_person_s_details() 
	{
		whitePaperPage = pageObjectManager.getWhitePaperPage();
		whitePaperPage.Enter_PersonDetails();
	}
	
	@Then("Click Send me a copy")
	public void click_send_me_a_copy() 
	{
		whitePaperPage.Click_SendCopy();	
	}
	
	@Then("Add screenshot of the error messages")
	public void add_screenshot_of_the_error_messages() 
	{
		
	}
	
	@Then("Validate all error messages")
	public void validate_all_error_messages() 
	{
		try {
			assertEquals(driver.findElement(By.xpath("//form[@id='pardot-form']/p")).getText(), "Thank you. Your white paper is on its way to the provided email address.");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

}
