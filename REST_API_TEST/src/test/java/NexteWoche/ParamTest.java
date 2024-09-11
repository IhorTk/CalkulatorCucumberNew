package NexteWoche;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParamTest {
    @ParameterizedTest
    @ValueSource(strings = {"","John Doe", "Piter"})
    public void testHelloWorldParam(String name){
        Map<String,String> parameters = new HashMap<>();

        if (name.length() > 0) {
            parameters.put("name", name);
        }
        JsonPath response = RestAssured
                .given()
                .queryParams(parameters)
                .get("https://playground.learnqa.ru/api/hello")
                .jsonPath();

        String answer = response.getString("answer");
        String expectedName = (name.length() > 0) ? name : "someone";
        assertEquals("Hello, " + expectedName, answer, "The answer is not expected");
    }

}
