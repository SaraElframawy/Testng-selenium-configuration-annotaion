package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class First_automated_test {
    WebDriver driver;
    @BeforeClass
    public void init(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod //before each method
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();

      //  driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/");

    }

    @Test(priority = 2)
    public void testTableSortAndSearch() throws InterruptedException{
        driver.findElement(By.linkText("Table Sort & Search")).click();
       driver.findElement(By.xpath("//div[@id='__next']//p[text() ='Table']")).click();

      //means the section name [@attribute ='it is value']//inner section name [the content ='what is inside']
       driver.findElement(
               By.xpath("//div[@id= 'example_filter']//input[@type ='search']"))
              .sendKeys("A. Ramos");




    }
    @Test(priority = 1)
    public void testBootStrapDatePicker(){

      driver.findElement(By.linkText("Bootstrap Date Picker")).click();
        driver.findElement(By.cssSelector("#birthday")).sendKeys("18/09/1993");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
