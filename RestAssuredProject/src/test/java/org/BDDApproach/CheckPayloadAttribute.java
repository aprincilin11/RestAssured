package org.BDDApproach;

//import org.junit.Test;

import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CheckPayloadAttribute {

    @Test
    public void simpleGetRequest() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .log()
                .all();

    }


    // to get the particular attribute from the Payload(body)
//    @Test
//    public void particularBody() {
//
//        given()
//
//                .when()
//                .get("https://reqres.in/api/users?page=2")
//                .then()
//                .statusCode(200)
//                .rootPath("data")
//                .body("email[0]", equalTo("michael.lawson@reqres.in"))
//                .body("data.first_name[1]", equalTo("value for the another att"))
//                .body("avator[0]", equalTo("https://reqres.in/img/faces/7-image.jpg"))
//                .log()
//                .body();
//    }
}
