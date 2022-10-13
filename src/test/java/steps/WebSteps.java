package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Open GIT main page")
    public void openMainPage(){
        open("https://github.com");
    }

    @Step("Find repository {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Click on link repository {repository}")
    public void clickOnRepositoryLink(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Click on tab Issues")
    public void clickIssues() {
        $("#issues-tab").click();
    }

    @Step("Find issue with number {number}")
    public void checkIssue(int number) {
        $(withText("#" + number)).should(Condition.exist);
    }
}
