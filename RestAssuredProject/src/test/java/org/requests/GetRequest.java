package org.requests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class GetRequest {

    // We have add 3 dependencies rest assured,Jason(JSON.simple in maven repo),Hamcrest matchers and testNG before doing web services
    //- hamcrest matchers library(hamcrest matchers.core in maven repo) will filter the responses with particular person
    // We have to delete the scope code line in dependency of rest assured
    // After adding all the dependencies we have to see whether its available in external library on our left side
    // if its not we have to go to build-> rebuild
    // even though if it is not there then we have to go to maven(right side)->tool windows->maven and install(inside the life cycle) - we can view this using view icon on tool bar


    @Test
    public void getRequestMethod() {

        RestAssured ra = new RestAssured();
        ra.baseURI = "https://jsonplaceholder.typicode.com";
                                                                     // or -> RestAssured.baseURI = "https://jsonplaceholder.typicode.com"; -> RestAssured is a class
        RequestSpecification req = RestAssured.given();                  //RequestSpecification is an interface
        Response response        = req.request(Method.GET, "/posts"); // Sending the request,and store the response in a var."/posts" is an end url
                                                                       // Method is an Enum and having all the methods- GET, POST, POST, DELETE
        int resCode = response.getStatusCode();                        // Getting the status code and verifying the status code
        System.out.println("STATUS CODE IS:" + resCode);
        Assert.assertEquals(200, resCode);

        //Getting the status line and verifying it
        String resString = response.getStatusLine();
        System.out.println("STATUS LINE IS: " + resString);
        Assert.assertEquals("HTTP/1.1 200 OK", resString);

        //Requesting the Header
        System.out.println("HEADERS:" + response.getHeaders());

        // Now print the response the request body
        String responseBody = response.getBody().asString();
        System.out.println("RESPONSE BODY IS: " + responseBody);
    }
}

