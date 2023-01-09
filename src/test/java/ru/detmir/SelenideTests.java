package ru.detmir;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static Pages.OrderPage.*;
import static Pages.SubscriptionPage.*;
import static userData.OrderDate.InvalidAddressEmail;
import static userData.OrderDate.newEmail;
import static userData.OrderDate.registeredEmail;

public class SelenideTests extends TestBase{

    @Test
    @DisplayName("Проверка перехода на форму авторизации Google")
    @Tag("Prod")
    void testSwitchingAuthorizationGoogle() {

        authorizationPage.openPage()
                .setRegistrationAndEnter()
                .setEnterGoogle()
                .setSwitchToWindow()
                .checkingTextGoogle();
    }

    @Test
    @DisplayName("Проверка перехода на форму авторизации Apple")
    @Tag("Prod")
    void testSwitchingAuthorizationApple() {
        authorizationPage.openPage()
                .setRegistrationAndEnter()
                .setEnterApple()
                .setSwitchToWindow()
                .checkingTextApple();
    }

    @Test
    @DisplayName("Проверка перехода на форму авторизации VK")
    @Tag("Prod")
    void testSwitchingAuthorizationVK() {
        authorizationPage.openPage()
                .setRegistrationAndEnter()
                .setEnterVK()
                .setSwitchToWindow()
                .checkingTextVK();
    }

    @Test
    @DisplayName("Проверка перехода в другую категорию после закрытия фрейма уведомления")
    @Tag("Prod")
    void testTransitionAnotherCategoryAfterClosingFrame () {

        orderPage.openPage()
                .openHeaderMenu(categoryMenuGames)
                .clickCategory(subCategoryBlockConstructors)
                .closeFrame()
                .openHeaderMenu(categoryMenuSportAndRest)
                .clickCategory(categoryMenuSportAndRest)
                .checkTransitionToCategory(headerTextCategoryMenuSportAndRest);


    }

    @Test
    @DisplayName("Проверка оформления заказа способ оплаты картой онлайн")
    @Tag("Prod")
    void testSuccessfulTransitionOnPaymentForm() {

        orderPage.openPage()
                .openHeaderMenu(categoryMenuSportAndRest)
                .clickCategory(sucCategoryProductNamePupyrka)
                .closeFrame()
                .addedFirstProductToCart()
                .openCart()
                .addedQuantityProductInCart(defaultQuantityProduct)
                .clickOnButtonPlaceAnOrder()
                .personalDataUserInput()
                .deliveryAddressInput()
                .approveOrder()
                .payOnline(payWayWithCard)
                .checkTransitionToSberPay();
    }

    @Test
    @DisplayName("Проверка оформления подписки на скидки повторно на существующий email")
    @Tag("Prod")
    void testSubscriptionWithRegisteredEmail() {

        subscriptionPage.openPage()
                .setEmail(registeredEmail)
                .setEmailPressEnter()
                .checkInfoErrorSubscriptionEmail(resultValueRegisteredEmail);

    }
    @Test
    @DisplayName("Проверка оформления подписки на скидки")
    @Tag("Prod")
    void testSubscriptionWithNewEmail() {

        subscriptionPage.openPage()
                .setEmail(newEmail)
                .setEmailPressEnter()
                .checkInfoSuccessSubscription(resultValueNewEmail);

    }
    @Test
    @DisplayName("Проверка оформления подписки на скидки c невалидным e-mail адресом")
    @Tag("Prod")
    void testSubscriptionWithInvalidAddressEmail() {
        subscriptionPage.openPage()
                .setEmail(InvalidAddressEmail)
                .setEmailPressEnter()
                .checkInfoErrorSubscriptionEmail(resultInvalidEmail);

    }
}