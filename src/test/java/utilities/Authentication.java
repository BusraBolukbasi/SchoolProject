package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authentication {
    public static void main(String[] args) {
        String s = generateToken();
        System.out.println(s);
    }
    public static String generateToken(){
        String body = "{\n" +
                "    \"password\": \"AdminTeam09Admin\",\n" +
                "    \"username\": \"AdminTeam09Admin\"\n" +
                "}";
        Response response = given().body(body).contentType(ContentType.JSON).when().post("https://managementonschools.com/app/auth/login");
        String returnToken = response.jsonPath().getString("token");
//        String[] split = returnToken.split(" ");
//        String token =split[1];
        return returnToken;
    }
}

