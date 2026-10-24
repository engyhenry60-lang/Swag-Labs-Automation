package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    private By UserNameFiled = By.id("user-name");
    private By PasswordFiled = By.id("password");
    private By LoginButton = By.id("login-button");
    private By InvalidcredentialMessage = By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']");
    private By EmptyPasswordMessage = By.xpath("//h3[text()='Epic sadface: Password is required']");

    public void SetUsername(String Username)
    {
        driver.findElement(UserNameFiled).sendKeys(Username);
    }
    public void SetPassword(String Password)
    {
        driver.findElement(PasswordFiled).sendKeys(Password);
    }
    public InventoryPage Clickloginbutton()
    {
        driver.findElement(LoginButton).click();
        return new InventoryPage(driver);
    }
    public void login(String USERNAME, String PASSWORD)
    {
        SetUsername(USERNAME);
        SetPassword(PASSWORD);
    }

    public String GetInvalidcredentialMessage()
    {
        return driver.findElement(InvalidcredentialMessage).getText();
    }
    public String GetEmptyPasswordMessage()
    {
        return driver.findElement(EmptyPasswordMessage).getText();
    }





}
