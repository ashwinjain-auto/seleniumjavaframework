package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage {
	protected WebDriver driver = null;
	private By inputUsername = By.id("user");
	private By inputPassword = By.id("passwd");
	private By btnSignIn = By.id("sign_in");
	private By tabMyAccount = By.name("myaccount");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(this.inputUsername).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(this.inputPassword).sendKeys(password);
	}
	
	public void clickSignInBtn() {
		driver.findElement(this.btnSignIn).click();
	}
	
	public void validateMyAccount() {
		Assert.assertEquals(driver.findElement(this.tabMyAccount).getText(), "MY ACCOUNT");
	}
	

}
