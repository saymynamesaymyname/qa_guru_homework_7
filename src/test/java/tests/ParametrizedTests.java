package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class ParametrizedTests extends TestBase {

    MainPage mainPage = new MainPage();

    String marketPlace = "Marketplace";

    @ValueSource(strings = {
            "MEN",
            "WOMEN"
    })
    @ParameterizedTest(name = "Check that Marketplace menu item exists for both gender \"{0}\" ")
    void checkMarketPlaceButtonAppears (String testData) {
        open("");
        mainPage.selectGender(testData)
                .checkButtonWithTextExists(marketPlace);

    }

    @CsvSource(value = {
            "MEN,  Topman",
            "WOMEN,  Topshop",
    })
    @ParameterizedTest(name = "Check that menu buttons set has button \"{1}\" for gender \"{0}\"")
    void checkTextInMarketPlaceSection (String gender, String buttonText) {
        open("");
        mainPage
                .selectGender(gender)
                .checkButtonWithTextExists(buttonText);

    }

    @EnumSource(Gender.class)
    @ParameterizedTest(name = "Check that more then one buttons are displayed when selecting gender \"{0}\" ")
    void checkMarketPlaceButtonAppearence (Gender gender) {
        open("");
        mainPage.selectGender(gender.name())
                .checkSetOfButtonsExists();
    }
}
