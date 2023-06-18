package DemoTestNG;

import org.testng.annotations.*;


@Test (groups = "smoke")
public class ConfigurationAnnotation_datetimepickers {
    @Test(groups = "smoke")
    public void test1_bootstrapDatePicker(){
        System.out.println("Test method 1:Boot strap date picker :");
    }
    @Test(groups = {"regression"})
    public void test2_bootstrapDatePicker(){
        System.out.println("Test method 2:Boot strap date picker :");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Execute before method");
    }
    @AfterMethod
    public void AfterMethod(){
        System.out.println("Execute after each method");
    }
    @BeforeClass
    public void BeforeClass(){
        System.out.println("Before class");
    }
    @BeforeTest
    public void beforeTest (){
        System.out.println(" (2) Execute before each test");
    }
    @BeforeGroups(groups = {"smoke","regression"})
    public void beforeGroups(){
        System.out.println("Execute before groups:");
    }
    @AfterGroups(groups = {"smoke","regression"})
    public void afterGroups(){
        System.out.println("Execute after groups:");
    }


}
