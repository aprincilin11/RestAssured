package org.BDDApproach;

import io.restassured.http.ContentType;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class GETRequest extends Credentials {

    //Using BDD approach the response is gotten using the behaviour, same operations can be done GET,PUT,DELETE,POST
    @Test
    public void getRequest() {

        given().when().get("https://jsonplaceholder.typicode.com").then().statusCode(200).log().all();

         /* given() -> will define the preconditions for the request
        when()   -> action
        then()   -> Post conditions -  after the request - check the response with assertions
        log().all() will display the response fully with headers, body etc-
         200 is expected status code
          */
    }


    @Test
    public void postRequest() {
        // Basic Authentication

        given()
                .auth()
                .preemptive()
                //.basic(credentials.getUserId(), credentials.getPwd())  --> From Credentials class ref
                .basic("princilin.arulandu@gmail.com","$$$$$$$$$$")
                .contentType(ContentType.JSON)
                .body("\"name\": \"deleteme\"}")                    // here we need to give the body content whatever we need in POST
                .when()
                .post("https://api.hithub.com/delina/repos")
                .then()
                .statusCode(201)
                .log()
                .all();
    }

    @Test
    public void putRequest() {
        given()
                .auth()
                .preemptive()
                //.basic(credentials.getUserId(), credentials.getPwd())
                .basic("princilin.arulandu@gmail.com","$$$$$$$")
                .contentType(ContentType.JSON)
                .body("")                                         // here we need to give the body content whatever we need in POST
                .when()
                .put("https://api.hithub.com/delina/repos")
                .then()
                .statusCode(201)
                .log()
                .all();
    }

    @Test
    public void oAuth2Request(){
        //Creating the token first - This token will be active all the time(no expiration)- New token will be created everytime
        String token = given()
                .formParam("client_id","BarnBarn")
                .formParam("clientSecret", "fb8c9dc8e8291bd4b614b08b0bb708685d98820b")
                .formParam("grant_type","client_credentials")
                //.formParam("RedirectURI", "www.google.com")
                .when()
                .post("http://coop.apps.symfonycasts.com/token")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .get("access_token");
        System.out.println(token);

        // after getting the token we need to give it to our authentication

        given()
                .auth()
                .oauth2(token)
                .when()
                .post("http://coop.apps.symfonycasts.com/api/1809/barn-unlock")
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .response();
    }

    @Test
    public void deleteRequest() {

        given()
                .when()
                .delete("http://dummy.restapiexample.com/public/api/v1/delete/2")
                .then()
                .statusCode(200)
                .log().all();
    }
}
