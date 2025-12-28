package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AddProductToCart {

    private static final String URL_PRODUCT = "/p/rtlaeq682801/shoes-hebymango-botinki/";

    SelenideElement choseSizeProduct = $("._sizeValue_14ypi_285");
    ElementsCollection chooseDropDownSize = $$("._colspanMain_14ypi_184");
    SelenideElement addCartButton = $("._wrapper_1u4cj_6");



    public AddProductToCart openPage() {
        open(URL_PRODUCT);
        return this;
    }

    public AddProductToCart chooseSizeProduct(String size){
        choseSizeProduct.shouldHave(text("Выберите размер")).click();
        chooseDropDownSize.findBy(text(size)).click();
        return this;
    }

    public AddProductToCart addProductToCart(){
        addCartButton.shouldHave(text("Добавить в корзину")).click();
        return this;
    }

}
