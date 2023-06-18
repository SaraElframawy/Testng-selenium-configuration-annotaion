package com.LambdaTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BootStrapProgressBarPage extends BasePage{
    private By startDownloadButton = By.id("dwnBtn");
    private By progressBarPercentage = By.cssSelector(".counter");
    private By compeletedMessage = By.xpath("//p[contains(@class, 'success')]");
    public void clickStartDownloadButton(){
        click(startDownloadButton);
    }
    public String getProgressBarPercentage(){
        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(5)
        );
        wait.until(ExpectedConditions.visibilityOfElementLocated(progressBarPercentage));
      String percentage =  getText(progressBarPercentage);
      return percentage;

    }
    public String getCompletedMessage (){
        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(5)
        );
        wait.until(ExpectedConditions.visibilityOfElementLocated(compeletedMessage));
        return getText(compeletedMessage);



    }
}
