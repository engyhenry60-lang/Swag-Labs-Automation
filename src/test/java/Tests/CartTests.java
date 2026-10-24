package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.InventoryPage;
import Utils.DataDriven;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.*;


public class CartTests extends BaseTest {
    private CartPage cartpage;
    private InventoryPage inventoryPage;


    @BeforeMethod
    public void login() {
        loginPage.login("standard_user", "secret_sauce");
         inventoryPage = loginPage.Clickloginbutton();
    }

    @Test
    public void VerifyCartIsEmpt() {
        cartpage = inventoryPage.ClickonCartIcon();
        assertTrue(cartpage.CartItem());
    }

    @Test
    public void AddSpecificProducts() throws IOException {
        List<String> products = DataDriven.jsonReadercart("cartProduct");
        for (String name : products) {
            inventoryPage.addProductToCart(name);
        }
        cartpage = inventoryPage.ClickonCartIcon();
        assertEquals(cartpage.gettext(), products,
                "Cart items or their order differ from the added ones");
    }
    }

