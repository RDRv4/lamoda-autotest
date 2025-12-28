package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {

    public static final String TITLE = "Интернет магазин одежды и обуви. Купить обувь, купить одежду, аксессуары в онлайн магазине Lamoda.by";

    private final SelenideElement
            notificationCookie = $("._text_zj82w_18"),
            cookieCloseButton = $x("//button[text()=\"Хорошо\"]"),
            vkButton = $(".icon_social-vk[aria-label=\"vk\"]"),
            twitterButton = $(".icon_social-twitter[aria-label=\"twitter\"]"),
            headerLogo = $("._root_aroml_2[aria-label=\"Главная\"]"),
            genderMenu = $("[role=menubar] a[data-active=\"true\"]");

    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage cookieButtonClick() {
        if (notificationCookie.is(Condition.visible)) {
            cookieCloseButton.click();
        }
        return this;
    }

    public MainPage checkPageUrl(String url) {
        String urlPage = WebDriverRunner.url();
        assertEquals(urlPage, url);
        return this;
    }

    public MainPage checkSocialNetworkButton() {
        vkButton.should(appear);
        twitterButton.should(appear);
        return this;
    }

    public MainPage checkLogo() {
        headerLogo.should(appear);
        return this;
    }

    public MainPage chooseChapter(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public MainPage checkChapter(String gender) {
        genderMenu.shouldHave(text(gender));
        return this;
    }
}