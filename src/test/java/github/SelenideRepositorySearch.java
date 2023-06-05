package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = CHROME;
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void searchSelenideRepository(){
        //Открыть страницу  GitHub
        Selenide.open(baseUrl);
        //В "поисковой строке" вести текст и нажать поиск
        $("[placeholder='Search GitHub']").setValue("selenide").pressEnter();

        //Открывается страница с результатами поиска. Найти в нем селенид и перейти по ссылке
        $("ul.repo-list li").$("a").click();
        //Проверить что это верная страница, содержащая текст
        $("#repository-container-header").shouldHave(Condition.text("selinide/selenide"));


    }
}
