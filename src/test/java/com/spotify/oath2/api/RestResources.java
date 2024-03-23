package com.spotify.oath2.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static com.spotify.oath2.api.Route.*;
import static com.spotify.oath2.api.SpecBuilder.*;
import static io.restassured.RestAssured.given;

public class RestResources {

    public static Response post(String path, String token, Object playlist) {
        return given().spec(getRequestSpec())
                .body(playlist)
                .auth().oauth2(token)
                .when().post(path)
                .then().log().all().spec(getResponseSpec()).extract().response();
    }

    public static Response postAccount(HashMap<String, String> formParam, String clientIDSecret) {
        return given(getAccountRequestSpec())
                .header("Authorization", "Basic " + clientIDSecret)
                .formParams(formParam)
                .when()
                .post(API + TOKEN)
                .then().spec(getResponseSpec()).log().all().extract()
                .response();
    }

    public static Response get(String path, String token) {
        return given()
                .spec(getRequestSpec())
                .auth().oauth2(token)
                .when().get(path)
                .then().log().all().spec(getResponseSpec()).extract().response();
    }

    public static Response update(String path, String token, Object playlist) {
        return given().spec(getRequestSpec())
                .body(playlist)
                .auth().oauth2(token)
                .when().put(path)
                .then().log().all().spec(getResponseSpec())
                .extract().response();
    }
}
