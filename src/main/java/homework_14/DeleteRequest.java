package homework_14;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DeleteRequest {
    public static void main(String[] args) {
        given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects/ff808181932badb60196b4b6858d65a3")
                .when()
                .delete()
                .then()
                .statusCode(200)
                .body("message", equalTo("Object with id = ff808181932badb60196b4b6858d65a3 has been deleted."));
    }
}