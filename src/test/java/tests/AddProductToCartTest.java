package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AddProductToCartTest extends TestBase {

    @Test
    void testAddingToCart() {

        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;


        open("https://www.lamoda.by/p/mp002xm0drq1/clothes-tomtailor-kardigan/");
        $("._sizeValue_14ypi_285").shouldHave(text("Выберите размер")).click();

        $$("._colspanMain_14ypi_184").findBy(text("52/54 RUS")).click();

        $("._wrapper_1u4cj_6").shouldHave(text("Добавить в корзину")).click();

        sleep(1000);
    }
}
