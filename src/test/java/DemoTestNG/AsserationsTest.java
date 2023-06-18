package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AsserationsTest {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }
    @Test
    public void test_singleCheckBox(){
        driver.findElement(By.linkText("Checkbox Demo")).click();
        driver.findElement(By.id("isAgeSelected")).click();
      String actualMessage=  driver.findElement(By.id("txtAge")).getText();
       // Assert.assertTrue(actualMessage.contains("success"),"\n message doesn't contain success");
     //   Assert.assertEquals(actualMessage,"Success - Check box is checked");
    }
    @Test
    public void test_radioButtons(){
        driver.findElement(By.linkText("Radio Buttons Demo")).click();
        driver.findElement(By.xpath("//input[ @value ='Other']")).click();
        driver.findElement(By.xpath("//input[@value ='5 - 15']")).click();
        driver.findElement(By.xpath("//button[text() ='Get values']")).click();
      String actualGender=  driver.findElement(By.cssSelector(".genderbutton")).getText();
      String actualAgeGroup = driver.findElement(By.cssSelector(".groupradiobutton")).getText();
     softAssert.assertEquals(actualGender,"Other","\n actual gender s incorrect");
      softAssert.assertEquals(actualAgeGroup,"5 - 15","\n actual age is not correct");
    softAssert.assertTrue(actualAgeGroup.contains("5"),"\n Actual age group is not correct");
softAssert.assertAll();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


}

