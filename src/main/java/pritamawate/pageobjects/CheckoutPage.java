package pritamawate.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pritamawate.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {


    public CheckoutPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "first-name")
    WebElement firstNameEle;

    @FindBy (id = "last-name")
    WebElement lastNameEle;

    @FindBy (id = "postal-code")
    WebElement postalCodeEle;

    @FindBy (id = "continue")
    WebElement continueEle;

    public void fillCheckoutDetails(String firstName, String lastName, String postalCode)
    {
        firstNameEle.sendKeys(firstName);
        lastNameEle.sendKeys(lastName);
        postalCodeEle.sendKeys(postalCode);
    }

    public orderSummaryPage goToOrderSummary()
    {
        continueEle.click();
        return new orderSummaryPage(driver);
    }

}
