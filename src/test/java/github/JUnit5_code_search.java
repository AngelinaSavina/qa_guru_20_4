package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class JUnit5_code_search {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = CHROME;
        Configuration.holdBrowserOpen = true;
    }

    String pageName = "SoftAssertions";

    @Test
    void selenideWiki(){

        Selenide.open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".wiki-pages-box").click();
        $(".wiki-more-pages-link button").click();
        $("[placeholder='Find a page…']").setValue("SoftAssertions");
        $(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(Condition.text("@ExtendWith({SoftAssertsExtension.class})"));
        $("#wiki-body").shouldHave(Condition.text("class Tests {"));
        $("#wiki-body").shouldHave(Condition.text("@Test"));
        $("#wiki-body").shouldHave(Condition.text("void test() {"));
        $("#wiki-body").shouldHave(Condition.text("Configuration.assertionMode = SOFT;"));
        $("#wiki-body").shouldHave(Condition.text("open(\"page.html\");"));
        $("#wiki-body").shouldHave(Condition.text("$(\"#first\").should(visible).click();"));
        $("#wiki-body").shouldHave(Condition.text("$(\"#second\").should(visible).click();"));

    }
}
