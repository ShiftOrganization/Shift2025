package homework_14;

import com.google.gson.Gson;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostRequest {
    public static void main(String[] args) {

        RegisterRequest request = new RegisterRequest("peter@klaven");
        Gson gson = new Gson();
        String jsonBody = gson.toJson(request);

        RegisterResponse response = given()
                .baseUri("https://reqres.in")
                .basePath("/api/login")
                .body(jsonBody)
                .header("x-api-key", "reqres-free-v1")
                .contentType("application/json")
                .when()
                .post()
                .then()
                .statusCode(400)
                .extract().as(RegisterResponse.class);

        assertEquals("Missing password", response.error);
    }
}