package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

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


        //SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open Product Card", () -> {
            open("https://www.lamoda.by/p/mp002xm0drq1/clothes-tomtailor-kardigan/");
        });

        step("Select size", () -> {
            $("._sizeValue_14ypi_285").shouldHave(text("Выберите размер")).click();
            $$("._colspanMain_14ypi_184").findBy(text("52/54 RUS")).click();
        });

        step("Click on 'Add to Cart' button", () -> {
            $("._wrapper_1u4cj_6").shouldHave(text("Добавить в корзину")).click();
        });


        sleep(1000);
    }
}
