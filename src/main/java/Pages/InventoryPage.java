package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {
    private WebDriver driver;

    public InventoryPage(WebDriver driver)
    {
        this.driver=driver;
    }
    private By pagetitle = By.xpath("//div[text()='Swag Labs']");
    private By Elements =By.className("inventory_item");
    private By carticon =By.className("shopping_cart_link");
    private String className_X = "social_x";
    private String className_FaceBook ="social_facebook";
    private String className_linkedin ="social_linkedin";


    public String checkpagetitle()
    {
       return driver.findElement(pagetitle).getText();
    }
    public int ElementsTotal()
    {
        List<WebElement> AllElements = driver.findElements(Elements);
        return AllElements.size();
    }
    public boolean  findcarticon()
    {
        return driver.findElement(carticon).isDisplayed();
    }

    public CartPage ClickonCartIcon()
    {
        driver.findElement(carticon).click();
        return new CartPage(driver);
    }

    public void click(String classname)
    {
        driver.findElement(By.cssSelector("." + classname + " a")).click();
    }
    public String clicklinkedinicon()
    {
        click(className_linkedin);
        return Getlink(className_linkedin);
    }

    public String clickonfacebookicon()
    {
        click(className_FaceBook);
       return Getlink(className_FaceBook);
    }

    public String clickon_x_icon()
    {
        click(className_X);
        return Getlink(className_X);
    }

    public String Getlink(String classname)
    {
        return driver.findElement(By.cssSelector("." + classname + " a")).getAttribute("href");
    }
    public void addProductToCart(String productName)
    {
        String id = "add-to-cart-" + productName.toLowerCase().replace(" ", "-");
        driver.findElement(By.id(id)).click();
    }






}
