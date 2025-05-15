package homework_17;

import com.google.gson.Gson;
import homework_17.utils.rest_assured.RegisterResponse;
import homework_17.utils.rest_assured.RegisterRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestAssuredTest {
    @Test
    public void testGetRequest() {
        RestAssured.given()
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

    @Test
    public void testPostRequest() {
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

    @Test
    void testPutRequest() {
        RestAssured.given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects/ff808181932badb60196b4a1da04656d")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "   \"name\": \"Apple MacBook Pro 16\",\n" +
                        "   \"data\": {\n" +
                        "      \"year\": 2019,\n" +
                        "      \"price\": 2049.99,\n" +
                        "      \"CPU model\": \"Intel Core i9\",\n" +
                        "      \"Hard disk size\": \"1 TB\",\n" +
                        "      \"color\": \"silver\"\n" +
                        "   }\n" +
                        "}")
                .when()
                .put()
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("jsonschema.json"));
    }

    @Test
    void testDeleteRequest() {
        RestAssured.given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects/ff808181932badb60196cb3211c20a0a")
                .when()
                .delete()
                .then()
                .statusCode(200)
                .body("message", equalTo("Object with id = ff808181932badb60196cb3211c20a0a has been deleted."));
    }
}