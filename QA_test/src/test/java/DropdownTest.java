import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTest
{
    WebDriver driver;

    @BeforeMethod
    public void OpenChrome()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void DropdownLeafground()
    {
        //Goto leafground
        driver.get("https://www.leafground.com/select.xhtml;jsessionid=node0ex2ir6nogdr61bdlhtil9k349813674.node0");

        //select option from dropdown
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        select.selectByVisibleText("Playwright");

        //find no of option in dropdown
        List<WebElement> listOption =  select.getOptions();
        int countOption = listOption.size();
        System.out.println("The no of options = "+countOption);

        for(WebElement element:listOption)
        {
            System.out.println(element.getText());
        }

        //using sendkey select option value
        dropdown.sendKeys("Puppeteer");

        //Bootstrap dropdown
        WebElement dropdown2 = driver.findElement(By.xpath("//label[@id='j_idt87:country_label']"));
        dropdown2.click();
        List<WebElement> OptionList = dropdown2.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));

        for (WebElement element:OptionList)
        {
            String OptionValues = element.getText();
            if(element.equals("USA"))
            {
                element.click();
                break;
            }
        }


    }

    @Test
    public  void googleSuggestions() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("palitha");
        Thread.sleep(2000);
        List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@class='G43f7e']/li//div[@class='wM6W7d']"));
        System.out.println(suggestions.size());
        for (WebElement element:suggestions)
        {
            System.out.println(element.getText());
        }
    }
}
