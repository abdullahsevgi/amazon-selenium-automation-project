import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    By shippingOptionsLocator = By.id("p_n_free_shipping_eligible-title");
    By productNameLocator = new By.ByCssSelector("span.a-size-base-plus");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {
        return isDisplayed(shippingOptionsLocator);
    }

    public void selectProduct(int i) {
        getAllProduct().get(i).click();
    }

    public List<WebElement> getAllProduct() {
        return findAll(productNameLocator);
    }
}
