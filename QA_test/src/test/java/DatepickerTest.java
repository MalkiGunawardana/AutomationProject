import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatepickerTest
{
    WebDriver driver;
    @BeforeMethod
    public void navigateToPage()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/datepicker");
    }

    @Test
    public void datePicker()
    {
        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("12/12/2022");
        date.sendKeys(Keys.RETURN);
        //driver.quit();

    }
}
