import org.junit.jupiter.api.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RestTest {

    @Test
    void whenRequestThenOK() {
        when().request("GET", "https://jsonplaceholder.typicode.com/todos").then().statusCode(200);
    }

    @Test
    void getResponse(){
        given().when().get("https://jsonplaceholder.typicode.com/todos").then().log()
                .all();
    }

    @Test
    void getResponseId4(){
        given().queryParam("id","4")
                .when().get("https://jsonplaceholder.typicode.com/todos").then().body("title", hasItem("et porro tempora"));
    }

    @Test
    void getResponseId_198_199(){
        given().when().get("https://jsonplaceholder.typicode.com/todos").then().body("id", hasItems(198, 199));
    }


}
