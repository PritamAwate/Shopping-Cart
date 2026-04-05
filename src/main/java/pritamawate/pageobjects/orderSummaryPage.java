package pritamawate.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pritamawate.AbstractComponents.AbstractComponents;

public class orderSummaryPage extends AbstractComponents {

    public orderSummaryPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "finish")
    WebElement finishEle;

    public String ConfirmationPage()
    {

        finishEle.click();
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        return confirmationPage.getConfirmationMessage();
    }
}
