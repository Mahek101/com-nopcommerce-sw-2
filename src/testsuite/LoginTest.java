package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseURL = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL); // Browser setup method from BaseTest class
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.linkText("Log in")).click(); // Find login link and click on it
        String expectedMessage = "Welcome, Please Sign In!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = actualTextElement.getText(); // Get actual message on page by get method
        Assert.assertEquals("Not redirected to Log in page", expectedMessage, actualMessage); //checking ecpected and actual message
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.linkText("Log in")).click(); // Find login link and click on it
        driver.findElement(By.id("Email")).sendKeys("megha123@gmail.com");// Find Email field and enter email id
        driver.findElement(By.id("Password")).sendKeys("megha123");// Find password field and enter password
        driver.findElement(By.xpath("//button[text()='Log in']")).click(); // Find Log In button and click it
        driver.findElement(By.linkText("Log out")).click();
    }

    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.linkText("Log in")).click(); // Find login link and click on it
        driver.findElement(By.id("Email")).sendKeys("megha1234@gmail.com");// Find Email field and enter invalid email id
        driver.findElement(By.id("Password")).sendKeys("megha1234");// Find password field and enter invalid password
        driver.findElement(By.xpath("//button[text()='Log in']")).click(); // Find Log In button and click it
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));//
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Error message is not displayed", actualMessage, expectedMessage);// Checking expected message vs actual message
    }
    @After
    public void tearDown() {
        closeBrowser(); // Close the window
    }
}




