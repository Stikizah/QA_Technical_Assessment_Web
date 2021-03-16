package pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ResourcePage {

	WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	public ResourcePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//li[@id='kurtosys-menu-item-59810']/a/div/div/span") 
	private WebElement btn_Resource;

	@FindBy(xpath = "//*[@href='https://www.kurtosys.com/resources/white-papers-ebooks/']")
	private WebElement drp_WhatePaper;

	@FindBy(xpath = "//p[contains(text(),'White Papers & eBooks')]")
	private WebElement titleWhitePaper;

	@FindBy(xpath = "//a[contains(text(),'UCITS White Paper')]")
	private WebElement link_UCti;

	public void clickResources()
	{
		btn_Resource.click();
	}

	public void clickWhitePaper()
	{
		drp_WhatePaper.click();
	}

	public void clickUCIT()
	{
		link_UCti.click();
	}
	
	public void veriyfTitle()
	{
		try {
			assertEquals(driver.getTitle(), "Kurtosys White Papers For The Asset Management Industry | Kurtosys");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

}
