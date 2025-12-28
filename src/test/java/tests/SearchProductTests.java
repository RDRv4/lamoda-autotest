package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;
import pages.SearchPage;


import static io.qameta.allure.Allure.step;

@Owner("d.rudovich")
@Feature("UI тесты lamoda.by")
@Story("Product search")
@Tags({@Tag("ui")})

public class SearchProductTests extends TestBase {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @Severity(SeverityLevel.NORMAL)
    @ValueSource(strings = {"Футболки", "Шорты"})
    @ParameterizedTest(name = "{0}")
    @DisplayName("Search product by parameter")
    void testSearchProduct(String searchQuery) {
        step("Open the main page", () -> {
            mainPage.openPage()
                    .cookieButtonClick();
        });
        step("Enter the value " + searchQuery + " into the Search field", () -> {
            searchPage.searchProduct(searchQuery);
        });
        step("Verify the search result", () -> {
            searchPage.checkResultProduct(searchQuery);
        });
    }
}