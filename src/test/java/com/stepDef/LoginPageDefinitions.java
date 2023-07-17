package com.stepDef;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageDefinitions {
	
	private static WebDriver driver;       
    public final static int TIMEOUT = 10;
     
    @Before
    public void setUp() {
    	
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }
 
    @Given("User is on sauceLabsDemo page {string}")
    public void user_is_on_sauce_labs_demo_page(String url) {
         
        driver.get(url);
  
    }
  
    @When("User enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String userName, String passWord) {
    	
        // login to application
        driver.findElement(By.cssSelector("#user-name")).sendKeys(userName);
        driver.findElement(By.cssSelector("#password")).sendKeys(passWord);      
        driver.findElement(By.cssSelector("#login-button")).submit();
  
        // go the next page
         
    }
     
    @Then("User should be able to login sucessfully and new page open")
    public void user_should_be_able_to_login_sucessfully_and_new_page_open() {
  
         String homePageHeading = driver.findElement(By.cssSelector("span.title")).getText();
          
         //Verify new page - HomePage
         Assert.assertEquals(homePageHeading,"Products");
  
    }
    
    @Then("User should be able to see error message {string}")
    public void user_should_be_able_to_see_error_message(String expectedErrorMessage) {
   
        String actualErrorMessage = driver.findElement(By.cssSelector("div.error-message-container.error")).getText();
         
        // Verify Error Message
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
  
    }
     
    @After
    public void teardown() {
  
        driver.quit();
    }

}
