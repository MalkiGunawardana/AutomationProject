import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkTest
{
    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void LinkTes()
    {
        //Take me dashboard
        WebElement homelink = driver.findElement(By.linkText("Go to Dashboard"));
        homelink.click();
        driver.navigate().back();

        //find my destination
        WebElement wheretoGo = driver.findElement(By.partialLinkText("Find the URL"));
        String path = wheretoGo.getAttribute("href");
        System.out.println("This link is going to : "+path);

        //broken link
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();
        String brokenTitle = driver.getTitle();
        if (brokenTitle.contains("404"))
        {
            System.out.println("The link is broken");
        }
        else
        {
            System.out.println("The link is  not broken");
        }
        driver.navigate().back();

        //count page links
        List<WebElement> countLinks = driver.findElements(By.tagName("a"));
        int countPageLink = countLinks.size();
        System.out.println("Count of full page links : "+countPageLink);

        //count layout link

        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> layoutLink = layoutElement.findElements(By.tagName("a"));
        int linkCount = layoutLink.size();
        System.out.println("The no of links : "+linkCount);
        driver.quit();

    }
}
