package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhitePaperPage {
	WebDriver driver;
	public WhitePaperPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[text() = 'First Name']")
	private WebElement txt_Fname;
	
	@FindBy(xpath = "//*[text() = 'Last Name']")
	private WebElement txt_Lname;
	
	@FindBy(xpath = "//*[text() = 'Email*']")
	private WebElement txt_Email;
	
	@FindBy(xpath = "//*[@id='18882_231675pi_18882_231675']")
	private WebElement txt_Company;
	
	@FindBy(xpath = "//*[@id='18882_231677pi_18882_231677']")
	private WebElement txt_Indastry;
	
	//*[@value="Send me a copy"]
	@FindBy(xpath = "//*[@value='Send me a copy']")
	WebElement clickSendCopy;
	
	public void EnterFname(String fName)
	{
		txt_Fname.sendKeys(fName);
	}
	public void EnterLName(String lName)
	{
		txt_Lname.sendKeys(lName);
	}
	
	public void EnterEmail(String email)
	{
		txt_Email.sendKeys(email);
	}
	
	public void EnterCompany(String company)
	{
		txt_Company.sendKeys(company);
	}
	
	public void EnterIndastry(String indastry)
	{
		txt_Indastry.sendKeys(indastry);
	}
	
	public void Enter_PersonDetails()
	{
		EnterFname("Nhlakanipho");
		EnterLName("Mthalane");
		EnterEmail("N@gmail.com");
		EnterCompany("Testing Company");
		EnterIndastry("Testt Indastry");
	}
	
	public void Click_SendCopy()
	{
		clickSendCopy.click();
	}
	
}
