package homework_14;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest {
    public static void main(String[] args) {
        given()
                .baseUri("https://reqres.in")
                .basePath("/api/users/2")
                .header("x-api-key", "reqres-free-v1")
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", containsStringIgnoringCase("Janet"))
                .body("support.text", containsString("Tired of writing"));
    }
}