package pritamawate.AbstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pritamawate.pageobjects.CartPage;

import java.time.Duration;

public class AbstractComponents {

    protected WebDriver driver;

    public AbstractComponents(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(css = ".shopping_cart_link")
    WebElement cartHeader;

    public void waitForElementToAppear(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public CartPage goToCartPage()
    {
        cartHeader.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }
}
