
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ButtonTest
{
    WebDriver driver;

    @BeforeMethod
    public void OpenChrome()
    {
        driver = new ChromeDriver();
        driver.get("https://www.leafground.com/button.xhtml");
        driver.manage().window().maximize();

    }

    @Test
    public void ButtonEx()
    {
        //click and confirm title
        WebElement buttonTest = driver.findElement(By.id("j_idt88:j_idt90"));
        buttonTest.click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";
        if(actualTitle.equals(expectedTitle))
        {
            System.out.println("Actual title and Expected title are same");
        }
        else
        {
            System.out.println("Actual title and Expected title are not same");
        }
        driver.navigate().back();
        //Assert.assertEquals(actualTitle,expectedTitle,"Title miss match");


        // Check if the button is disabled
        boolean disabledButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt92']")).isEnabled();
        System.out.println("Button disabled status: " + disabledButton);


        //Find the position of the button
        WebElement getPosition = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt92']"));
        Point xyPoint = getPosition.getLocation();
        int xPoint = xyPoint.getX();
        int yPoint = xyPoint.getY();
        System.out.println("x point is "+xPoint+ "y point is "+yPoint);

        //Find the color of the button
        String buttonColor = driver.findElement(By.id("j_idt88:j_idt96")).getCssValue("background-color");
        System.out.println("Button color is "+buttonColor);

        //Find width and height of the button
        WebElement dimensionButton = driver.findElement(By.id("j_idt88:j_idt98"));
        int height = dimensionButton.getSize().getHeight();
        int width = dimensionButton.getSize().getWidth();
        System.out.println("Height = "+height+" Width = "+width);

    }
}
