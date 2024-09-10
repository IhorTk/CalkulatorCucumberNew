package HomeWork;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class HomeWorkTest {
    @Test
    public void getAntwort() {
        Response response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/get_text")
                .andReturn();
        response.prettyPrint();
        response.print();
    }

//    https://playground.learnqa.ru/api/get_json_homework
    @Test
    void parsingJson() {
        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();

        ArrayList<Object> antwort = response.get("messages");
        System.out.println(antwort.get(1));
    }

    @Test
    void parsingJsonRedirects() {
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        String locationHeaders = response.getHeader("Location");
        System.out.println(locationHeaders);
    }
}
