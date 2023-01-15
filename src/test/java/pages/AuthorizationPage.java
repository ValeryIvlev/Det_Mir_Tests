package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AuthorizationPage {

    public static String nameButtonEnterGoogle = "Войти с Google";
    public static String nameButtonEnterApple = "Войти с Apple";
    public static String nameButtonEnterVK = "Войти через VK ID";
    public static String nameTextEnterGoogle = "Google";
    public static String nameTextEnterApple = "Apple ID";
    public static String nameTextEnterVK = "VK ID";
    private SelenideElement
            buttonEnterRegistration = $("[data-testid=headerLoginBlock]"),
            buttonEnterNameAuthorization = $(".J_9"),
            textEnterGoogle = $("#initialView"),
            textEnterApple = $("#step"),
            textEnterVK = $("#root");

    public AuthorizationPage openPage() {
        step("Открываем главную страницу", () -> {
        open(baseUrl);
        });
        return this;
    }
    public AuthorizationPage setRegistrationAndEnter () {
        step("Открываем попап Авторизации и Регистрации", () -> {
        buttonEnterRegistration.click();
        });
        return this;
    }
    public AuthorizationPage setEnterButtonAutorization (String value) {
        step("Выбираем авторизацию с помошью", () -> {
        buttonEnterNameAuthorization.$(new ByText(value)).click();
        });
        return this;
    }

    public AuthorizationPage setSwitchToWindow () {
        step("Переходим в окно авторизации", () -> {
        switchTo().window(1);
        });
        return this;
    }
    public AuthorizationPage checkingTextAuthorizationGoogle (String value) {
        step("Проверяем успешный переход на форму авторизации Google", () -> {
        textEnterGoogle.shouldHave(text(value));
        });
        return this;
    }
    public AuthorizationPage checkingTextAuthorizationVK (String value) {
        step("Проверяем успешный переход на форму авторизации VK", () -> {
            textEnterVK.shouldHave(text(value));
        });
        return this;
    }
    public AuthorizationPage checkingTextAuthorizationApple (String value) {
        step("Проверяем успешный переход на форму авторизации Apple", () -> {
            textEnterApple.shouldHave(text(value));
        });
        return this;
    }
}
