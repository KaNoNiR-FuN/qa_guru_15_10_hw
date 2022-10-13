package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTest {

    private static final String REPOSITORY = "KaNoNiR-FuN/qa_guru_15_10_hw";
    private static final int ISSUE = 1;

    @Test
    public void findGitIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open git", () -> {
            open("https://github.com");
        });

        step("Search repo " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Click on repo " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Open tab Issue", () ->{
            $("#issues-tab").click();
        });

        step("Check Issue with number " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });

    }
}
