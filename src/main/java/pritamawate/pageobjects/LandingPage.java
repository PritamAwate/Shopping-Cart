package pritamawate.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pritamawate.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents

{
    WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement LoginButton;


    public ProductCatalogue loginApplication(String email, String pass)
    {
        userName.sendKeys(email);
        password.sendKeys(pass);
        LoginButton.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;
    }

    public void goTo()
    {
        driver.get("https://www.saucedemo.com/");
    }


}
