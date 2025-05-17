package homework_18.step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.util.List;
import java.util.Map;

public class MyStepDefs {
    @Дано("Пользователь {string} с email {string}")
    public void showUserInfo(String userName, String userEmail) {
        System.out.println("=====================================================================");
        System.out.println("Здравствуйте, " + userName + ". Ваш email: " + userEmail);
    }

    @И("в корзине есть следующие товары:")
    public void showGoodsInShoppingCart(DataTable dataTable) {
        System.out.println("В Вашей корзине есть следующие товары:");
        List<Map<String, String>> entries = dataTable.entries();
        entries.forEach(System.out::println);
    }

    @И("выбран способ оплаты {string}")
    public void setPaymentMethod(String paymentMethod) {
        System.out.println("Ваш способ оплаты: " + paymentMethod);
    }

    @И("выбран способ доставки {string}")
    public void setDeliveryMethod(String deliveryMethod) {
        System.out.println("Ваш способ доставки: " + deliveryMethod);
    }

    @Когда("пользователь подтверждает заказ")
    public void confirmOrder() {
        System.out.println("Ваш заказ подтвержден!");
    }

    @Тогда("система отправляет письмо с подтверждением на email {string}")
    public void sendConfirmationToEmail(String userEmail) {
        System.out.println("Письмо с подтверждением заказа отправлено на Ваш email: " + userEmail);
    }

    @И("формирует заказ с номером {string}")
    public void setOrder(String orderId) {
        System.out.println("Заказ с номером " + orderId + " сформирован!");
    }

    @И("отображает сообщение: {string}")
    public void showConfirmationMessage(String confirmationMessage) {
        System.out.println(confirmationMessage);
        System.out.println("=====================================================================");
    }
}
