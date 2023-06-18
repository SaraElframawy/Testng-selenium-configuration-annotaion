package com.LambdaTest.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    private By bootstrapProgressBar = By.linkText("Bootstrap Progress bar");
    //locator of the page in which are going to test
    public BootStrapProgressBarPage clickBootstrapProgressBar(){
        click(bootstrapProgressBar);
        return new BootStrapProgressBarPage();
    }

}
