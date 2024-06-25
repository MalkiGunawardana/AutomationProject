import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest
{
    WebDriver driver;

    @BeforeMethod
    public void OpenDrive()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");

    }

    @Test
    public void AlertExample() throws InterruptedException {
        //Accept alert
        WebElement acceptAlert = driver.findElement(By.id("j_idt88:j_idt91"));
        acceptAlert.click();
        Thread.sleep(3000);
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();

        //Dismiss
        WebElement dismissAlert = driver.findElement(By.id("j_idt88:j_idt93"));
        dismissAlert.click();
        Thread.sleep(3000);
        Alert alert2 = driver.switchTo().alert();
        alert1.dismiss();

        //Prompt alert
        WebElement promptAlert = driver.findElement(By.id("j_idt88:j_idt104"));
        promptAlert.click();
        Thread.sleep(3000);
        Alert alert3 = driver.switchTo().alert();
        System.out.println(alert3.getText());
        alert3.sendKeys("Test Automation");
        alert1.accept();

    }
}
