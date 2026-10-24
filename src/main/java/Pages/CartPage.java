package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    WebDriver driver;
    public CartPage (WebDriver driver)
    {
        this.driver=driver;
    }
    private By continueshopping =By.id("continue-shopping");
    private By checkout =By.id("checkout");
    private By cartitem =By.cssSelector("div[class='cart_item']");
    private By items = By.className("inventory_item_name");

    public void clickoncheckout()
    {
        driver.findElement(checkout).click();
    }
    public void clickcontinueshopping()
    {
        driver.findElement(continueshopping).click();
    }
    public boolean CartItem()
    {
        return driver.findElements(cartitem).isEmpty();
    }
    public List<String> gettext ()
    {
       List<WebElement> webElements = driver.findElements(items);
       List<String> itemnames =new ArrayList<>();
       for (WebElement element:webElements)
       {
           itemnames.add(element.getText());
       }
       return itemnames;
    }






}
