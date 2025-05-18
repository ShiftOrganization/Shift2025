package homework_19.steps;

import io.cucumber.java.ru.Дано;
import homework_19.context.Context;

public class ClientSteps {
    @Дано("задан знак зодиака {string}")
    public void setZodiacName(String zodiacName) {
        Context.putContext("zodiacName", zodiacName);
    }
}
