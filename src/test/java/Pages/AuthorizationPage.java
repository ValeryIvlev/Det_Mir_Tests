package Pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AuthorizationPage {

    private String
            nameButtonEnterGoogle = "Войти с Google",
            nameButtonEnterApple = "Войти с Apple",
            nameButtonVK = "Войти через VK ID",
            nameTextEnterGoogle = "Войдите в аккаунт Google",
            nameTextEnterApple = "Используйте Apple ID для входа в приложение «Детский мир»",
            nameTextEnterVK = "В сервис «Детский мир» можно войти через VK ID";
    private SelenideElement
            buttonEnterRegistration = $("[data-testid=headerLoginBlock]"),
            buttonEnterGoogle = $(".M_7").$(new ByText(nameButtonEnterGoogle)),
            buttonEnterApple = $(".M_7").$(new ByText(nameButtonEnterApple)),
            buttonEnterVK = $(".M_7").$(new ByText(nameButtonVK)),
            textEnterGoogle = $("#initialView"),
            textEnterApple = $("#step"),
            textEnterVK = $(".vkc__PromoBox__promoBox");



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
    public AuthorizationPage setEnterGoogle () {
        step("Выбираем авторизацию с помошью Google", () -> {
        buttonEnterGoogle.click();
        });
        return this;
    }
    public AuthorizationPage setEnterApple () {
        step("Выбираем авторизацию с помошью Apple", () -> {
        buttonEnterApple.click();
        });
        return this;
    }
    public AuthorizationPage setEnterVK () {
        step("Выбираем авторизацию с помошью VK", () -> {
        buttonEnterVK.click();
        });
        return this;
    }

    public AuthorizationPage setSwitchToWindow () {
        step("Переходим в окно авторизации", () -> {
        switchTo().window(1);
        });
        return this;
    }
    public AuthorizationPage checkingTextGoogle () {
        step("Проверяем успешный переход на форму авторизации Google", () -> {
        textEnterGoogle.shouldHave(text(nameTextEnterGoogle));
        });
        return this;
    }

    public AuthorizationPage checkingTextApple () {
        step("Проверяем успешный переход на форму авторизации Apple", () -> {
        textEnterApple.shouldHave(text(nameTextEnterApple));
        });
        return this;
    }
    public AuthorizationPage checkingTextVK () {
        step("Проверяем успешный переход на форму авторизации Apple", () -> {
        textEnterVK.shouldHave(text(nameTextEnterVK));
        });
        return this;
    }
}
