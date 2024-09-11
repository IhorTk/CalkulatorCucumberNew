package NexteWoche;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NeusTests {
    @Test
    public void einTest() {
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/map")
                .andReturn();
        assertEquals(200, response.statusCode(), "Unexpected status code");
    }

    @Test
    public void einTest404() {
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/map2")
                .andReturn();
        assertEquals(404, response.statusCode(), "Unexpected status code");
    }

    @Test
    public void testHelloWorld() {
        JsonPath response = RestAssured
                .get("https://playground.learnqa.ru/api/hello")
                .jsonPath();
        String answer = response.getString("answer");
        assertEquals("Hello, someone" ,answer, "Unexpected status code");

    }

    @Test
    public void testHelloWorld1() {
        String name = "Username";

        JsonPath response = RestAssured
                .given()
                .queryParam("name", name)
                .get("https://playground.learnqa.ru/api/hello")
                .jsonPath();
        String answer = response.getString("answer");
        assertEquals("Hello, "+ name ,answer, "Unexpected status code");
    }
}
