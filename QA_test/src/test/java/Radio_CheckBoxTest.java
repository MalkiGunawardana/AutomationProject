import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Radio_CheckBoxTest
{
    WebDriver driver;

    @BeforeMethod
    public void OpenDrive()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public  void RadioExample()
    {
        driver.get("https://www.leafground.com/radio.xhtml;jsessionid=node0nd9bf6uz4spb1li6ihkiycvuf1233161.node0");

        //select radio button
        WebElement selectRadio = driver.findElement(By.xpath("//label[@for='j_idt87:console1:0']"));
        selectRadio.click();

        //check selectivity
        boolean isSelectChrome = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean isSelectFireFox = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean isSelectSafari = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean isSelectEdge = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if (isSelectChrome)
        {
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("selected "+chromeText);
        }
        else if (isSelectFireFox)
        {
            String FireFoxTest = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("selected "+FireFoxTest);
        }
        else if (isSelectSafari)
        {
            String SafariTest = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("selected "+SafariTest);
        }
        else if (isSelectEdge)
        {
            String EdgeTest = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("selected "+EdgeTest);
        }

        //Select (only if not selected)
        boolean checkSelection = driver.findElement(By.id("j_idt87:age:0")).isSelected();
        if(!checkSelection)
        {
            WebElement select = driver.findElement(By.xpath("//label[@for='j_idt87:age:0']"));
            select.click();
        }



    }

    @Test
    private void checkBoxExample()
    {
        driver.get("https://www.leafground.com/checkbox.xhtml");
        List<WebElement> selectCheckBox = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));

        for(WebElement element:selectCheckBox)
        {
            if(!(element.getText().equals("Others")))
            {
                element.click();
            }
        }

        for(int i=1; i<=selectCheckBox.size(); i++)
        {
            boolean selectStatus = driver.findElement(By.xpath("//table[@id='j_idt87:basic']//input["+i+"]")).isSelected();
            System.out.println("Check Box "+i+" selected status is "+selectStatus);
        }
    }

}
