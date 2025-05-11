package homework_15.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

public class WireMockGetRequest {
    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer(8080);
        wireMockServer.start();

        String url = "http://localhost:8080";

        stubFor(get(urlEqualTo("/api/user"))
                .withHeader("Connection", containing("keep-alive"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"id\" : \"15\"}")));

        given().baseUri(url).header("Connection", "keep-alive")
                .when().get("/api/user");

        verify(getRequestedFor(urlPathEqualTo("/api/user"))
                .withHeader("Connection", equalTo("keep-alive")));

        wireMockServer.stop();
    }
}