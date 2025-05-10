package homework_14;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PutRequest {
    public static void main(String[] args) {
        given()
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
                .body(matchesJsonSchemaInClasspath("schema.json"));
    }
}