package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseURL = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL); // Browser setup method from BaseTest class
    }
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){
        driver.findElement(By.linkText("Register")).click();
        String expectedText = "Register";
        WebElement actualWebElement = driver.findElement(By.xpath("//h1[text()='Register']"));
        String actualText = actualWebElement.getText();
        Assert.assertEquals("Expected Text doesn't meets Actual Text", expectedText, actualText);
    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){
        driver.findElement(By.linkText("Register")).click();// click on the ‘Register’ link
        driver.findElement(By.xpath("//label[text()='Female']"));// Select gender radio button
        driver.findElement(By.id("FirstName")).sendKeys("Megha");// Enter first name
        driver.findElement(By.id("LastName")).sendKeys("Mehta");// Enter last name
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("9");// Select Date of Birth
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("January");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1999");
        driver.findElement(By.id("Email")).sendKeys("mehta12345@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("mehta123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("mehta123");
        driver.findElement(By.id("register-button")).click();
        String expectedText = "Your registration completed";
        WebElement actualWebElement = driver.findElement(By.xpath("//div[text()='Your registration completed']"));
        String actualText = actualWebElement.getText();
        Assert.assertEquals("Expected Text doesn't meets Actual Text", expectedText, actualText);
    }
    @After
    public void tearDown() {
        closeBrowser(); // Close the window
    }
}
