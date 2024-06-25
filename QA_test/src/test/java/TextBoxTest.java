import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest
{
    WebDriver driver;

    @BeforeMethod
    public void OpenDrive()
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("123");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }
    @Test
    public void TextBTest()
    {
        //type name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Malki");

        //Append country to this city
        WebElement append = driver.findElement(By.id("j_idt88:j_idt91"));
        append.sendKeys("Sri Lanka");

        //verify text box disability
        boolean enable = driver.findElement(By.name("j_idt88:j_idt91")).isEnabled();
        System.out.println(enable);

        //clear the typed text
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //Retrieve the typed text
        WebElement retrievedText = driver.findElement(By.id("j_idt88:j_idt97"));
        String TextRetrieved = retrievedText.getAttribute("value");
        System.out.println("Typed text is "+TextRetrieved);

        //Type email and Tab. Confirm control moved to next element.
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("dmrwgunawardana@gmail.com"+ Keys.TAB+"Confirm control moved to next element");



    }
}
