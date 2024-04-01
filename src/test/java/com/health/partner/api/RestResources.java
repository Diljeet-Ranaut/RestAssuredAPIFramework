package com.health.partner.api;

import com.health.partner.pojo.payload.Practitioners_Pojo;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RestResources {


    public static Response postPrc(String path, Practitioners_Pojo prc, String filePath) {
        return given().spec(SpecBuilder.getRequestSpec()).
                body(prc).
                when().
                post(path).
                then().log().all().assertThat().body(matchesJsonSchemaInClasspath(filePath)).extract().response();


    }
}
