package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
public class LoginStepDefinition {
	public WebDriver driver;
	
	@Given("^user is already on login page$")
	public void user_is_already_on_login_page() {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://freecrm.com/");
		//driver.findElement(By.xpath("//*[@id=\"intercom-container\"]/div/div/div[1]/div/div/span")).click();
}
	
	@When("^ title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM() {
		String title=driver.getTitle();
		System.out.println("Title is  "+title );
		Assert.assertEquals("Free CRM software in the cloud for sales and service",title);	
		
	}
		
	@Then("^click on login button$")
	public void click_on_login_button() {
			driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/a/span[2]")).click();
	}
	@Then("^user enters username and password$")
	public void user_enters_username_and_password() {
		driver.findElement(By.name("email")).sendKeys("minkugrang@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Ashmeet2008");
	}
	
	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("//*[@id='ui']/div/div/form/div/div[3]")).click();
		System.out.println("All done");
	    
}
	@Then("^user is on home page$")
	public void user_is_on_home_page() {
		String t=driver.getTitle();
		Assert.assertEquals(t, "Cogmento CRM");
		
			System.out.println("User is on Home page  "+ t);
		
	}
	
	@Then("^ close the browser$")
	public void close_the_browser() {
		driver.close();
	}
}
