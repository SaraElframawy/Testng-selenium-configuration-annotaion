package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class TakeFailedScreenShoots {
    WebDriver driver;

@BeforeMethod
public void setup(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();



}
@Test
    public void testFormDemo(){
    driver.get("https://www.lambdatest.com/selenium-playground/");
    driver.findElement(By.linkText("Simple Form Demo")).click();
    driver.findElement(By.xpath("//p[text()='Enter Message']//following-sibling::input"))
            .sendKeys("Lambda Test is Awesome!!!");
    driver.findElement(By.id("showInput")).click();
    String actualMessage = driver.findElement(By.id("message")).getText();
    Assert.assertEquals(actualMessage,"Lambda Test is Awesome!!!" +

            "\n message is lambdatest is not awesome");


}
@AfterMethod
public void takeScreenshotsForFailure()  {
    TakesScreenshot screenshot =(TakesScreenshot) driver;
File source =screenshot.getScreenshotAs(OutputType.FILE);
File destination = new File(System.getProperty("user.dir")+
        "/resources/screenshots/testSimpleFormDemo_passed_again2.png");
    try {
        FileHandler.copy(source,destination);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}


}