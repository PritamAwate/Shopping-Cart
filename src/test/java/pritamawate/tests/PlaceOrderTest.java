package pritamawate.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pritamawate.TestComponents.BaseTest;
import pritamawate.pageobjects.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PlaceOrderTest extends BaseTest {

    @Test(dataProvider  = "getData")
    public void PlaceOrder(HashMap<String, String> input)
    {

        //checking webhook by adding this line
        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

        productCatalogue.addProductToCart(input.get("product"));
       CartPage cartPage = productCatalogue.goToCartPage();

       CheckoutPage checkoutPage = cartPage.GoToCheckout();
       checkoutPage.fillCheckoutDetails("pritam", "awate", "411033");
       orderSummaryPage orderConfirmationPage = checkoutPage.goToOrderSummary();
       String confirmMessage = orderConfirmationPage.ConfirmationPage();
         Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thank you for your order!"));

    }

    @DataProvider
    public Object[][] getData() throws IOException
    {
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")
                + "/src/test/java/pritamawate/Data/PurchaseOrder.json");
        return new Object[][]  {{data.get(0)},{data.get(1)}};
    }
}
