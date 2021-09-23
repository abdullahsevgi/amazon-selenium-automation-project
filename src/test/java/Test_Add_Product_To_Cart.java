import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Test_Add_Product_To_Cart extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test
    @Order(1)
    public void searchProduct() {
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        productsPage = new ProductsPage(driver);
        homePage.SearchBox().search("Laptop");
        Assertions.assertTrue(productsPage.isOnProductPage(), "Urunler Sayfasinda Degilsiniz!");

    }

    @Test
    @Order(2)
    public void selectProduct() {
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct(1);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(), "Urun Detay Sayfasinda Degilsiniz!");

    }

    @Test
    @Order(3)
    public void addProductCart() {
        productDetailPage.addToCart();
        Assertions.assertTrue(homePage.isProductCountUp(), "Sepetteki Urun Sayisi Artmadi!");

    }

    @Test
    @Order(4)
    public void go_To_Cart() {
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded(), "Urun Sepete Eklenemedi!");

    }

}
