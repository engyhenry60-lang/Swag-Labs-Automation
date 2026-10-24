package Tests;

import Base.BaseTest;
import Pages.InventoryPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class InventoryTest extends BaseTest {
    private InventoryPage inventoryPage;
    SoftAssert softAssert=new SoftAssert();

    @BeforeMethod
    public void Login(){
       loginPage.login("standard_user","secret_sauce");
        inventoryPage = loginPage.Clickloginbutton();}

    @Test
    public void VerifyIventorypage() {
        assertTrue(inventoryPage.checkpagetitle().contains("Swag Labs"), "You are not in InventoryPage");
        assertTrue(inventoryPage.findcarticon(), "cart icon is no displayed");
        assertEquals(inventoryPage.ElementsTotal(), 6, "Elements Total is not 6");
    }

    @Test
    public void Verify_X()
    {
        assertTrue(inventoryPage.clickon_x_icon().contains("x.com"));
    }
    @Test
    public void Verify_FaceBook()
    {
        assertTrue(inventoryPage.clickonfacebookicon().contains("facebook"));
    }
    @Test
    public void Verify_linkedin()
    {
        assertTrue(inventoryPage.clicklinkedinicon().contains("linkedin"));
    }
}
