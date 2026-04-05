package pritamawate.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pritamawate.AbstractComponents.AbstractComponents;

import java.util.List;

public class CartPage extends AbstractComponents {


    public CartPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".inventory_item_name")
    private List<WebElement> cartItem;

    @FindBy(id = "checkout")
    WebElement checkoutEle;

    public Boolean VerifyProductDisplay(String productName)
    {
        Boolean match = cartItem.stream()
                .anyMatch(cartProduct ->
                        cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckoutPage GoToCheckout()
    {
        checkoutEle.click();
        return new CheckoutPage(driver);
    }
}
