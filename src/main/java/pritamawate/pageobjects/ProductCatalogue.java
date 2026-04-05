package pritamawate.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pritamawate.AbstractComponents.AbstractComponents;

import java.util.List;

public class ProductCatalogue extends AbstractComponents {

    WebDriver driver;
    public ProductCatalogue(WebDriver driver)
    {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".inventory_item_description")
    List<WebElement> productList;


    By productsBy = By.cssSelector(".inventory_item_description");
    By addToCart = By.xpath("//button[text()='Add to cart']");


    public List<WebElement> getProductList()
    {
        waitForElementToAppear(productsBy);
        return productList;
    }

    public WebElement getProductByName(String productName)
    {
        return getProductList().stream()
                .filter(product ->
                        product.findElement(By.cssSelector(".inventory_item_name"))
                                .getText()
                                .equals(productName))
                .findFirst()
                .orElse(null);
    }

    public void addProductToCart(String productName)
    {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
    }

}
