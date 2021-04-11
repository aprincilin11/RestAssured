package org.requests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class PostRequest {
    @Test
    public void postRequestMethod() {
        RestAssured ra = new RestAssured();                        // // RestAssured is a class
        ra.baseURI = "https://reqres.in/";

        RequestSpecification req = RestAssured.given();           //RequestSpecification is an interface

        //We have to give the new resource to store in the server
        req.header("Content-Type","application/json");

        JSONObject jsonObj = new JSONObject();              // We are sending the resource as Jason form, we have added the dependency JSON
        jsonObj.put("name","Kamal");                        //JSON is lang independent so we r requested JSON format
        jsonObj.put("job","Tester");
        String stringJasonFormat = jsonObj.toJSONString();  // we r converting into JSON String
        req.body(stringJasonFormat);

        Response response = req.request(Method.POST, "/api/users"); // Posting the request,and store the response in a var.
        //Response is an Interface

        // Getting the status code and verifying the status code
        int resCode = response.getStatusCode();
        System.out.println("STATUS CODE IS:" + resCode);
        Assert.assertEquals(201, resCode);           //status code is 201 for posting

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
