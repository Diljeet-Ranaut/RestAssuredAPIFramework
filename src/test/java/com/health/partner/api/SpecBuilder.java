package com.health.partner.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(System.getProperty("BaseURI"))
                .setBasePath(Route.BASE_PATH)
                .addFilter(new AllureRestAssured())
                .setContentType(ContentType.JSON).log(LogDetail.ALL)
                .build();


    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                //.expectContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }
}
