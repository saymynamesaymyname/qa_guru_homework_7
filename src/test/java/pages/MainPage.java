package pages;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class MainPage {

    private SelenideElement
    selectorOfGender = $("ul[data-testid='floornav']");
    ElementsCollection navigationButtons = $$("[data-testid='primarynav-button']");
    ElementsCollection flyOutMenuElements = $$("[data-testid='secondarynav-flyout']");

    public  MainPage selectGender (String gender) {
        selectorOfGender.$(byText(gender)).click();
        return this;
    }

    public  MainPage clickOnNavigationButton (String value) {
        navigationButtons.filterBy(Condition.text(value)).first().click();
        return this;
    }

    public MainPage checkButtonWithTextExists (String value) {
        navigationButtons.shouldHave(CollectionCondition.itemWithText(value));
        return this;
    }

    public MainPage checkSetOfButtonsExists() {
        navigationButtons.shouldBe(CollectionCondition.sizeGreaterThan(1));
        return this;
    }



}
