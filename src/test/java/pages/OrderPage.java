package pages;


import components.FrameComponents;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static userData.OrderDate.*;

public class OrderPage {

    FrameComponents frameComponents = new FrameComponents();
    public static String categoryMenuGames = "Игрушки и игры";
    public static String subCategoryBlockConstructors = "Блочные конструкторы";
    public static String sucCategoryProductNamePupyrka = "Палатки";
    public static String categoryMenuSportAndRest = "Спорт и отдых";
    public static String headerTextCategoryMenuSportAndRest = "Детские товары для спорта и отдыха\n";
    public static String defaultQuantityProduct = "10";
    public static String payWayWithCard = "Картой онлайн";
    public static String addressDeliveryDefault = "Ленинский проспект, д 111к1, Москва";
    public static String apartmentNumberDefault = "22";
    private String deliveryNameButton = "Доставка";
    private String furtherLayoutNameButton = "Далее";


    private SelenideElement
    headerMenu = $("#app-container"),
    categoryMenu = $(".cM"),
    buttonCart = $("[data-testid=headerCartBlock]"),
    inputQuantityProductInCart= $("[data-testid=productQuantityInput]"),
    inputName = $("#name"),
    inputEmail = $("#email"),
    inputPhone = $("#phone"),
    buttonsChoicePay = $(".ix"),
    orderLayout = $(".lU"),
    deliveryLayout = $(".bzP");
    public OrderPage openPage() {
        step("Открываем главную страницу", () -> {
        open(baseUrl);
        });
        return this;
    }
    public OrderPage openHeaderMenu(String category) {
        step("Раскрываем категорию главного меню", () -> {
        headerMenu.$(new ByText(category)).hover();
        });
        return this;
    }
    public OrderPage clickCategory(String category) {
        step("Кликаем по выбранной категории", () -> {
        headerMenu.$(new ByText(category)).click();
        });
        return this;
    }
    public OrderPage checkTransitionToCategory (String text) {
        step("Проверяем успешный переход к категории", () -> {
        categoryMenu.shouldHave(text(text));
        });
        return this;
    }
    public OrderPage closeFrame() {
        step("Закрываем фрейм", () -> {
        frameComponents.closeFrame();
        });
        return this;
    }
    public OrderPage addedFirstProductToCart() {
        step("Выбираем первый товар из списка", () -> {
        $(".u_6.va.u_9").$$(".qZ.q_2.u_8").first().$(new ByText("В корзину")).click();
        });
        return this;
    }
    public OrderPage openCart() {
        step("Открываем корзину", () -> {
        buttonCart.click();
        });
        return this;
    }
    public OrderPage addedQuantityProductInCart(String Quantity) {
        step("Меняем количество товара", () -> {
        inputQuantityProductInCart.sendKeys(Quantity);
        });
        return this;
    }
    public OrderPage clickOnButtonPlaceAnOrder() {
        step("Кликаем по кнопке оформления заказа", () -> {
        orderLayout.$(new ByText("Оформить заказ")).click();
        });
        return this;
    }
    public OrderPage personalDataUserInput(String name, String phone, String email) {
        step("Вводим данные клиента", () -> {
        inputName.sendKeys(name);
        inputPhone.sendKeys("9"+phone);
        inputEmail.sendKeys(email);
        orderLayout.$(new ByText(furtherLayoutNameButton)).click();
        });
        return this;
    }
    public OrderPage deliveryAddressInput(String street, String apartment) {
        step("Вводим данные для доставки", () -> {
        deliveryLayout.$(new ByText(deliveryNameButton)).click();
        $("#street").sendKeys(street);
        $("#apartment").click();
        $("#apartment").sendKeys(apartment);
        sleep(1000);
        deliveryLayout.$(new ByText(furtherLayoutNameButton)).click();
        sleep(5000);
        });
        return this;
    }
    public OrderPage approveOrder() {
        step("Подтверждаем заказ", () -> {
        orderLayout.$(new ByText(furtherLayoutNameButton)).click();
        });
        return this;
    }
    public OrderPage payOnline(String wayPay) {
        step("Выбираем способ оплаты", () -> {
        buttonsChoicePay.$(new ByText(wayPay)).click();
        buttonsChoicePay.$(new ByText("Оплатить онлайн")).click();
        });
        return this;
    }
    public OrderPage checkTransitionToSberPay() {
        step("Проверяем успешный переход на форму оплаты сбербанка", () -> {
        $("[data-test-id=box-title]").shouldHave(text("SberPay"));
        });
        return this;
    }
}
