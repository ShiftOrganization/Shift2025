package homework_19.steps;

import homework_19.context.Context;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HoroscopeSteps {

    @Когда("я отправляю запрос на гороскоп для этого знака")
    public void userSendsRequestByZodiac() {
        String zodiac = String.valueOf(Context.getContext("zodiacName"));

        Response response = RestAssured
                .given()
                .when()
                .get("https://ohmanda.com/api/horoscope/" + zodiac);

        Context.putContext("response_day_horoscope", response);
    }

    @Тогда("статус ответа должен быть {int}")
    public void checkResponseStatusCode(int responseStatus) {
        Response responseDayHoroscope = (Response) Context.getContext("response_day_horoscope");

        responseDayHoroscope
                .then()
                .statusCode(responseStatus);
    }

    @И("в ответе поле \"sign\" должно быть равно {string}")
    public void checkResponseSign(String expectedSign) {
        Response response = (Response) Context.getContext("response_day_horoscope");
        int statusCode = response.getStatusCode();

        if (statusCode == 200) {
            response.then().body("sign", Matchers.equalTo(expectedSign));
        } else if (statusCode == 404) {
            System.out.println("Для статус-кода 404 ответ не формата JSON, поэтому поле 'sign' не проверяется!");
        }
    }

    @И("в ответе должна быть сегодняшняя дата в поле \"date\"")
    public void checkResponseDate() {
        Response response = (Response) Context.getContext("response_day_horoscope");
        int statusCode = response.getStatusCode();

        if (statusCode == 200) {
            response.then().body("date", Matchers.equalTo(LocalDate.now().format(DateTimeFormatter.ISO_DATE)));
        } else if (statusCode == 404) {
            System.out.println("Для статус-кода 404 ответ не формата JSON, поэтому поле 'date' не проверяется!");
        }
    }
}