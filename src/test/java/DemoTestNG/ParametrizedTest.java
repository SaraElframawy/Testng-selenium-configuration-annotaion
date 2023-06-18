package DemoTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ParametrizedTest {
WebDriver driver;

    @Parameters({"URL"}) //the name in xml file parameter tags
@BeforeClass
    public void setUp(String url){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //step one use the first parameter that existed on the suite tags before it exist on the test
        // to bring out the url from the value of the parameter
        driver.get(url);



}
@Test
@Parameters({"Task","TestResult"}) //name of the parameter in xml file

    public void fileDownload(String Task, String TestResult){
        //step 2 click the file download link
        driver.findElement(By.linkText("File Download")).click();



    //step 3 enter data
    driver.findElement(By.id("textbox")).sendKeys(Task +
            "  Execution : "+ TestResult
    );

    //step 4 click generate file button
    driver.findElement(By.id("create")).click();
    //click the download link
    driver.findElement(By.id("link-to-download")).click();
}
@AfterClass
    public void tearDown() throws InterruptedException {
    Thread.sleep(5000);
    driver.quit();

}



}
