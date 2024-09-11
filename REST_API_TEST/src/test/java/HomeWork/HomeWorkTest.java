package HomeWork;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    public void pRedirects() {
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        String locationHeaders = response.getHeader("Location");
        System.out.println(locationHeaders);

        Headers headers = response.getHeaders();
        System.out.println(headers);
    }

    @Test
    public void longRedirects() {
        String locationHeaders = "https://playground.learnqa.ru/api/long_redirect";
        int statusCode;
        do {
            Response response = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(locationHeaders)
                    .andReturn();
            statusCode = response.statusCode();
            if (statusCode !=200) {
                locationHeaders = response.getHeader("Location");
            }
        }
        while (statusCode != 200);
        System.out.println("HURRRA" + " StatusCode :" + statusCode + " Letzte location" + locationHeaders + "  EVRIKA!!!");
    }

    @Test
    public void tockens() throws InterruptedException {
        Map<String,String> parameters = new HashMap<>();
        JsonPath jsonPath = RestAssured
                .given()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();
        String token = jsonPath.get("token");
        int time = jsonPath.get("seconds");
        System.out.println(token);
        System.out.println(time);
        parameters.put("token",token);
        Response response = RestAssured
                .given()
                .queryParams(parameters)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .andReturn();
        response.print();

        Thread.sleep(Duration.ofSeconds(time));
        Response response1 = RestAssured
                .given()
                .queryParams(parameters)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .andReturn();
        response1.print();
    }

}
