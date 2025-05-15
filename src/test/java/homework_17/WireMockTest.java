package homework_17;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.*;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

public class WireMockTest {
    private static WireMockServer wireMockServer = new WireMockServer(8080);
    private String url = "http://localhost";

    @BeforeAll
    static void startWireMock() {
        wireMockServer.start();
    }

    @AfterAll
    static void stopWireMock() {
        wireMockServer.stop();
    }

    @Test
    void testWireMockGetRequest() {
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
    }

    @Test
    void testWireMockPostRequest()  {
        stubFor(post(urlEqualTo("/api/create"))
                .willReturn(aResponse()
                        .withStatus(201)));

        given().baseUri(url).body("{\"user\":\"New User\"}").when().post("/api/create");

        verify(1, postRequestedFor(urlEqualTo("/api/create")));
    }

    @Test
    void testWireMockPutRequest() {
        stubFor(put(urlEqualTo("/api/delay"))
                .willReturn(aResponse()
                        .withFixedDelay(4000)
                        .withBody("{\"message\": \"Delayed\"}")));

        given().baseUri(url).body("{\"id\":\"199\"}").when().put("/api/delay");

        verify(putRequestedFor(urlEqualTo("/api/delay"))
                .withRequestBody(matchingJsonPath("id", equalTo("199"))));
    }

    @Test
    void testWireMockDeleteRequest() {
        stubFor(delete(urlEqualTo("/api/deleteuser/5"))
                .willReturn(aResponse()
                        .withUniformRandomDelay(2000, 5000)
                        .withBody("User 5 is deleted")));

        given().baseUri(url).when().delete("/api/deleteuser/5");

        verify(deleteRequestedFor(urlEqualTo("/api/deleteuser/5")));
    }
}