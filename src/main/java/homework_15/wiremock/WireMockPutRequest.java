package homework_15.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

public class WireMockPutRequest {
    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer(8080);
        wireMockServer.start();

        String url = "http://localhost:8080";

        stubFor(put(urlEqualTo("/api/delay"))
                .willReturn(aResponse()
                        .withFixedDelay(4000)
                        .withBody("{\"message\": \"Delayed\"}")));

        given().baseUri(url).body("{\"id\":\"199\"}").when().put("/api/delay");

        verify(putRequestedFor(urlEqualTo("/api/delay"))
                .withRequestBody(matchingJsonPath("id", equalTo("199"))));

        wireMockServer.stop();
    }
}