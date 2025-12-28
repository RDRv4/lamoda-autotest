package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.AddProductToCart;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

@Owner("d.rudovich")
@Feature("UI тесты lamoda.by")
@Story("Добавление товара в корзину")
@Tags({@Tag("ui")})

public class AddProductToCartTest extends TestBase {

    @Test
    void testAddingToCart() {

        AddProductToCart addProductToCart = new AddProductToCart();
        String sizeProduct = "44 RUS";


        step("Open Product Card", () -> {
            addProductToCart.openPage();
        });

        step("Choose size for Product", () -> {
            addProductToCart.chooseSizeProduct(sizeProduct);
        });

        step("Click on 'Add to Cart' button", () -> {
            addProductToCart.addProductToCart();
        });

        step("Cheking Product size in the Cart", () -> {
            addProductToCart.assertProductSizeInCart(sizeProduct);
        });

        sleep(2000);
    }
}
