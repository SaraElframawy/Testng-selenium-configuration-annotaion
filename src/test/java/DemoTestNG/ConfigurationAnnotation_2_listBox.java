package DemoTestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
@Test
public class ConfigurationAnnotation_2_listBox {

    public void test3_bootstrapListBox(){
        System.out.println("Test method 3:Boot strap Test box :");
    }

    public void test4_bootstrapListBox(){
        System.out.println("Test method 4:Boot strap Test box:");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Execute before method in the second class");
    }
    @AfterMethod
    public void AfterMethod(){
        System.out.println("Execute after each method in the second class");
    }
    @BeforeClass
    public void BeforeClass(){
        System.out.println("Before class");
    }

}
