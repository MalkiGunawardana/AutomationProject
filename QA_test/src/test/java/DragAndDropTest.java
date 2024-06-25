import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTest
{
    WebDriver driver;
    @BeforeMethod
    public void navigateToPage()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/dragdrop");
    }

    @Test
    public void dragAndDrop()
    {
        WebElement drag = driver.findElement(By.id("image"));
        WebElement drop = driver.findElement(By.id("box"));
        Actions action = new Actions(driver);
        action.dragAndDrop(drag,drop).build().perform();

    }

}
