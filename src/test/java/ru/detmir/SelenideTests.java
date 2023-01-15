package ru.detmir;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static pages.AuthorizationPage.*;
import static pages.OrderPage.*;
import static pages.SubscriptionPage.*;
import static userData.OrderDate.*;

public class SelenideTests extends TestBase{

    @Test
    @DisplayName("Проверка перехода на форму авторизации Apple")
    @Tag("Prod")
    void testSwitchingAuthorizationApple() {

        authorizationPage.openPage()
                .setRegistrationAndEnter()
                .setEnterButtonAutorization(nameButtonEnterApple)
                .setSwitchToWindow()
                .checkingTextAuthorizationApple(nameTextEnterApple);
    }
    @Test
    @DisplayName("Проверка перехода на форму авторизации Google")
    @Tag("Prod")
    void testSwitchingAuthorizationGoogle() {

        authorizationPage.openPage()
                .setRegistrationAndEnter()
                .setEnterButtonAutorization(nameButtonEnterGoogle)
                .setSwitchToWindow()
                .checkingTextAuthorizationGoogle(nameTextEnterGoogle);
    }
    @Test
    @DisplayName("Проверка перехода на форму авторизации VK")
    @Tag("Prod")
    void testSwitchingAuthorizationVk() {

        authorizationPage.openPage()
                .setRegistrationAndEnter()
                .setEnterButtonAutorization(nameButtonEnterVK)
                .setSwitchToWindow()
                .checkingTextAuthorizationVK(nameTextEnterVK);
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
                .personalDataUserInput(newName, newPhone, newEmail)
                .deliveryAddressInput(addressDeliveryDefault, apartmentNumberDefault)
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