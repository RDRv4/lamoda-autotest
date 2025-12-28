package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.AddProductToCart;

import static io.qameta.allure.Allure.step;

@Story("Добавление товара в корзину")
@Tags({@Tag("ui")})

public class AddProductToCartTest extends TestBase {

    @Test
    void testAddingToCart() {

        AddProductToCart addProductToCart = new AddProductToCart();
        String sizePriduct = "44 RUS";


        step("Open Product Card", () -> {
            addProductToCart.openPage();
        });

        step("Choose size for Product", () -> {
            addProductToCart.chooseSizeProduct(sizePriduct);
        });

        step("Click on 'Add to Cart' button", () -> {
            addProductToCart.addProductToCart();
        });
    }
}
