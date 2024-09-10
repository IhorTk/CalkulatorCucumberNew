import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HelloWorldTest {
    @Test
    public void testRestAssured(){
        Map<String,String> params = new HashMap<>();
        params.put("name", "John Snow");
       JsonPath response = RestAssured
               .given()
               .queryParams(params)
               .get("https://playground.learnqa.ru/api/hello")
               .jsonPath();

       String answer = response.get("answer");
       if(answer==null){
           System.out.println("The key 'answer4' is absent");
       }else{
           System.out.println(answer);
       }
    }

    @Test
    public void testRestAssured1(){
        Map<String, Object> body = new HashMap<>();
        body.put("param1", "Value1");
        body.put("param2", "Value2");

        Response response = RestAssured
                .given()
                .body(body)
                .post("https://playground.learnqa.ru/api/check_type")
                .andReturn();
        response.print();
        int statusCode = response.statusCode();
        System.out.println(statusCode);

    }

    @Test
    public void testRestAssured2(){
        Map<String,String> headers = new HashMap<>();
        headers.put("myHeader1","myValue1");
        headers.put("myHeader2","myValue2");

        Response response= RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/get_303")
                .andReturn();

        response.prettyPrint();

        System.out.println("=======================================================");

        String locationHeader = response.getHeader("Location");
        System.out.println(locationHeader);

        System.out.println("=======================================================");

        Headers responseHeaders = response.getHeaders();
        System.out.println(responseHeaders);

        System.out.println("=======================================================");

        int statusCode = response.statusCode();
        System.out.println(statusCode);
    }

    @Test
    public void testRestAssuredCookies(){
        Map<String,String> data = new HashMap<>();
        data.put("login","secret_login");
        data.put("password","secret_pass");

        Response responseForGet = RestAssured
                .given()
                .body(data)
                .when()
                .post("https://playground.learnqa.ru/api/get_auth_cookie")
                .andReturn();

//        System.out.println("\nPretty text: ");
//        response.prettyPrint();
//
//        System.out.println("\nHeaders: ");
//        Headers responseHeaders = response.getHeaders();
//        System.out.println(responseHeaders);
//
//        System.out.println("\nCookies: ");
//        Map<String,String> responseCookies = response.getCookies();
//        System.out.println(responseCookies);

        String responseCookie = responseForGet.getCookie("auth_cookie");
        System.out.println(responseCookie);

        Map<String,String> cookies = new HashMap<>();
        if (responseCookie !=null){
            cookies.put("auth_cookie", responseCookie);
        }


        Response responseForCheck = RestAssured
                .given()
                .body(data)
                .cookies(cookies)
                .when()
                .post("https://playground.learnqa.ru/api/check_auth_cookie")
                .andReturn();

        responseForCheck.print();
    }

}
