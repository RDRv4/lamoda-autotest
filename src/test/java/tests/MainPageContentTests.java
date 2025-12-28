package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Owner("d.rudovich")
@Feature("UI тесты lamoda.by")
@Story("Главная страница lamoda.by")
@Tags({@Tag("ui")})

public class MainPageContentTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Test titles of the main page")
    public void testTitle() {
        step("Open the main page and check the browser tab title", () -> {
            mainPage.openPage()
                    .cookieButtonClick();
            assertThat(title(), containsString(MainPage.TITLE));
        });
        step("Check that the logo is present", () -> {
            mainPage.checkLogo();
        });
    }

    @Severity(SeverityLevel.NORMAL)
    @ValueSource(strings = {"Женщинам", "Мужчинам", "Детям"})
    @ParameterizedTest(name = "\"{0}\"")
    @DisplayName("Check the presence of sections on the main page")
    void testGenderMenu(String gender) {
        step("Open the main page", () -> {
            mainPage.openPage();
        });
        step("Navigate to section " + gender, () -> {
            mainPage.chooseChapter(gender);
        });
        step("Verify the section in the main menu", () -> {
            mainPage.checkChapter(gender);
        });
        step("Clear cookies and return to the main page", () -> {
            clearBrowserCookies();
            back();
        });
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check the presence of the social networks block in the footer")
    void testSocialNetwork() {
        step("Open the main page", () -> {
            mainPage.openPage();
        });
        step("Verify that the main page contains a social networks block", () -> {
            mainPage.checkSocialNetworkButton();
        });
    }
}