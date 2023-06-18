package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class DynamicWaits {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        //create the instance
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
     //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @Test
    public void testExplicitWait(){
        driver.findElement(By.linkText("Dynamic Data Loading")).click();

        driver.findElement(By.id("save")).click();
     By image =  By.xpath("//div[@id ='loading']//img");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(image));

     boolean isImageDisplayed = driver.findElement(image).isDisplayed();
        Assert.assertTrue(isImageDisplayed, "Image is not displayed");
    }
    @Test
    public void testFluentWait(){
        driver.findElement(By.linkText("JQuery Download Progress bars")).click();
        driver.findElement(By.id("downloadButton")).click();


        //waiting 30 seconds for an element to be present on the page
        //for its presence once every five seconds
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L)).
                //this means that the machine in total has to wait 30 secs
                pollingEvery(Duration.ofMillis(100)).
                // here it checks if the condition s filled every 5 sec
                ignoring(NoSuchElementException.class);
                // here is just to prevent the searching to stop when it accidently find no such elemnt exception


        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
             WebElement progress = driver.findElement
                     (By.xpath("//div[@id='dialog']//div[@class='progress-label']"));
             String progressBarTest = progress.getText();
             if(progressBarTest.equals("Complete!")){

                 System.out.println("Progress is completed");
                 return progress;
             }
             else {
                 System.out.println(progress.getText());
                 return null;
             }

            }
        });

    }
    @Test
    public void ImplicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
      //  driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
        driver.findElement((By.partialLinkText("Example 2"))).click();
        driver.findElement(By.xpath("//div[@id ='start']//button")).click();
        By helloWorld = By.xpath("//div [@id ='finish']/h4[text()='Hello World!']");
        String actualMessage = driver.findElement(helloWorld).getText();
        Assert.assertEquals(actualMessage,"Hello World!","\nMessage is not hello world !");

    }





    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


}

