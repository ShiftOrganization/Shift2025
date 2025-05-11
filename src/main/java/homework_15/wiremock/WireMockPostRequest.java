package homework_15.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

public class WireMockPostRequest {
    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer(8080);
        wireMockServer.start();

        String url = "http://localhost:8080";

        stubFor(post(urlEqualTo("/api/create"))
                .willReturn(aResponse()
                        .withStatus(201)));

        given().baseUri(url).body("{\"user\":\"New User\"}").when().post("/api/create");

        verify(1, postRequestedFor(urlEqualTo("/api/create")));

        wireMockServer.stop();
    }
}