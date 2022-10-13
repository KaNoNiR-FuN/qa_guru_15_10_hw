package tests;

import Steps.WebSteps;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotatedTest {

    private static final String REPOSITORY = "KaNoNiR-FuN/qa_guru_15_10_hw";
    private static final int ISSUE = 1;

    @Test
    public void findGitIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.clickIssues();
        steps.checkIssue(ISSUE);
    }
}
