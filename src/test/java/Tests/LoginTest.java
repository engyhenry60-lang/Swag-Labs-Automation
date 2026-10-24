package Tests;

import Base.BaseTest;
import Pages.InventoryPage;
import Pages.LoginPage;
import Utils.DataDriven;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void Validlogintest() {
        String username =DataDriven.jsonReader("validUsername");
        String password =DataDriven.jsonReader("validPassword");
        loginPage.SetUsername(username);
        loginPage.SetPassword(password);
        loginPage.Clickloginbutton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"),
                "you are not in InventoryPage ");
    }
    @Test
    public void InvalidLoginTests() {
        String username =DataDriven.jsonReader("invalidUsername");
        String password =DataDriven.jsonReader("invalidPassword");
        loginPage.SetUsername(username);
        loginPage.SetPassword(password);
        loginPage.Clickloginbutton();

        Assert.assertTrue(loginPage.GetInvalidcredentialMessage().contains("Username and password do not match"));
    }
    @Test
    public void EmptyPasswordTest()
    {   String username = DataDriven.jsonReader("validUsername");
        loginPage.SetUsername(username);
        loginPage.Clickloginbutton();
        loginPage.GetEmptyPasswordMessage();
        Assert.assertTrue(loginPage.GetEmptyPasswordMessage().contains("Password is required"));
    }

}
