package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AddProductToCart {

    private static final String URL_PRODUCT = "/p/rtlaeq682801/shoes-hebymango-botinki/";

    SelenideElement choseSizeProduct = $("._sizeValue_14ypi_285");
    ElementsCollection sizeDropdown = $$("._colspanMain_14ypi_184");
    SelenideElement addToCartButton = $("._wrapper_1u4cj_6");
    SelenideElement sizeInTheCart = $("._title_yp235_38 + div");


    public AddProductToCart openPage() {
        open(URL_PRODUCT);
        return this;
    }

    public AddProductToCart chooseSizeProduct(String size) {
        choseSizeProduct.shouldHave(text("Выберите размер")).click();
        sizeDropdown.findBy(text(size)).click();
        return this;
    }

    public AddProductToCart addProductToCart() {
        addToCartButton.shouldHave(text("Добавить в корзину")).click();
        return this;
    }

    public AddProductToCart assertProductSizeInCart(String size) {
        sizeInTheCart.shouldHave(text(size));
        return this;
    }

}
