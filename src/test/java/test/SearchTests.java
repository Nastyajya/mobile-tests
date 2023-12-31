package test;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {
    @Test
    void successfulSearchTest() {

            step("Type search", () -> {
                $(AppiumBy.accessibilityId("Search Wikipedia")).click();
                $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
            });
            step("Verify content found", () ->
                    $$(AppiumBy.id("org.wikipedia.alpha:id/search_container"))
                            .shouldHave(sizeGreaterThan(0)));
        }
    }

