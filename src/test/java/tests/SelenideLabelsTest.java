package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideLabelsTest {

    private static final String REPOSITORY = "KaNoNiR-FuN/qa_guru_15_10_hw";
    private static final int ISSUE = 1;

    @Test
    @Feature("Search Issue in repository")
    @Story("Issue in repository")
    @Owner("dakharitonov")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Find Git Issue")
    public void findGitIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUE)).should(Condition.exist);
    }
}
