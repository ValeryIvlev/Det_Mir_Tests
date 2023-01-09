package Pages;


import Components.FrameComponents;
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
    public static String sucCategoryProductNamePupyrka = "Пупырка-антистресс";
    public static String categoryMenuSportAndRest = "Спорт и отдых";
    public static String headerTextCategoryMenuSportAndRest = "Детские товары для спорта и отдыха\n";
    public static String defaultQuantityProduct = "10";
    public static String payWayWithCard = "Картой онлайн";
    private String addressDeliveryDefault = "Ленинский проспект, д 111к1, Москва";
    private String apartmentNumberDefault = "22";


    private SelenideElement
    headerMenu = $(".fr"),
    categoryMenu = $("main.c_0"),
    buttonCart = $(".f_ .L_9.rO.rJ"),
    inputQuantityProductInCart= $("[data-testid=productQuantityInput]"),
    inputName = $("#name"),
    inputEmail = $("#email"),
    inputPhone = $("#phone"),
    buttonChoicePay = $(".jj");
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
        $(".uD.uH.uG").$$(".r_5.r_9.uF").first().$(new ByText("В корзину")).click();
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
        $(".n_9").$(new ByText("Оформить заказ")).click();
        });
        return this;
    }
    public OrderPage personalDataUserInput() {
        step("Вводим данные клиента", () -> {
        inputName.sendKeys(newName);
        inputPhone.sendKeys("9"+newPhone);
        inputEmail.sendKeys(newEmail);
        $(".cB").$(new ByText("Далее")).click();
        });
        return this;
    }
    public OrderPage deliveryAddressInput() {
        step("Вводим данные для доставки", () -> {
        $(".bzg").$(new ByText("Доставка")).click();
        $("#street").sendKeys(addressDeliveryDefault);
        $("#apartment").click();
        $("#apartment").sendKeys(apartmentNumberDefault);
        sleep(1000);
        $(".bDw").$(new ByText("Далее")).click();
        sleep(5000);
        });
        return this;
    }
    public OrderPage approveOrder() {
        step("Подтверждаем заказ", () -> {
        $(".nP").$(new ByText("Далее")).click();
        });
        return this;
    }
    public OrderPage payOnline(String wayPay) {
        step("Выбираем способ оплаты", () -> {
        buttonChoicePay.$(new ByText(wayPay)).click();
        $(".jp").click();
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
