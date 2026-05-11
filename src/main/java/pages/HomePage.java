package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
	

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By logo = By.xpath("//img[@class='logo-main scale-with-grid']");
	By phone1 = By.xpath("//a[normalize-space()='+216 29 674 204']");
	By phone2 = By.xpath("//a[normalize-space()='+216 29 674 575']");
	By email = By.xpath("//a[normalize-space()='contact@expertunisie.com']");
	By tags = By.xpath("//p[@class='tags']/a");
	
	public Boolean isLogoDisplayed() {
		 return this.driver.findElement(logo).isDisplayed();
	}
	
	public String getPhone1() {
		
		return this.driver.findElement(phone1).getText();
		
	}
	
	public String getPhone2() {
		
		return this.driver.findElement(phone2).getText();
	}
	
	public Boolean isemailDisplayed() {
		
		return this.driver.findElement(email).isDisplayed();
	}
	public List<WebElement> getTags() {
		
		return this.driver.findElements(tags);
	}
	
}
