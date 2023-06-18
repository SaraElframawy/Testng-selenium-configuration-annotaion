package com.lambdatest.tests;

import com.LambdaTest.pages.BootStrapProgressBarPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProgressBarTest extends BaseTest{
BootStrapProgressBarPage progressBarPage = new BootStrapProgressBarPage();
SoftAssert softAssert = new SoftAssert();
@Test
public void progressBarPercentage(){
    progressBarPage = homePage.clickBootstrapProgressBar();
    progressBarPage.clickStartDownloadButton();
    String actualMessage =progressBarPage.getCompletedMessage();
    String actualPercentage = progressBarPage.getProgressBarPercentage();
    String expectedMessage = "Dowload completed!";
    String expectedPercentage = "100%";
    softAssert.assertEquals(actualMessage,expectedMessage, "\n the message is not complete");
    softAssert.assertEquals(actualPercentage,expectedPercentage,"\n percentage is not 100%\n");
    softAssert.assertAll();



}

}
