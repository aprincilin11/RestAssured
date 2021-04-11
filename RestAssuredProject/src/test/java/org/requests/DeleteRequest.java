package org.requests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class DeleteRequest {
    @Test
    public void deleteRequestMethod() {
        RestAssured ra = new RestAssured();     // RestAssured is a class
        ra.baseURI = "https://reqres.in/";

        RequestSpecification req = RestAssured.given();           //RequestSpecification is an interface

        //We have to give the new resource to store in the server
        req.header("Content-Type","application/json");

        JSONObject jsonObj = new JSONObject();     // We are sending the resource as Jason form, we have added the dependency JSON

        jsonObj.put("name","Kamal");
        jsonObj.put("job","Developer");          // changing the job QA into Developer
        String stringJasonFormat = jsonObj.toJSONString();  // we r converting into JSON String
        req.body(stringJasonFormat);            // Displaying only the body part

        //Response response = req.request(Method.GET, "/api/users?page=2");  // to see the updates we can use like this
        Response response = req.request(Method.DELETE, "/api/users/2"); // Updating the request,and store the response in a var.


        // Getting the status code and verifying the status code
        int resCode = response.getStatusCode();
        System.out.println("STATUS CODE IS:" + resCode);
        Assert.assertEquals(204, resCode);  //status code is 200 for updating

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
