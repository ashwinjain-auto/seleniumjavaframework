package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginSteps {
	
	WebDriver driver = null;
	LoginPage loginpage;
	
	@Before
	public void setup() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		loginpage= new LoginPage(driver);
		
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@Given("I launch the web xfinity.com")
	public void i_launch_the_web_xfinity_com() {
	    driver.get("https://customer.xfinity.com/");
	}

	@When("^I login with (.*) and (.*)$")
	public void i_login_with_username_and_password(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
//		driver.findElement(By.id("user")).sendKeys(username);
//		driver.findElement(By.id("passwd")).sendKeys(password);
//		driver.findElement(By.id("sign_in")).click();
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSignInBtn();
	}

	@Then("I should be signed in  state")
	public void i_should_be_signed_in_state() {
	    // Write code here that turns the phrase above into concrete actions
//		driver.findElement(By.name("myaccount"));
		loginpage.validateMyAccount();
	}

}
