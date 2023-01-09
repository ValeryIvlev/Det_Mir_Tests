package ru.detmir;

import Pages.AuthorizationPage;
import Pages.OrderPage;
import Pages.SubscriptionPage;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.*;


public class TestBase {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    SubscriptionPage subscriptionPage = new SubscriptionPage();
    OrderPage orderPage = new OrderPage();

    @BeforeAll
    static void BeforeAll() {
        WebDriverManager.chromedriver().setup();
        Configuration.baseUrl = "https://www.detmir.ru";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 60000;
        Configuration.headless = false;
        Configuration.webdriverLogsEnabled = true;
        Configuration.browser = Browsers.CHROME;
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

    }

    @AfterEach
    void setUp() {
       Attachments.screenshotAs("Last screenshot");
       Attachments.addVideo();
       Attachments.browserConsoleLogs();
       Attachments.pageSource();

        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

}

