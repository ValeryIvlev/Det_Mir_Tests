package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SubscriptionPage {

    public static String resultValueRegisteredEmail = "На этот адрес подписка уже оформлена.";
    public static String resultValueNewEmail = "Теперь вы подписаны на рассылку";
    public static String resultInvalidEmail = "Неверный адрес. Попробуйте другой.";

    private SelenideElement
    userEmailInput = $("#SubscriptionFormInline-email"),
    InfoErrorSubscription = $("[role=contentinfo]"),
    infoSuccessSubscription = $(".bxA");


    public SubscriptionPage openPage() {
        step("Открываем главную страницу", () -> {
        open(baseUrl);
    });
        return this;
    }
    public SubscriptionPage setEmail(String value) {
        step("Ввод Email адреса", () -> {
        userEmailInput.sendKeys(value);
        });
        return this;
    }
    public SubscriptionPage setEmailPressEnter() {
        step("Нажимаем кнопку Enter", () -> {
        userEmailInput.pressEnter();
        });
        return this;
    }
    public SubscriptionPage checkInfoErrorSubscriptionEmail(String value) {
        step("Проверяем текст ошибки", () -> {
        InfoErrorSubscription.shouldHave(text(value));
        });
        return this;
    }
    public SubscriptionPage checkInfoSuccessSubscription(String value) {
        step("Проверяем появившийся popUp", () -> {
        infoSuccessSubscription.shouldHave(text(value));
        });
        return this;
    }
}
