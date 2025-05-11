package homework_15.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

public class WireMockDeleteRequest {
    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer(8080);
        wireMockServer.start();

        String url = "http://localhost:8080";

        stubFor(delete(urlEqualTo("/api/deleteuser/5"))
                .willReturn(aResponse()
                        .withUniformRandomDelay(2000, 5000)
                        .withBody("User 5 is deleted")));

        given().baseUri(url).when().delete("/api/deleteuser/5");

        verify(deleteRequestedFor(urlEqualTo("/api/deleteuser/5")));

        wireMockServer.stop();
    }
}