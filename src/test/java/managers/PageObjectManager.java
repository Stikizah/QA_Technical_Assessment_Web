package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.ResourcePage;
import pageObjects.WhitePaperPage;

public class PageObjectManager {

	private WebDriver driver;
	private HomePage homePage;
	private ResourcePage resourcePage;
	private WhitePaperPage whitePaperPage;
	public PageObjectManager(WebDriver driver) 
	{
		this.driver = driver;
	}

	public HomePage getHomePage()
	{
		return (homePage == null) ? 
				homePage = new HomePage(driver) : 
					homePage;
	}
	
	public ResourcePage getResourcePage()
	{
		return (resourcePage == null) ? 
				resourcePage = new ResourcePage(driver) : 
					resourcePage;
	}
	
	public WhitePaperPage getWhitePaperPage()
	{
		return (whitePaperPage == null) ? 
				whitePaperPage = new WhitePaperPage(driver) : 
					whitePaperPage;
	}
}
